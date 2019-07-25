package com.zjwm.wyx.recruitment.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 简历
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResumeIndustry {
    private Integer id;

    //职位名称
    private String cateName;
    //父id
    private int pid;
    //状态：1为正常，2为下架
    private int status;



   
}