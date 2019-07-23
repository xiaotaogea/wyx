package com.zjwm.wyx.course.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Hold implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int wid;//网站id
	private int acid;//所属全部课程属性id
	private int clid;//课程id
	private int uid;//用户id
	private int eid;//收藏的试卷id
	private int qid;//收藏的试题id
	//收藏时间
	private int addTime;

	private UserHClass userHClass;//收藏的课程
	
}
