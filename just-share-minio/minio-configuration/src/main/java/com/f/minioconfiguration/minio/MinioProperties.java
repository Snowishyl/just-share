package com.f.minioconfiguration.minio;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/13
 * @Description:
 */
@ConfigurationProperties(prefix = "minio")
@Data
public class MinioProperties {
    private String endpoint;
    private String accessKey;
    private String secretKey;
    private String bucket;
    private Boolean secure = true;
}