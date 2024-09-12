package com.mlfc.yonghu.provider.impl;

import apiserrvice.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.yonghu.provider.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import pojo.User;

@DubboService
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
