package com.zjwm.wyx.course.entity;

import java.io.Serializable;

import com.zjwm.wyx.login.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * 课程
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserHClass implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	//课程名
	private String name;
	//缩略图
	private String img;
	//课时数
	private int num;
	//价格
	private int price;
	//原价
	private int oldPrice;
	//总时长
	private String allTime;
	//简介
	private String synopsic;
	//添加时间
	private int addTime;
	//1官方  2教師
	private int type;
	//学习人数
	private int snum;
	//观看时长
	private int wTime;
	//笔记数量
	private int noteNum;

	private UserEntity userEntity;

}
