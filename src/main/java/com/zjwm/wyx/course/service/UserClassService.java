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

	/**
	 * 网站名字
	 * @return
	 */
	List<String> queryWebNames();
	List<String> queryAcNames(int wid);

	List<Integer> queryByTj(int wid, int acid);
	String queryTimeByUidAndClid(int uid, int clid);
	List<Integer> queryByTjAndUid(int wwid, int acid, int uid,int status);

}
