package com.mlfc.dingdan.consumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.mlfc.api", "com.mlfc.dingdan"})
public class consumerApplicationDing {
    public static void main(String[] args) {
        SpringApplication.run(consumerApplicationDing.class, args);
    }

}
