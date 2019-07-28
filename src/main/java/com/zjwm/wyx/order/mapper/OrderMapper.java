package com.zjwm.wyx.order.mapper;

import com.zjwm.wyx.order.entity.Order;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper {

    List<Order> queryPay(@Param("uid") int uid,@Param("status") Integer status);
}
