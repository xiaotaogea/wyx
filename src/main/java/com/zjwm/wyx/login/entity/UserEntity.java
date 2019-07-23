package com.zjwm.wyx.login.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;


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
public class UserEntity implements Serializable {
	private static final long serialVersionUID = 1L;
	
	//用户id
	private int userId;
	//用户名
	private String username;
	//昵称
	private String nick;
	//头像
	private String pic;
	//手机号
	private String mobile;
	//密码
	private String password;
	//创建时间
	private Date createTime;

}
