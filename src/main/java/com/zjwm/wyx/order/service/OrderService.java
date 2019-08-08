package com.zjwm.wyx.order.service;

import com.zjwm.wyx.order.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> queryCar(int uid);
    List<Order> queryOrder(int uid,String orderNo,Integer status);


    int save(Order order);
    int update(Order order);
    int delete(int id);
    /**
     *
     * @param uid 用户id
     * @return 购物车中购买单个商品的个数
     */
    int queryCount(int uid,int clid);
}
