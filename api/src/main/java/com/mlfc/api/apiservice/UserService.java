package com.mlfc.api.apiservice;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mlfc.api.pojo.User;
import org.apache.ibatis.annotations.Param;

public interface UserService extends IService<User> {

    String selectId(@Param("username") String username, @Param("password") String password);

    String selectIdUnPassword(@Param("username") String username);

    User selectOtherUser(@Param("id") Long id);

    User selectByToken(@Param("token") String token);
}
