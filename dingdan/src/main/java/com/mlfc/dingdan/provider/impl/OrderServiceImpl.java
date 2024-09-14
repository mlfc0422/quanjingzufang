package com.mlfc.dingdan.provider.impl;

import apiserrvice.FangyuanService;
import apiserrvice.OrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.dingdan.provider.mapper.OrderMapper;
import common.SnowflakeIdGenerator;
import org.apache.dubbo.config.annotation.DubboReference;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import pojo.Order;

@DubboService
public class OrderServiceImpl extends ServiceImpl<OrderMapper, Order> implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @DubboReference
    private FangyuanService fangyuanService;

    @Transactional
    @Override
    public boolean createOrder(Order order) {
        // 检查房源是否可租赁
        boolean isRentable = fangyuanService.isRentable(order.getHouseResourcesId());
        if (isRentable) {
            return false; // 如果房源不可租赁，返回失败
        }

        // 生成唯一订单号
        SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1);
        long id = idGenerator.nextId();
        // 创建订单实体
        order.setId(id);
        order.setStatus("已创建"); // 初始状态为“已创建”

        // 插入订单记录到数据库
        return orderMapper.insert(order) > 0;
    }
}
