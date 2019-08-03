package com.zjwm.wyx.login.service;

import com.zjwm.wyx.login.entity.HbbUser;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface UserService {
	
	HbbUser queryObject(int userId);

    HbbUser queryByMobile(String mobile);

	/**
	 * 用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	int login(String mobile, String password);

	int save(HbbUser hbbUser);

    HbbUser queryByEmail(String email);

}
