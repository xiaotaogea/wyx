package com.zjwm.wyx.course.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 课程
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWClass implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private int acid;
	private int wid;
	private int uid;
	private int clid;
	// 总时长
	private String allTime;
	// 观看时长
	private String wTime;
	// 状态 是否看完
	private int status;

}
