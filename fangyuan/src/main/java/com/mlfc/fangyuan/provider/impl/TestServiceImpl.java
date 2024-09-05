package com.mlfc.fangyuan.provider.impl;

import apiserrvice.TestService;
import com.mlfc.fangyuan.provider.mapper.FangyuanMapper;
import com.mlfc.fangyuan.provider.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Test;

import java.util.List;

@Slf4j
@DubboService
public class TestServiceImpl implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> test() {
        log.info("test");
        return testMapper.selectList(null);
    }
}
