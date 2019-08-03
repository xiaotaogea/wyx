package com.zjwm.wyx.course.service;

import com.zjwm.wyx.course.entity.Comment;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface CommentService {

	List<Comment> queryList(int uid);

	/**
	 *
	 * 
	 * @param uid 用户id
	 * @return 好评
	 */
	List<Comment> queryGoodList(int uid);

	/**
	 *
	 * 
	 * @param uid 用户id
	 * @return 中评
	 */
	List<Comment> queryMidList(int uid);

	/**
	 *
	 * 
	 * @param uid 用户id
	 * @return  差评
	 */
	List<Comment> queryBadList(int uid);

}
