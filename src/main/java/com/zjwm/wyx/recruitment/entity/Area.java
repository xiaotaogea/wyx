package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {

    private int id;
    //编号
    private int aid;
    //父id
    private int pid;
    //简称
    private String shortName;
    //名称
    private String name;

}

