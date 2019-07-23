package com.zjwm.wyx.course.dao;

import com.zjwm.wyx.course.entity.Hold;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface HoldMapper extends BaseDao<Hold> {

	/**
	 * 收藏课程
	 * 
	 * @param uid
	 * @return
	 */
	List<Hold> holdList(int uid);

	/**
	 * 取消收藏
	 * 
	 * @param uid
	 * @param clid
	 */
	int delHold(int uid, int clid);
}
