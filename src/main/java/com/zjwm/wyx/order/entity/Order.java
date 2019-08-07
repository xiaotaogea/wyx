package com.zjwm.wyx.order.entity;

import com.zjwm.wyx.course.entity.UserHClass;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    private int id;
    //订单号
    private String orderNo;
    //付款价格
    private int status;
    //付款方式
    private String payMent;
    private int addTime;
    //付款时间
    private int payTime;
    //用户id
    private int uid;
    //需要的课程属性: id、课程名称、付款价格、缩略图
    private UserHClass userHClass;
}
