package com.mlfc.yonghu.provider;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableDubbo
@MapperScan("com.mlfc.yonghu.provider.mapper")
@SpringBootApplication
public class providerApplicationYong {
    public static void main(String[] args) {
        SpringApplication.run(providerApplicationYong.class, args);
    }
}
