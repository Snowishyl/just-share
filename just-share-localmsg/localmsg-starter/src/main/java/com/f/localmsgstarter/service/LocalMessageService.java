package com.f.localmsgstarter.service;

import com.f.localmsgstarter.domain.LocalMessage;

import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public interface LocalMessageService {
    void saveMessage(String topic, String tag, Object payload);
    public List<LocalMessage> getPendingMessages(int limit,String topic,String tag);

    void getAndConsumeMessages(int limit, String topic, String tag,
                               Consumer<List<LocalMessage>> consumer);

    <R> R getAndConsumeMessages(int limit, String topic, String tag,
                                Function<List<LocalMessage>, R> function);

    void markSuccess(String messageId);
    void markFailed(String messageId);
    void incrementRetry(String messageId);
}
