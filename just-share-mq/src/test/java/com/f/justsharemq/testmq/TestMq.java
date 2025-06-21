package com.f.justsharemq.testmq;

import com.f.justsharemq.producer.RabbitMessageSender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.concurrent.TimeUnit;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/21
 * @Description:
 */
@SpringBootTest
public class TestMq {
    @Autowired
    private RabbitMessageSender rabbitMessageSender;

    @Test
    public void test() {
        rabbitMessageSender.sendDelayMessage("test", 1000);
        try {
            TimeUnit.SECONDS.sleep(5);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

}

