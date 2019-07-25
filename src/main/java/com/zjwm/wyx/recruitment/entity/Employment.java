package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employment {

    private int id;
    //简历id
    private int resumeId;
    //工作地点
    private String workArea;
    //工作公司
    private String workCompany;
    //工作岗位
    private String workJob;
    //工作公司性质:1为民营企业2为公办企业3为中外合资4为外企5为上市公司
    private int workCompanyNature;
    //工作公司员工数量:1为50人以下;2为50至100人;3为100人以上
    private int workEmployeesNumber;
    //工作最低薪水
    private int workEmolumentLow;
    //工作最高薪水
    private int workEmolumentHigh;
    //工作开始时间
    private Date beginTime;
    //工作结束时间
    private Date endTime;
    //工作职责
    private String responsibility;
    //状态：1为正常，2为下架
    private int status;

    private int createTime;
    private int updateTime;

}

