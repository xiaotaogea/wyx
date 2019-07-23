package com.zjwm.wyx.course.entity;

import java.io.Serializable;

import com.zjwm.wyx.login.entity.UserEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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
	//视频id
	private int vid;
	//用户id
	private int uid;
	//添加时间
	private int addTime;
	private String dateTime;
	//内容
	private String content;
	//星数目
	private int star;
	//课程
	private UserHClass userHClass;
	
	private UserEntity userEntity;
	

}
