package com.mlfc.yonghu.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.mlfc.api.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    @Select("select id from user where user_name = #{username} and password = #{password}")
    String selectId(@Param("username") String username, @Param("password") String password);

    @Select("select id from user where user_name = #{username}")
    String selectIdUnPassword(@Param("username") String username);

    @Select("select user_name, account, address, gender, age from user where id = #{id}")
    User selectOtherUser(@Param("id") Long id);

    @Select("select id,user_name from user where token = #{token}")
    User selectByToken(@Param("token") String token);
}
