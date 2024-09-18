package com.mlfc.fangyuan.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@EnableDubbo
@MapperScan("com.mlfc.fangyuan.provider.mapper")
@ComponentScan(basePackages = {"com.mlfc.api", "com.mlfc.fangyuan"})
@SpringBootApplication
public class ProviderApplicationFang {
    public static void main(String[] args) {
        SpringApplication.run(ProviderApplicationFang.class, args);
    }
}
