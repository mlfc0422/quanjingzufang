package com.mlfc.yonghu.consumer.controller;

import apiservice.RootService;
import common.Rest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import pojo.Root;

@Slf4j
@RestController
@RequestMapping("root")
public class RootController {

    @DubboReference
    private RootService rootService;

    @PostMapping("login")
    public Rest<Root> RootLogin(@RequestBody Root root) {
        log.info("RootLogin: {}", root);
        Boolean result = rootService.login(root);
        if (result!=null) {
            return Rest.success(null);
        }
        return Rest.error("登录失败");
    }
}
