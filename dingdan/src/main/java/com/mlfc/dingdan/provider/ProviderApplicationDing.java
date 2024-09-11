package com.mlfc.dingdan.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@MapperScan("com.mlfc.dingdan.provider.mapper")
@SpringBootApplication
public class ProviderApplicationDing {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationDing.class, args);
    }
}
