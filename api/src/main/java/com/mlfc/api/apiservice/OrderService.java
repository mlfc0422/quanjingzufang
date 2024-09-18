package com.mlfc.api.apiservice;

import com.alipay.api.AlipayApiException;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mlfc.api.pojo.Order;
import com.mlfc.api.pojo.Orders;

public interface OrderService extends IService<Order> {
    boolean createOrder(Order order);

    String aliPay(Orders orders) throws AlipayApiException;

    void aliReturn(Orders orders);
}
