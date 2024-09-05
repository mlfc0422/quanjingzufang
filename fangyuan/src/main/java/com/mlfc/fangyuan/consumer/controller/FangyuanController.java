package com.mlfc.fangyuan.consumer.controller;

import apiserrvice.FangyuanService;
import apiserrvice.TestService;
import common.Rest;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Test;

import java.util.List;

@RestController
public class FangyuanController {

    @DubboReference
    private FangyuanService fangyuanService;

    @DubboReference
    private TestService testService;

    @GetMapping("/getLocalDateTime")
    public String getLocalDateTime() {
        return fangyuanService.getLocalDateTime().toString();
    }

    @GetMapping("/test")
    public void test() {
        System.out.println("test");
    }

    @GetMapping("/test2")
    public Rest<List<Test>> test2() {
        List<Test> list = testService.test();
        return Rest.success(list);
    }
}
