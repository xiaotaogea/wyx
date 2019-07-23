package com.zjwm.wyx.course.dao;

import com.zjwm.wyx.course.entity.UserWClass;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户课程
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserWClassMapper extends BaseDao<UserWClass> {
	List<UserWClass> queryByUidAndStatusNo(@Param("uid") int uid);
	List<UserWClass> queryByUidAndStatusYes(@Param("uid") int uid);
}
