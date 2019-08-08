package com.zjwm.wyx.order.mapper;

import com.zjwm.wyx.order.entity.Order;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface OrderMapper extends BaseDao<Order> {

    /**
     * @param uid 用户id
     * @return 购物车
     */
    List<Order> queryCar(@Param("uid") int uid);

    /**
     * @param uid     用户id
     * @param orderNo 订单号
     * @param status  付款状态
     * @return 订单
     */

    List<Order> queryOrder(@Param("uid") int uid, @Param("orderNo") String orderNo, @Param("status") Integer status);

    /**
     *
     * @param uid 用户id
     * @return 购物车中购买单个商品的个数
     */
    int queryCount(@Param("uid") int uid,@Param("clid") int clid);
}
