package com.mlfc.dingdan.consumer.controller;

import com.mlfc.api.apiservice.OrderService;
import com.alipay.api.AlipayApiException;
import com.mlfc.api.common.Rest;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.web.bind.annotation.*;
import com.mlfc.api.pojo.Order;
import com.mlfc.api.pojo.Orders;

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

    @PostMapping("alipay")
    public Rest<String> alipay(@RequestBody Orders orders) throws AlipayApiException {
        log.info("alipay: {}", orders);
        String htmlResponse = orderService.aliPay(orders);
        log.info("alipay response: {}", htmlResponse);
        return Rest.success(htmlResponse);
    }

    @PutMapping("alipay/return")
    public Rest<Orders> aliReturn(@RequestBody Orders orders) {
        log.info("alipay return: {}", orders);
        orderService.aliReturn(orders);
        return Rest.success(null);
    }
}
