package com.zjwm.wyx.recruitment.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Welfare implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//福利id
	private int id;
	//福利名称
	private String name;
	//福利图标
	private String img;
	//状态
	private int status;
	private int createTime;
	private int updateTime;

}
