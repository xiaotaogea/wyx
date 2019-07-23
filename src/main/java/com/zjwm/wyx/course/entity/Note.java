package com.zjwm.wyx.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

/**
 * 课程笔记
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Note implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	//课程id
	private int clid;
	//视频id
	private int vid;
	//用户id
	private int uid;
	//观看时间
	private int vTime;
	//添加时间
	private int addTime;
	//内容
	private String note;
	//笔记视频
	private Video video;

}
