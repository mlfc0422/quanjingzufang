package com.mlfc.dingdan.consumer.controller;

import apiserrvice.OrderService;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.RestController;

@RestController("/order")
public class OrderController {

    @DubboReference
    private OrderService orderService;


}
