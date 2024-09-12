package com.mlfc.yonghu.consumer.controller;

import apiserrvice.UserService;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import common.Rest;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pojo.User;


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
    public Rest<User> UserGet(@RequestBody User user,@RequestBody long params){

        QueryWrapper<User> wrapper = new QueryWrapper<>();

        if(params == user.getUserId()){
            user = userService.getById(user.getUserId());}
        else {
            userService.getOne(wrapper.select("userName","IpAddress","gender","age")
                    .eq("userId",user.getUserId()));
        }
        return Rest.success(user);
    }

    //用户管理
    @PutMapping("/{userId}/update")
    public void UserUpdate(@RequestBody User user){

        QueryWrapper<User> wrapper = new QueryWrapper<>();
        userService.update(user,wrapper.eq("userId",user.getUserId()));

    }
}
