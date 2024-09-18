package com.mlfc.yonghu.consumer.controller;

import com.mlfc.api.apiservice.RootService;
import com.mlfc.api.common.Rest;
import com.mlfc.api.pojo.Root;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/root")
public class RootController {

    @DubboReference
    private RootService rootService;

    @PostMapping("/login")
    public Rest<Root> RootLogin(@RequestBody Root root) {
        log.info("RootLogin: {}", root);
        Boolean result = rootService.login(root);
        if (result != null) {
            return Rest.success(null);
        }
        return Rest.error("登录失败");
    }
}
