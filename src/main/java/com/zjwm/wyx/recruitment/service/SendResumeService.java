package com.zjwm.wyx.recruitment.service;

import com.zjwm.wyx.recruitment.entity.SendResume;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface SendResumeService {
	
	List<SendResume> queryList(int uid);

	List<SendResume> querySeeList(int uid);

	List<SendResume> queryYesList(int uid);

	List<SendResume> queryNoList(int uid);

}
