package com.mlfc.dingdan.consumer.controller;

import apiserrvice.AliPayService;
import com.alipay.api.AlipayApiException;
import common.Rest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pojo.Orders;

@Slf4j
@RestController
@RequestMapping
public class PayController {

    @DubboReference
    private AliPayService aliPayService;

    @PostMapping("alipay")
    public Rest<String> alipay(@RequestBody Orders orders) throws AlipayApiException {
        log.info("alipay: {}", orders);
        String htmlResponse = aliPayService.aliPay(orders);
        log.info("alipay response: {}", htmlResponse);
        return Rest.success(htmlResponse);
    }
}
