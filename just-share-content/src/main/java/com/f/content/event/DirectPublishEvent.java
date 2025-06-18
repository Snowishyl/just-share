package com.f.content.event;

import com.f.content.domain.UserPublishContent;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.context.ApplicationEvent;

/**
 * @author feiwosucn
 */
@Getter
public class DirectPublishEvent extends ApplicationEvent {
    private final UserPublishContent content;

    public DirectPublishEvent(Object source, UserPublishContent content) {
        super(source);
        this.content = content;
    }
}