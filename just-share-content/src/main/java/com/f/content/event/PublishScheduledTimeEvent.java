package com.f.content.event;

import com.f.justsharecommon.entity.dto.PublishScheduledTimeDTO;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/20
 * @Description:
 */
@Getter
public class PublishScheduledTimeEvent extends ApplicationEvent {
    private final PublishScheduledTimeDTO scheduledTime;


    public PublishScheduledTimeEvent(Object source, PublishScheduledTimeDTO publishScheduledTimeDTO) {
        super(source);
        this.scheduledTime = publishScheduledTimeDTO;
    }
}
