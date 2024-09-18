package com.mlfc.yonghu.provider.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import com.mlfc.api.pojo.Root;

@Mapper
public interface RootMapper {

    @Select("select * from root where account = #{account} and password = #{password}")
    Boolean login(Root root);
}
