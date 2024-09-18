package com.mlfc.fangyuan.provider.impl;

import com.mlfc.api.apiservice.FangyuanService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.fangyuan.provider.mapper.FangyuanMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import com.mlfc.api.pojo.Property;

@DubboService
@Slf4j
public class FangyuanServiceImpl extends ServiceImpl<FangyuanMapper, Property> implements FangyuanService {

    @Autowired
    private FangyuanMapper fangyuanMapper;

    @Override
    public Page<Property> selectPage(Page<Property> page, QueryWrapper<Property> wrapper) {
        return fangyuanMapper.selectPage(page, wrapper);
    }

    @Override
    public boolean isRentable(long houseResourcesId) {
        return fangyuanMapper.isRentable(houseResourcesId);
    }
}
