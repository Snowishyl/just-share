package com.f.content.event.listener;

import com.f.content.domain.entity.UserShare;
import com.f.content.domain.entity.UserShareFiles;
import com.f.content.event.DirectPublishEvent;
import com.f.content.service.UserShareService;
import com.f.justsharecommon.util.SnowflakeIdWorker;
import com.f.justsharecommon.domain.Content;
import com.f.minioconfiguration.minio.MinioService;
import jakarta.annotation.Resource;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Component
@RequiredArgsConstructor
public class UserPublishListener {
    @Resource(name = "snowflakeIdWorkerContent")
    private  SnowflakeIdWorker snowflakeIdWorker;
    private final UserShareService userShareService;
    private final MinioService minioService;

    @EventListener(DirectPublishEvent.class)
    @Transactional(rollbackFor = Exception.class)
    public void handleUserRegisterEvent(DirectPublishEvent event) {
        //todo 文件上传，内容入库
        Content content = event.getContent().getContent();
        //延时发布
        boolean closeAble = content.getTaskInfo().getCloseAble();
        //发布规则
        Byte publishRule = content.getPublishRule();
        //生成唯一文章id,延用毕设的那个，todo: 改用分段算法

        long contentId = snowflakeIdWorker.nextId();
        UserShare userShare = UserShare.builder()
                .publishRule(publishRule)
                .contentId(contentId)
                .userid(content.getUser().getId())
                .closeAble(closeAble)
                .build();
        userShareService.insert(userShare);
        //文件上传
        List<MultipartFile> files = event.getContent().getFiles();
        List<String> urls = minioService.uploadFiles(files);
        //todo ats入库
        //todo 屏蔽用户入库
        //todo 记录本地消息表
    }
}