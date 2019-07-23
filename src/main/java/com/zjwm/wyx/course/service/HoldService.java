package com.zjwm.wyx.course.service;

import com.zjwm.wyx.course.entity.Hold;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface HoldService {



	List<Hold> holdList(int uid);
	
	int delHold(int uid, int clid);

}
