package com.f.content.factory;

import com.f.justsharecommon.entity.dto.PublishScheduledTimeDTO;
import com.f.content.domain.UserPublishContent;
import com.f.content.event.DirectPublishEvent;
import com.f.content.event.PublishScheduledTimeEvent;
import com.f.justsharecommon.util.SnowflakeIdWorker;
import jakarta.annotation.Resource;
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
    @Resource(name = "snowflakeIdWorkerContent")
    private SnowflakeIdWorker snowflakeIdWorker;
    private final ApplicationEventPublisher applicationEventPublisher;

    public void publish(Byte rule, UserPublishContent userPublishContent) {
        switch (rule) {
            //公开发布，触发直接发布事件
            case 1:
                long id = snowflakeIdWorker.nextId();
                applicationEventPublisher.publishEvent(new DirectPublishEvent(this, userPublishContent));
            default:
        }
    }

    /**
     * 文章发布的定时任务
     *
     * @param publishScheduledTimeDTO 定时任务domain
     */
    public void publishScheduledTime(PublishScheduledTimeDTO publishScheduledTimeDTO) {
        applicationEventPublisher.publishEvent(new PublishScheduledTimeEvent(this, publishScheduledTimeDTO));

    }

}
