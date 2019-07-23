package com.zjwm.wyx.recruitment.entity;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Learning implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer id;
//    題目
	private String title;
//    類型
	private int type;
//    內容
	private String content;
//    答案
	private String answer;
//	     狀態
	private int status;

	private int createTime;

	private int updateTime;

}