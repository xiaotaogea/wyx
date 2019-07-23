package com.zjwm.wyx.recruitment.service;

import com.zjwm.wyx.recruitment.entity.Resume;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface ResumeService {

	Resume queryById(int id);
	
	List<Resume> queryList(int userId);
	/**
	 * 每个用户的简历数量
	 * @param uid
	 * @return
	 */
	int queryCountByUid(int uid);
	/**
	 * 检查名字是否重复
	 * @param uid
	 * @return
	 */
	String queryNameByUid(int uid);

	int delete(int id);


}
