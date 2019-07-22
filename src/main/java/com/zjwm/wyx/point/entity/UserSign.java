package com.zjwm.wyx.point.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserSign implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private int uid;
    private int times;
    private long addTime;


}