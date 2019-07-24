package com.zjwm.wyx.bbs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsLab {

    private int id;
    //标签名称
    private String name;
    //状态：1显示0隐藏
    private int status;
    private int createTime;
}
