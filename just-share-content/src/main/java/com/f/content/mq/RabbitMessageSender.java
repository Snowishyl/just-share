package com.f.content.mq;

import com.f.justsharecommon.config.RabbitConfig;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class RabbitMessageSender {


    private final RabbitTemplate rabbitTemplate;

    public void sendDelayMessage(String msg, String delayMillis) {
        rabbitTemplate.convertAndSend(
                RabbitConfig.DELAY_EXCHANGE,
                RabbitConfig.DELAY_ROUTING_KEY,
                msg,
                message -> {
                    // 设置过期时间
                    message.getMessageProperties().setExpiration(delayMillis);
                    return message;
                });
        log.info("发送延时消息：{}，延迟：{}ms", msg, delayMillis);
    }
}
