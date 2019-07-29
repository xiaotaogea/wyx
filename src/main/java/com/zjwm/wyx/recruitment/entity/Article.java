package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Article implements Serializable {
	private static final long serialVersionUID = 1L;

	private int id;
//  标题图片
	private String titleImg;
//  发布机构
	private String company;
//  标题
	private String title;
//  内容
	private String content;
	//阅读量
	private int pv;
	//发布时间 时间戳
	private int createTime;

}