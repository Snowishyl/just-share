package com.f.justshareuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@MapperScan(basePackages = "com.f")
@ComponentScan("com.f")
public class JustShareUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustShareUserApplication.class, args);
    }

}
