package com.zjwm.wyx.recruitment.entity;



import java.util.Date;

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
public class Resume {
    private Integer id;

    private Integer userId;

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

   
}