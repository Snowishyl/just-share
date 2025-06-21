package com.f.justsharecommon.config;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/21
 * @Description:
 */
public class RabbitConfig {
    // 交换机名称
    public static final String DELAY_EXCHANGE = "delay.exchange";
    public static final String DELAY_QUEUE = "delay.queue";
    public static final String DELAY_ROUTING_KEY = "delay.key";

    public static final String DEAD_LETTER_EXCHANGE = "dead.exchange";
    public static final String DEAD_QUEUE = "dead.queue";
    public static final String DEAD_ROUTING_KEY = "dead.key";
}
