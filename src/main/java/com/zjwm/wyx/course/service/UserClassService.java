package com.zjwm.wyx.course.service;

import com.github.pagehelper.Page;
import com.zjwm.wyx.course.entity.UserHClass;
import com.zjwm.wyx.course.entity.UserWClass;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户课程
 * 
 */
public interface UserClassService {
	
	Page<UserHClass> queryAll();
	List<UserWClass> queryByUidAndStatusNo(int uid);
	List<UserWClass> queryByUidAndStatusYes(int uid);
	
	UserHClass queryById(int cid);


	List<Integer> queryByTj(int wid, int acid);

	List<Integer> queryByTjAndUid(int wwid, int acid, int uid,int status);
}
