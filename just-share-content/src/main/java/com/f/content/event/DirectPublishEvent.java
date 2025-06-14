package com.f.content.event;

import com.f.content.domain.UserPublishContent;
import org.springframework.context.ApplicationEvent;

public class DirectPublishEvent extends ApplicationEvent {
    private UserPublishContent content;

    public DirectPublishEvent(Object source, UserPublishContent content) {
        super(source);
        this.content = content;
    }
}