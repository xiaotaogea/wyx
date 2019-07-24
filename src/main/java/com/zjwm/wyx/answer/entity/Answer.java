package com.zjwm.wyx.answer.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Answer implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int wid;//网站id
	private int acid;//所属全部课程属性id
	private int clid;//课程id
	private int vid;//视频id
	private int uid;//用户id
	private String content;//内容

	private int pid;//回复id
	private String vTime;//视频播放时长
	private int addTime;

}
