package com.mlfc.fangyuan.provider.impl;

import apiserrvice.FangyuanService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.fangyuan.provider.mapper.FangyuanMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.beans.factory.annotation.Autowired;
import pojo.HouseResources;

import java.util.List;

@DubboService
@Slf4j
public class FangyuanServiceImpl extends ServiceImpl<FangyuanMapper , HouseResources>implements FangyuanService {

    @Autowired
    private FangyuanMapper fangyuanMapper;

    @Override
    public void deleteByIds(List<Integer> ids) {
        fangyuanMapper.deleteBatchIds(ids);
    }

    @Override
    public Page<HouseResources> selectPage(Page<HouseResources> page, QueryWrapper<HouseResources> wrapper) {
        return fangyuanMapper.selectPage(page, wrapper);
    }


}
