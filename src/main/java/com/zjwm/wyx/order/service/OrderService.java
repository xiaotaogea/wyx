package com.zjwm.wyx.order.service;

import com.zjwm.wyx.order.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> queryCar(int uid,Integer status);
    List<Order> queryOrder(int uid,String orderNo);


    int save(Order order);
    int update(Order order);
    int delete(int id);
}
