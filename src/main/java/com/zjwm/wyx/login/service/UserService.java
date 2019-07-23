package com.zjwm.wyx.login.service;

import com.zjwm.wyx.login.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface UserService {
	
	UserEntity queryObject(Long userId);

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	long login(String mobile, String password);

	void save(String mobile, String password);
}
