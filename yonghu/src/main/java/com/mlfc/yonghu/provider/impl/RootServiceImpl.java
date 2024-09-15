package com.mlfc.yonghu.provider.impl;

import apiservice.RootService;
import com.mlfc.yonghu.provider.mapper.RootMapper;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Root;

@DubboService
public class RootServiceImpl implements RootService {

    @Autowired
    private RootMapper rootMapper;

    @Override
    public Boolean login(Root root) {
        return rootMapper.login(root);
    }
}
