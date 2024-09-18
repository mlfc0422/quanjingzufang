package com.mlfc.yonghu.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mlfc.api", "com.mlfc.yonghu"})
public class consumerApplicationYong {
    public static void main(String[] args) {
        SpringApplication.run(consumerApplicationYong.class, args);
    }
}
