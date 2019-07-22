package com.zjwm.wyx.point.service;

import com.zjwm.wyx.point.entity.UserSign;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface UserSignService {
	UserSign queryByUid(int uid);
	
	void save(UserSign userSign);
	void update(UserSign userSign);
}
