package com.f.content.config;

import com.f.justsharecommon.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/18
 * @Description:
 */
@Configuration
public class ContentSnowConfiguration {

    @Bean(name = "snowflakeIdWorkerContent")
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker(1, 1);
    }
}
