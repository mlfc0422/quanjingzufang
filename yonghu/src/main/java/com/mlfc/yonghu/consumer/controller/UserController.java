package com.mlfc.yonghu.consumer.controller;

import apiserrvice.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pojo.User;
import pojo.UserDataObject;

@RequestMapping("users")
@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    //用户登录
    @GetMapping("username")
    public Rest<User> UserLogin(@RequestBody User user){

        QueryWrapper<User> wrapper = new QueryWrapper<>();//查询条件
        User id = userService.getOne(wrapper.select("userId")
                .eq("password",user.getPassword())
                .eq("userName",user.getUserName()));

        //判断密码是否正确
        if (id != null){
            return Rest.success(null);
        }
        return null;
    }

    //用户注册
    @PostMapping
    public void UserInsert(@RequestBody User user){userService.save(user);}

    //用户查询
    @GetMapping("{userId}")
    public Rest<User> UserGet(@RequestBody User user){

        userService.getById(user.getUserId());
        return Rest.success(null);
    }

    //用户管理
    @PutMapping("/{userId}/update")
    public void UserUpdate(@RequestBody User user){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        userService.update(user,wrapper.eq("userId",user.getUserId()));

    }
}
