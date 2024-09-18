package com.mlfc.yonghu.provider.impl;

import com.mlfc.api.apiservice.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.mlfc.yonghu.provider.mapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.dubbo.config.annotation.DubboService;
import com.mlfc.api.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;

@DubboService
@Slf4j
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public String selectId(String username, String password) {
        String id = userMapper.selectId(username, password);
        return id;
    }

    @Override
    public String selectIdUnPassword(String username) {
        String id = userMapper.selectIdUnPassword(username);
        return id;
    }

    @Override
    public User selectOtherUser(Long id) {
        User user = userMapper.selectOtherUser(id);
        return user;
    }

    @Override
    public User selectByToken(String token) {
        User user = userMapper.selectByToken(token);
        return user;
    }
}
