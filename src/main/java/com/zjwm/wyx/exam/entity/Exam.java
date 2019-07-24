package com.zjwm.wyx.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Exam implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	//课程id
    private int bookId;
    //课程名称
    private String bookName;
	//试卷名称
	private String examName;
	//难度 1：难度1、2：难度2、3难度3、4难度4、5难度5
	private int examHard;
	//试卷类型ID
    private int examType;
    //试卷说明
    private String examIntr;
    //试卷缩略图
    private String examImg;
    //做题时间(单位：分钟)
    private String allTime;
    //点击人数
    private int pv;
    //收藏人数
    private int holdNum;
    //做题人数
    private int studyNum;
    //是否有题0无，1有
    private int hasQuestion;

	//添加时间
	private int addTime;



	
}
