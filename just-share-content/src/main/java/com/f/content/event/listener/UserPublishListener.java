package com.f.content.event.listener;

import com.f.content.event.DirectPublishEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class UserPublishListener {

    @EventListener(DirectPublishEvent.class)
    public void handleUserRegisterEvent(DirectPublishEvent event) {
        //todo 文件上传，内容入库
    }
}