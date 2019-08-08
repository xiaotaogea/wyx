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
    public List<Order> queryCar(int uid) {
        return orderMapper.queryCar(uid);
    }

    @Override
    public List<Order> queryOrder(int uid, String orderNo,Integer status) {
        return orderMapper.queryOrder(uid,orderNo,status);
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

    @Override
    public int queryCount(int uid,int clid) {
        return orderMapper.queryCount(uid,clid);
    }
}
