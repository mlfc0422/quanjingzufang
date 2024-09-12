package com.lzyl.User.consumer.controller;

import apiserrvice.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import pojo.UserDataObject;

import java.util.Map;

@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //用户登录
    @GetMapping("username")
    public Rest<User> UserLogin(@RequestBody UserDataObject userobj){

        QueryWrapper<User> wrapper = new QueryWrapper<>();//查询条件
        User user = userService.getOne(wrapper.eq("userName",userobj.getUserName()));//根据条件查询数据

        //判断密码是否正确
        if (userobj.getPassword().equals(user.getPassword())){
            return Rest.success(null);
        }
        return null;
    }

    //用户注册
    @PostMapping
    public void UserInsert(@RequestBody UserDataObject userobj){

        //需要判断两次密码是否一致（nextPassword）
        User user = new User();
        user.setUserName(userobj.getUserName());
        user.setPassword(userobj.getPassword());

        userService.save(user);
    }

    //用户查询
    @GetMapping("{userId}")
    public Rest<User> UserGet(@RequestBody UserDataObject userobj){

        userService.getById(userobj.getUserId());
        return Rest.success(null);
    }

    //用户管理
    @PutMapping("/{userId}/update")
    public void UserUpdate(@RequestBody UserDataObject userobj){

        User user = new User();
        user.setAge(userobj.getAge());
        user.setGender(userobj.getGender());
        user.setIdNumber(userobj.getIdNumber());
        user.setEmailAddress(userobj.getEmailAddress());
        user.setRealName(userobj.getRealName());
        user.setPhoneNamber(userobj.getPhoneNamber());
        user.setIpAddress(userobj.getIpAddress());

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        userService.update(user,wrapper.eq("userId",userobj.getUserId()));

    }
}
