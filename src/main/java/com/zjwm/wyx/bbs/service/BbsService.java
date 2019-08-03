package com.zjwm.wyx.bbs.service;

import com.zjwm.wyx.bbs.entity.Bbs;
import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.point.entity.UserPoint;

import java.util.List;

public interface BbsService {


	List<Bbs> queryList(int uid);

	Bbs queryById(int id);
	/**
	 *
	 * @param userId 用户id
	 * @return 参与列表
	 */
	List<Bbs> queryReply(int userId);
    /**
     *
     * @return 帖子的父种类
     */
    List<String> querycateParentName();
    /**
     *
     * @param id 父种类id
     * @return 帖子的子类列表
     */
    List<String> querycateChildName(int id);
    /**
     * @return 标签
     */
    List<String> queryLabs();

    /**
     * 发帖，改积分
     * @param bbs 帖子
     * @param userPoint 积分
     * @param hbbUser 用户
     * @return 保存
     */
    int save(Bbs bbs, UserPoint userPoint, HbbUser hbbUser);

}
