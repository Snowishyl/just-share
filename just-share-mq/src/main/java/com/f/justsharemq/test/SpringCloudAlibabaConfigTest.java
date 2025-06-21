package com.f.justsharemq.test;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

/**
 * @Author: feiwoscun
 * @Date: 2025/6/21
 * @Description:
 */
@Component
public class SpringCloudAlibabaConfigTest implements ApplicationRunner {
    @Value("${spring.test}")
    private String test;


    @Override
    public void run(ApplicationArguments args) throws Exception {
        System.out.println(test);
    }
}
