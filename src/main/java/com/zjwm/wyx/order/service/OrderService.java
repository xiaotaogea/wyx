package com.zjwm.wyx.order.service;

import com.zjwm.wyx.order.entity.Order;

import java.util.List;

public interface OrderService {
    List<Order> queryPay(int uid,Integer status);
}
