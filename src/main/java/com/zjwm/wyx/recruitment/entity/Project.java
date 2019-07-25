package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {

    private int id;
    //简历id
    private int resumeId;
    //项目名称
    private String projectName;
    //项目介绍
    private String intro;
    //个人职责
    private String responsibility;
    //开始时间
    private Date beginTime;
    //结束时间
    private Date endTime;
    //状态：1为正常，2为下架
    private int status;
    private int createTime;
    private int updateTime;


}

