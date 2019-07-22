package com.zjwm.wyx.point.service;

import com.zjwm.wyx.point.entity.UserPoint;

import java.util.List;

/**
 * 用户积分
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface UserPointService {
	
	List<UserPoint> queryByUid(int uid);

	void insertUserPoint(UserPoint userPoint);

	int queryTotal();
	

}
