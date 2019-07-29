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
public interface ClassMapper extends BaseDao<UserHClass> {
	/**
	 * 全部课程
	 * @return
	 */
	Page<UserHClass> queryAll();

	/**
	 * 网站名字
	 * @return
	 */
	List<String> queryWebNames();

	List<String> queryAcNames(@Param("wid") Integer wid);

	List<UserHClass> queryByTj(@Param("wwid")Integer wwid, @Param("acid")Integer acid);

	List<UserHClass> queryByTjAndUid(@Param("uid")Integer uid,@Param("status") Integer status,@Param("wwid")Integer wwid,@Param("acid") Integer acid);

	String queryTimeByUidAndClid(@Param("uid")Integer uid,@Param("clid")Integer clid);
}
