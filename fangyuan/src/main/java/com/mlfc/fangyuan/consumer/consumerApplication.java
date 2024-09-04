package com.mlfc.fangyuan.consumer;

import com.mlfc.fangyuan.api.FangyuanService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
public class consumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(consumerApplication.class, args);
    }

}
