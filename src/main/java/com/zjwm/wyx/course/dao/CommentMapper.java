package com.zjwm.wyx.course.dao;

import com.zjwm.wyx.course.entity.Comment;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface CommentMapper extends BaseDao<Comment> {
	/**
	 * 根据用户id查出不同的类型的列表
	 * @param uid 用户id
	 * @param type 评价类型
	 * @return 列表
	 */
	List<Comment> queryList(int uid, @Param("type") String type);


}
