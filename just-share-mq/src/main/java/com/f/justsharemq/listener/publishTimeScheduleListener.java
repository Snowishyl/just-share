package com.f.justsharemq.listener;

import com.f.justsharecommon.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/21
 * @Description:
 */
@Component
@Slf4j
public class publishTimeScheduleListener {


    @RabbitListener(queues = RabbitConfig.DEAD_QUEUE)
    public void receive(String msg) {
        log.error("收到延时处理消息：{}，时间：{}", msg, LocalDateTime.now());
    }

}
