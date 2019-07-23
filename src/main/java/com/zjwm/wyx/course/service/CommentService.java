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
