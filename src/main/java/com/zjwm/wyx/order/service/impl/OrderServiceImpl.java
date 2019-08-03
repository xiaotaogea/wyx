package com.zjwm.wyx.order.service.impl;

import com.zjwm.wyx.order.entity.Order;
import com.zjwm.wyx.order.mapper.OrderMapper;
import com.zjwm.wyx.order.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service("orderService")
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderMapper orderMapper;


    @Override
    public List<Order> queryPay(int uid,Integer status) {
        return orderMapper.queryPay(uid,status);
    }
}
