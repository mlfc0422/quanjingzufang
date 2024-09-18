package com.mlfc.yonghu.provider.impl;

import com.mlfc.api.apiservice.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.yonghu.provider.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import com.mlfc.api.pojo.User;

@DubboService
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
