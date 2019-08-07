/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: OrderController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.order.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.order.entity.Order;
import com.zjwm.wyx.order.service.OrderService;
import com.zjwm.wyx.utils.CountUtil;
import com.zjwm.wyx.utils.R;
import com.zjwm.wyx.utils.UUIDS;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/order")
@Api(description = "我的订单,购物车")
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping("car")
    @ApiOperation(value = "购物车、提交订单")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如887", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "1:未付款，2:已付款", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "提交订单时用，值为order", dataType = "string")
    })
    public PageInfo<Order> getList(int uid, Integer currPage, Integer status, String type) {
        currPage = currPage == null ? 1 : currPage;
        type = type == null ? "" : type;
        String orderNo = "zjwam" + CountUtil.verifyCode(3) + UUIDS.getDateTime();
        PageHelper.startPage(currPage, 5);
        List<Order> orders = orderService.queryCar(uid, status);
        if (type.equals("order")) {
            for (Order order : orders) {
                order.setOrderNo(orderNo);
                orderService.update(order);
            }
        }
        return new PageInfo<>(orders);
    }

    @GetMapping("addCar")
    @ApiOperation(value = "加入购物车")
    @ApiImplicitParam(paramType = "query", name = "order", value = "购物车对象", required = true, dataType = "Order")
    public R addOrder(Order order) {
        order.setOrderNo("zjwam" + CountUtil.verifyCode(3) + UUIDS.getDateTime());
        order.setStatus(1);
        order.setPayMent("未付款");
        order.setAddTime((int) (System.currentTimeMillis() / 1000));
        order.setPayTime(0);

        int res = orderService.save(order);
        if (res == 1) {
            return R.ok("加入购物车成功!");
        }
        return R.error("加入购物车失败!");
    }

    @GetMapping("delCar")
    @ApiOperation(value = "删除商品")
    @ApiImplicitParam(paramType = "query", name = "id", value = "商品id", required = true, dataType = "int")
    public R delete(int id) {
        if (orderService.delete(id) == 1) {
            return R.ok("删除成功");
        }
        return R.error("删除失败");
    }

    @GetMapping("order")
    @ApiOperation(value = "订单列表")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如887", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "orderNo", value = "订单号", dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int")
    })
    public PageInfo<Order> getOrder(int uid, String orderNo, Integer currPage) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 5);
        List<Order> orders = orderService.queryOrder(uid, orderNo);

        return new PageInfo<>(orders);
    }


}
