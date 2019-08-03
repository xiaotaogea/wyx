package com.zjwm.wyx.course.service;

import com.github.pagehelper.Page;
import com.zjwm.wyx.course.entity.UserHClass;

import java.util.List;

/**
 * 用户课程
 * 
 */
public interface UserClassService {
	
	Page<UserHClass> queryAll();

	UserHClass queryById(int cid);


	List<String> queryWebNames();
	List<String> queryAcNames(Integer wid);

	List<UserHClass> queryByTj(Integer wid, Integer acid);
	String queryTimeByUidAndClid(Integer uid, Integer clid);
	List<UserHClass> queryByTjAndUid(Integer uid,Integer status,Integer parent,Integer child);

}
