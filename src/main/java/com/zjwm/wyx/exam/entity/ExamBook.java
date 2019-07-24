package com.zjwm.wyx.exam.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ExamBook implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	//试卷id
	private int examId;
	//课程id
	private int bookId;
	//试题id
	private int questionId;
	
	
}
