package com.zjwm.wyx.combo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComboCardOrder {

    private int id;
    //购买用户
    private int uid;
    //使用者id
    private int tid;
    //账号
    private String cardNum;
    //密码
    private String cardPwd;
    //到期时间
    private int overtime;
    //购买方式
    private String method;
    //是否已开通，0：未开通 1 ：已开通，2：已到期
    private int status;
    //购买时间
    private int paytime;
}
