package com.zjwm.wyx.order.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    //课程id
    private int clid;
    //课程名称
    private String cName;
    //订单号
    private String orderNo;
    //付款价格
    private String price;
    //1：未付款，2：付款
    private int status;
    //付款方式
    private String payMent;
    private int addTime;
    //付款时间
    private int payTime;
    private int uid;
}
