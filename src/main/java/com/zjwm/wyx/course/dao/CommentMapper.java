package com.zjwm.wyx.course.dao;

import com.zjwm.wyx.course.entity.Comment;
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
public interface CommentMapper extends BaseDao<Comment> {
	/**
	 * 全部
	 * 
	 * @param uid
	 * @return
	 */
	List<Comment> queryList(int uid);

	/**
	 * 好评
	 * 
	 * @param uid
	 * @return
	 */
	List<Comment> queryGoodList(int uid);

	/**
	 * 中评
	 * 
	 * @param uid
	 * @return
	 */
	List<Comment> queryMidList(int uid);

	/**
	 * 差评
	 * 
	 * @param uid
	 * @return
	 */
	List<Comment> queryBadList(int uid);
}
