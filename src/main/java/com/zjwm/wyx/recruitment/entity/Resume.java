package com.zjwm.wyx.recruitment.entity;



import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
/**
 * 简历
 * @author Administrator
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Resume {
    private int id;

    private Integer userId;
    //简历名称
    private String resumeName;

    private String userName;

    private Integer gender;

    private String phone;

    private String email;

    private Integer qq;

    private Date birthday;

    private Integer age;

    private String nativePlace;

    private String img;

    private Integer workYear;

    private Integer education;

    private Integer hiredate;

    private Integer jobType;

    private Integer expectArea;

    private Integer industryId;

    private Integer expectEmolumentLow;

    private Integer expectEmolumentHigh;

    private String skill;

    private String evaluate;

    private Integer checkNum;

    private Integer downloadNum;

    private Integer status;

    private Integer createTime;

    private Integer updateTime;
    //职位
   private ResumeIndustry resumeIndustry;
}