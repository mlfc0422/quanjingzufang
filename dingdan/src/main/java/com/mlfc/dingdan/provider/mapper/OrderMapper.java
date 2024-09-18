package com.mlfc.dingdan.provider.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Update;
import com.mlfc.api.pojo.Order;
import com.mlfc.api.pojo.Orders;

@Mapper
public interface OrderMapper extends BaseMapper<Order> {

    @Update("update orders set status = #{status} where out_trade_no = #{out_trade_no}")
    void updateStatus(Orders orders);
}
