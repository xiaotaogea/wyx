package com.zjwm.wyx.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@SuppressWarnings("serial")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamDo implements Serializable{

	private int id;
	//学生id
	private int uid;
	//完成的试卷id
	private int eid;
	//记录时间
	private int addTime;
	//使用时间
	private int useTime;
	//做过的试卷
	private Exam exam;
}
