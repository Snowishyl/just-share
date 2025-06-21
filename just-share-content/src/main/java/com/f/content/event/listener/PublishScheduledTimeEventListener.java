package com.f.content.event.listener;

import com.f.content.event.PublishScheduledTimeEvent;
import com.f.content.mq.RabbitMessageSender;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/20
 * @Description:
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class PublishScheduledTimeEventListener {

    private final RabbitMessageSender rabbitMessageSender;
    private final SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    @EventListener(PublishScheduledTimeEvent.class)
    public void handleUserRegisterEvent(PublishScheduledTimeEvent event) {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            String msg = objectMapper.writeValueAsString(event);
            Date scheduledTime = event.getScheduledTime().getScheduledTime();
            Date now = new Date();
            //延时队列计算
            long diff = scheduledTime.getTime() - now.getTime();
            rabbitMessageSender.sendDelayMessage(msg, String.valueOf(diff));
        } catch (JsonProcessingException e) {
            log.error(e.getMessage());
            throw new RuntimeException(e);
        }
    }
}
