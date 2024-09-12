package com.mlfc.fangyuan.provider.impl;

import apiserrvice.FangyuanService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.fangyuan.provider.mapper.FangyuanMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import pojo.HouseResources;

import java.time.LocalDateTime;
import java.util.List;

@DubboService
@Slf4j
public class FangyuanServiceImpl extends ServiceImpl<FangyuanMapper , HouseResources>implements FangyuanService {

}
