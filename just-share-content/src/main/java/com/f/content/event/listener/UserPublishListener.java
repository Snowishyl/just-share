package com.f.content.event.listener;

import com.f.content.domain.UserPublishContent;
import com.f.content.domain.entity.UserShare;
import com.f.content.domain.entity.UserShareAt;
import com.f.content.domain.entity.UserShareFiles;
import com.f.content.domain.entity.UserShareShield;
import com.f.content.event.DirectPublishEvent;
import com.f.content.mapper.UserShareAtMapper;
import com.f.content.mapper.UserShareFilesMapper;
import com.f.content.mapper.UserShareShieldMapper;
import com.f.content.service.UserShareService;
import com.f.justsharecommon.entity.User;
import com.f.justsharecommon.util.SnowflakeIdWorker;
import com.f.justsharecommon.domain.Content;
import com.f.localmsgstarter.mapper.LocalMessageMapper;
import com.f.localmsgstarter.service.LocalMessageService;
import com.f.minioconfiguration.minio.MinioService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
@Slf4j
public class UserPublishListener {
    @Resource(name = "snowflakeIdWorkerContent")
    private SnowflakeIdWorker snowflakeIdWorker;
    private final UserShareService userShareService;
    private final MinioService minioService;
    private final UserShareShieldMapper userShareShieldMapper;
    private final UserShareAtMapper userShareAtMapper;
    private final LocalMessageService localMessageService;

    @EventListener(DirectPublishEvent.class)
    @Transactional(rollbackFor = Exception.class)
    public void handleUserRegisterEvent(DirectPublishEvent event) {
        //todo 文件上传，内容入库
        UserPublishContent publishContent = event.getContent();

        Content content = publishContent.getContent();
        //延时发布
        boolean closeAble = content.getTaskInfo().getCloseAble();
        //发布规则
        Byte publishRule = content.getPublishRule();
        //用户id
        final Long userId = content.getUser().getId();
        //生成唯一文章id,延用毕设的那个，todo: 改用分段算法

        long contentId = snowflakeIdWorker.nextId();
        log.info("userId {}", userId);
        UserShare userShare = UserShare.builder()
                .publishRule(publishRule)
                .contentId(contentId)
                .userid(userId)
                .closeAble(closeAble)
                .build();
        userShareService.insert(userShare);
        //todo 看用什么办法解决这个定时发布这个问题，mq
        //文件上传
        List<MultipartFile> files = publishContent.getFiles();
        List<String> urls = minioService.uploadFiles(files);
        log.info("minio上传成功，共计{}条", urls.size());
        //ats入库

        List<UserShareAt> users = content.getAts().stream()
                .map(t -> UserShareAt.builder()
                        .userAtId(userId)
                        .userAtedId(t.getId())
                        .ifCheck(false)
                        .contentId(contentId)
                        .build())
                .toList();
        Integer nums = userShareAtMapper.batchInsert(users);
        log.info("ats入库，共计{}条", nums);
        //屏蔽用户入库

        List<UserShareShield> shieldList = content.getAts().stream()
                .map(t -> UserShareShield.builder()
                        .userId(userId)
                        .shieldUserId(t.getId())
                        .build())
                .toList();
        Integer shieldNums = userShareShieldMapper.batchInsert(shieldList);
        log.info("user{}屏蔽用户入库，共计{}条", userId, nums);

        //记录本地消息表
        String localMsgId = publishContent.getLocalMsgId();
        if (StringUtils.hasText(localMsgId)) {
            localMessageService.markSuccess(localMsgId);
        }
    }
}