package com.mlfc.fangyuan.consumer.controller;

import apiserrvice.FangyuanService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FangyuanController {

    @DubboReference
    private FangyuanService fangyuanService;

    @GetMapping("/getLocalDateTime")
    public String getLocalDateTime() {
        return fangyuanService.getLocalDateTime().toString();
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("test");

    }
}
