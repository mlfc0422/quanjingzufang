package com.mlfc.fangyuan.provider.impl;

import apiserrvice.TestService;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.fangyuan.provider.mapper.TestMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.Test;

import java.util.List;

@Slf4j
@DubboService
public class TestServiceImpl extends ServiceImpl<TestMapper,Test> implements TestService {

    @Autowired
    private TestMapper testMapper;

    @Override
    public List<Test> test() {
        log.info("test");
        return testMapper.selectList(null);
    }

    @Override
    public Page<Test> getUserPage(int pageNum, int pageSize) {
        // 创建 Page 对象
        Page<Test> page = new Page<>(pageNum, pageSize);
        // 调用 MyBatis-Plus 的 page 方法
        return this.page(page);
    }


}
