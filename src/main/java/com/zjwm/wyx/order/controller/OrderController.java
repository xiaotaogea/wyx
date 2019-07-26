package com.zjwm.wyx.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.order.entity.Order;
import com.zjwm.wyx.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 订单
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @RequestMapping("list")
    public PageInfo<Order> getList(int uid,Integer current,Integer status){
        current = current == null ? 1 : current;
        PageHelper.startPage(current, 10);

        List<Order> orders = orderService.queryPay(uid,status);

        PageInfo<Order> page = new PageInfo<>(orders);
        return page;
    }


}
