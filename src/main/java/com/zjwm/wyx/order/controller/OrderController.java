package com.zjwm.wyx.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.order.entity.Order;
import com.zjwm.wyx.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(description = "我的订单")
public class OrderController {

    @Autowired
    private OrderService orderService;
    @GetMapping("list")
    @ApiOperation(value = "订单管理：查询用户的所有订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如887", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "1:未付款，2:已付款  默认1", required = false, dataType = "int"),
    })
    public PageInfo<Order> getList(int uid,Integer currPage,Integer status){
        currPage = currPage == null ? 1 : currPage;
        status = status == null ? 1 : status;
        PageHelper.startPage(currPage, 10);

        List<Order> orders = orderService.queryPay(uid,status);

        PageInfo<Order> page = new PageInfo<>(orders);
        return page;
    }


}
