package com.zjwm.wyx.course.entity;

import com.zjwm.wyx.login.entity.HbbUser;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 课程评价
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Comment implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	//课程
	private int clid;
	//网站id
	private int wid;
	//所有课程id
	private int acid;
	//视频id
	private int vid;
	//用户id
	private int uid;
	//添加时间
	private int addTime;
	//内容
	private String content;
	//星数目
	private int star;
	//课程
	private UserHClass userHClass;
	
	private HbbUser hbbUser;
	

}
