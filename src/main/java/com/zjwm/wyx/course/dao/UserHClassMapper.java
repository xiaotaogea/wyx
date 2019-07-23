package com.zjwm.wyx.course.dao;

import com.github.pagehelper.Page;
import com.zjwm.wyx.course.entity.UserHClass;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户课程
 * 
 */
@Mapper
public interface UserHClassMapper extends BaseDao<UserHClass> {
	/**
	 * 全部课程
	 * @return
	 */
	Page<UserHClass> queryAll();
	

	List<Integer> queryByTj(@Param("wwid")int wwid, @Param("acid")int acid);

	List<Integer> queryByTjAndUid(@Param("wwid")int wwid, @Param("acid")int acid,@Param("userId")int uid,@Param("status") int status);
}
