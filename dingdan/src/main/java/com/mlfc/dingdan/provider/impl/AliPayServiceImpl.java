package com.mlfc.dingdan.provider.impl;

import apiserrvice.AliPayService;
import com.alipay.api.AlipayApiException;
import com.mlfc.dingdan.common.Alipay;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Orders;

@DubboService
public class AliPayServiceImpl implements AliPayService {


    @Autowired
    private Alipay alipays;

    @Override
    public String aliPay(Orders orders) throws AlipayApiException {
        return alipays.pay(orders);
    }
}
