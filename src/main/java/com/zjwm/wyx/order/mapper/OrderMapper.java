package com.zjwm.wyx.order.mapper;

import com.zjwm.wyx.order.entity.Order;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseDao<Order> {

    /**
     *
     * @param uid 用户id
     * @param status 付款状态
     * @return 购物车
     */
    List<Order> queryCar(@Param("uid") int uid,@Param("status") Integer status);

    /**
     *
     * @param uid 用户id
     * @param orderNo 订单号
     * @return 订单
     */

    List<Order> queryOrder(@Param("uid") int uid,@Param("orderNo") String orderNo);
}
