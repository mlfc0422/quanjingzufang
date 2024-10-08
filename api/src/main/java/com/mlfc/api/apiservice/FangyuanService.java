package com.mlfc.api.apiservice;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.mlfc.api.pojo.Property;

public interface FangyuanService extends IService<Property> {

    boolean isRentable(long houseResourcesId);

    Page<Property> selectPage(Page<Property> page, QueryWrapper<Property> wrapper);
}
