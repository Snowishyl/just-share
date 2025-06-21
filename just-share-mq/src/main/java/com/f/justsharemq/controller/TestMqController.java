package com.f.justsharemq.controller;

import com.f.justsharemq.producer.RabbitMessageSender;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/21
 * @Description:
 */
@RequiredArgsConstructor
@RestController
@RequestMapping("/mq")
@Slf4j
public class TestMqController {
    private final RabbitMessageSender rabbitMessageSender;

    @GetMapping("/test")
    public String testMq() {
        rabbitMessageSender.sendDelayMessage("test", 10000);
        log.error("test mq");
        return "test mq";
    }
}
