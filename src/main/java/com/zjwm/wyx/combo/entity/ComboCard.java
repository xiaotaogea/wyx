package com.zjwm.wyx.combo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ComboCard {

    private int id;
    //机构代码
    private String code;
    //账号
    private String cardNum;
    //密码
    private String cardPwd;
    //使用时间：默认1年，0代指一个月(活动)
    private int useTime;
    //生成具体卡的对应detial的id，方便excel下载
    private int did;
    //是否已开通，0：未开通 1 ：已开通
    private int status;
}
