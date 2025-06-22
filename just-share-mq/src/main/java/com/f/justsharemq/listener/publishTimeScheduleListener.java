package com.f.justsharemq.listener;

import com.f.justsharecommon.config.RabbitConfig;
import com.f.justsharecommon.entity.UserShare;
import com.f.justsharecommon.entity.dto.PublishScheduledTimeDTO;
import com.f.justsharemq.mapper.UserShareMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.json.JsonMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/21
 * @Description:
 */
@Component
@Slf4j
@RequiredArgsConstructor
public class publishTimeScheduleListener {
    private final UserShareMapper userShareMapper;

    @RabbitListener(queues = RabbitConfig.DEAD_QUEUE)
    @Transactional(rollbackFor = Exception.class)
    public void receive(String msg) {
        log.info("收到延时处理消息：{}，时间：{}", msg, LocalDateTime.now());
        JsonMapper jsonMapper = new JsonMapper();
        try {
            PublishScheduledTimeDTO schedule = jsonMapper.readValue(msg, PublishScheduledTimeDTO.class);
            UserShare userShare = userShareMapper.queryByContentId(schedule.getContentId());
            if (userShare == null
                    || userShare.getCloseable() != false
                    || userShare.getScheduledTime().getTime() - new Date().getTime() > 0) {
                log.info("没有到达修改为公开的条件，文章id: {}", schedule.getContentId());
                return;
            }
            UserShare build = UserShare.builder()
                    .id(userShare.getId())
                    .contentId(schedule.getContentId())
                    .userId(schedule.getUserId())
                    .closeable(true)
                    .build();
            userShareMapper.update(build);
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
        log.info("处理完成：{}，时间：{}", msg, LocalDateTime.now());
    }

}
