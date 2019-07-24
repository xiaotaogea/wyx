package com.zjwm.wyx.bbs.service;

import com.zjwm.wyx.bbs.entity.Bbs;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface BbsService {


	List<Bbs> queryList(int uid);

	Bbs queryById(int id);
	/**
	 * 参与
	 * @param userId
	 * @return
	 */
	List<Bbs> queryReply(int userId);
    /**
     *
     * @return 帖子的父种类
     */
    List<String> querycateParentName();
    /**
     * 帖子的子类
     * @param id
     * @return
     */
    List<String> querycateChildName(int id);
    /**
     * 标签
     * @return
     */
    List<String> queryLabs();

    /**
     * 发帖
     * @param bbs
     * @return
     */
    int save(Bbs bbs);

}
