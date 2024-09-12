package com.mlfc.fangyuan.provider.impl;

import apiserrvice.FangyuanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.fangyuan.provider.mapper.FangyuanMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import pojo.HouseResources;

@DubboService
@Slf4j
public class FangyuanServiceImpl extends ServiceImpl<FangyuanMapper, HouseResources> implements FangyuanService {

}
