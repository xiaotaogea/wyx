package com.zjwm.wyx.course.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程视频
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Video {
	private static final long serialVersionUID = 1L;

	private int id;
	// 课程id
	private int clid;
	// 视频id
	private int vid;
	// 视频名字
	private String vName;
	// 视频地址
	private String address;
	// 时长
	private String time;
}
