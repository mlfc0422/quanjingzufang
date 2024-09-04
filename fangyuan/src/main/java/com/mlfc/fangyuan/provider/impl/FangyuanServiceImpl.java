package com.mlfc.fangyuan.provider.impl;

import com.mlfc.fangyuan.api.FangyuanService;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;

import java.time.LocalDateTime;

@DubboService
@Slf4j
public class FangyuanServiceImpl implements FangyuanService {

    @Override
    public LocalDateTime getLocalDateTime() {
        log.info("getLocalDateTime");
        return LocalDateTime.now();
    }
}
