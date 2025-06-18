package com.f.localmsgstarter.domain;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties(prefix = "local-message")
@Data
public class LocalMessageProperties {
    private boolean enabled = true;
    private int maxRetry = 5;
    private int retryIntervalSeconds = 60;
}
