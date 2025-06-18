package com.f.localmsgstarter.service.impl;

import com.alibaba.fastjson2.JSON;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.f.localmsgstarter.domain.LocalMessage;
import com.f.localmsgstarter.domain.LocalMessageProperties;
import com.f.localmsgstarter.mapper.LocalMessageMapper;
import com.f.localmsgstarter.service.LocalMessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;
import java.util.function.Consumer;
import java.util.function.Function;

/**
 * @author fewioscun
 * 本地消息表操作数据库相关方法
 */
@Service
@RequiredArgsConstructor
public class LocalMessageServiceImpl implements LocalMessageService {
    private final LocalMessageMapper messageMapper;
    private final LocalMessageProperties properties;

    @Override
    public void saveMessage(String topic, String tag, Object payload) {
        String json = JSON.toJSONString(payload);
        messageMapper.insert(LocalMessage.builder()
                .messageId(UUID.randomUUID().toString())
                .payload(json)
                .topic(topic)
                .tag(tag)
                .status(0)
                .retryCount(0)
                .maxRetry(properties.getMaxRetry())
                .nextRetryTime(LocalDateTime.now().plusSeconds(properties.getRetryIntervalSeconds()))
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build());
    }

    @Override
    public List<LocalMessage> getPendingMessages(int limit, String topic, String tag) {
        return messageMapper.selectPendingMessages(limit, topic, tag);
    }

    /**
     * 提供Consumer接口，用作扩展
     *
     * @param limit
     * @param topic
     * @param tag
     * @param consumer
     */
    @Override
    public void getAndConsumeMessages(int limit, String topic, String tag,
                                      Consumer<List<LocalMessage>> consumer) {
        List<LocalMessage> localMessages = messageMapper.selectPendingMessages(limit, topic, tag);
        consumer.accept(localMessages);
    }
    /**
     * 提供Consumer接口，用作扩展
     *
     * @param limit
     * @param topic
     * @param tag
     * @param function
     */
    @Override
    public <R> R getAndConsumeMessages(int limit, String topic, String tag,
                                       Function<List<LocalMessage>, R> function) {
        List<LocalMessage> localMessages = messageMapper.selectPendingMessages(limit, topic, tag);
        return function.apply(localMessages);
    }

    @Override
    public void markSuccess(String messageId) {
        LambdaUpdateWrapper<LocalMessage> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(LocalMessage::getMessageId, messageId)
                .set(LocalMessage::getStatus, 1);
        messageMapper.update(null, wrapper);

    }

    @Override
    public void markFailed(String messageId) {
        LambdaUpdateWrapper<LocalMessage> wrapper = Wrappers.lambdaUpdate();
        wrapper.eq(LocalMessage::getMessageId, messageId)
                .set(LocalMessage::getStatus, 0);
        messageMapper.update(null, wrapper);
    }

    @Override
    public void incrementRetry(String messageId) {
        UpdateWrapper<LocalMessage> wrapper = new UpdateWrapper<>();
        wrapper.eq("message_id", messageId)
                .lt("retry_count", properties.getMaxRetry()) // 加上最大次数限制
                .setSql("retry_count = retry_count + 1")
                .set("next_retry_time", LocalDateTime.now().plusSeconds(
                        (long) properties.getRetryIntervalSeconds() * 2
                ));

        messageMapper.update(null, wrapper);

    }
}
