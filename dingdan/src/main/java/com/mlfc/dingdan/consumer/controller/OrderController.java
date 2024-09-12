package com.mlfc.dingdan.consumer.controller;

import apiserrvice.OrderService;
import common.Rest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import pojo.Order;

@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {

    @DubboReference
    private OrderService orderService;

    @PostMapping("/add")
    public Rest<Order> addOrder(@RequestBody Order order) {
        log.info("add order: {}", order);
        boolean result = orderService.createOrder(order);
        if (result) {
            return Rest.success(order);
        }
        return Rest.error("创建订单失败");
    }

}
