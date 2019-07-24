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
	List<String> queryAcNames(Integer wid);

	List<Integer> queryByTj(Integer wid, Integer acid);
	String queryTimeByUidAndClid(Integer uid, Integer clid);
	List<Integer> queryByTjAndUid(Integer wwid, Integer acid, Integer uid,Integer status);

}
