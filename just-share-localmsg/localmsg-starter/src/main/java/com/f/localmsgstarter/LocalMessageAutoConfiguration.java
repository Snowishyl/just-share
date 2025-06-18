package com.f.localmsgstarter;

import com.f.localmsgstarter.domain.LocalMessageProperties;
import com.f.localmsgstarter.mapper.LocalMessageMapper;
import com.f.localmsgstarter.service.LocalMessageService;
import com.f.localmsgstarter.service.impl.LocalMessageServiceImpl;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableConfigurationProperties(LocalMessageProperties.class)
@ConditionalOnProperty(prefix = "local-message", name = "enabled", havingValue = "true", matchIfMissing = true)
public class LocalMessageAutoConfiguration {

    @Bean
    @ConditionalOnMissingBean
    public LocalMessageService localMessageService(LocalMessageMapper mapper, LocalMessageProperties props) {
        return new LocalMessageServiceImpl(mapper, props);
    }
}
