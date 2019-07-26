package com.zjwm.wyx.point.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;


/**
 * 用户积分
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserPoint implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	//用户id
	private Long uid;
	//方式
	private String method;
	//类型 0：加，1：减
	private int type;
	//内容
	private String content;
	//积分
	private String fen;
	//時間戳
	private int addTime;
	//时间戳转为日期
	private String dateTime;


}
