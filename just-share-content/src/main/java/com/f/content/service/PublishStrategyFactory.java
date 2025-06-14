package com.f.content.service;

import com.f.content.domain.UserPublishContent;
import com.f.content.event.DirectPublishEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/14
 * @Description: 事件工厂
 */
@Component
@RequiredArgsConstructor
public class PublishStrategyFactory {

    private final ApplicationEventPublisher applicationEventPublisher;
    public void publish(Byte rule, UserPublishContent userPublishContent) {
        switch (rule) {
            //公开发布，触发直接发布事件
            case 1:
                applicationEventPublisher.publishEvent(new DirectPublishEvent(this, userPublishContent));
            default:
        }
    }

}
