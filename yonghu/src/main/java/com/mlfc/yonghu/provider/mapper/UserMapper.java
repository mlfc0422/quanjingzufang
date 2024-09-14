package com.mlfc.yonghu.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.User;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select id from user where user_name = #{username} and password = #{password}")
    String selectId(@Param("username") String username, @Param("password") String password);
}
