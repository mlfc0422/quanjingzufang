package com.mlfc.dingdan.provider.impl;

import apiserrvice.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.dingdan.provider.mapper.OrderMapper;
import org.apache.dubbo.config.annotation.DubboService;
import pojo.Order;

@DubboService
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {
}
