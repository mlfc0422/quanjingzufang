package com.mlfc.fangyuan.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mlfc.api", "com.mlfc.fangyuan"})
public class consumerApplicationFang {
    public static void main(String[] args) {
        SpringApplication.run(consumerApplicationFang.class, args);
    }

}
