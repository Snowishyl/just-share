package com.f.justshareuser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication
@MapperScan(basePackages = "com.f.justshareuser.mapper")
public class JustShareUserApplication {

    public static void main(String[] args) {
        SpringApplication.run(JustShareUserApplication.class, args);
    }

}
