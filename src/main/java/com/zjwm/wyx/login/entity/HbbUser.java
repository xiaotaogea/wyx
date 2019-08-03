package com.zjwm.wyx.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HbbUser {
    private Integer id;

    private String wxUnionid;

    private String mobile;

    private String username;

    private String truename;

    private String nick;

    private String email;

    private int streng;

    private String password;

    private Integer type;

    private String pic;

    private Integer status;

    private Integer state;

    private Integer vip;

    private String fen;

    private String method;

    private String adduser;

    private String loginip;

    private Integer logintime;

    private String cookid;

    private String cookwapid;

    private Integer createTime;

    private Integer updateTime;

    private Integer overTime;

    private Byte userSource;


}