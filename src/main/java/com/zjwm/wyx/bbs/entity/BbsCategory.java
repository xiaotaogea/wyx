package com.zjwm.wyx.bbs.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BbsCategory implements Serializable {

	private static final long serialVersionUID = 1L;

	private int id;
	private int pid;// 父类id
	private String name;// 栏目名称

	private int status;// 状态：1显示0隐藏
	private int createTime;

}
