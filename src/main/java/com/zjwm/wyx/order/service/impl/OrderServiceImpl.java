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
    public List<Order> queryCar(int uid,Integer status) {
        return orderMapper.queryCar(uid,status);
    }

    @Override
    public List<Order> queryOrder(int uid, String orderNo) {
        return orderMapper.queryOrder(uid,orderNo);
    }

    @Override
    public int save(Order order) {
        return orderMapper.save(order);
    }

    @Override
    public int update(Order order) {
        return orderMapper.update(order);
    }

    @Override
    public int delete(int id) {
        return orderMapper.delete(id);
    }
}
