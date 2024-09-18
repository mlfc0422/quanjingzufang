package com.mlfc.fangyuan.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import com.mlfc.api.pojo.Property;

@Mapper
public interface FangyuanMapper extends BaseMapper<Property> {

    @Select("select status_code from property where id = #{houseResourcesId}")
    Boolean isRentable(@Param("houseResourcesId") Long houseResourcesId);
}
