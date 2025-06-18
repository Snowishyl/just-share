package com.f.minioconfiguration.minio;

import com.f.justsharecommon.util.SnowflakeIdWorker;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/18
 * @Description:
 */
@Configuration
public class MinioSnowConfiguration {

    @Bean(name = "snowflakeIdWorkerMinio")
    public SnowflakeIdWorker snowflakeIdWorker() {
        return new SnowflakeIdWorker(0, 0);
    }
}
