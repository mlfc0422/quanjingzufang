package com.mlfc.fangyuan.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import pojo.HouseResources;

@Mapper
public interface FangyuanMapper extends BaseMapper<HouseResources> {

    @Select("select status_code from house_resources where id = #{houseResourcesId}")
    Boolean isRentable(@Param("houseResourcesId") Long houseResourcesId);
}
