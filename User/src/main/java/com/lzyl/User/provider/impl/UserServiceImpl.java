package com.lzyl.User.provider.impl;

import apiserrvice.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.lzyl.User.provider.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import pojo.User;

@DubboService
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
