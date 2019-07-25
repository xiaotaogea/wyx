package com.zjwm.wyx.answer.service;

import com.zjwm.wyx.answer.entity.Answer;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface AnswerService {


	List<Answer> queryQList(int uid);
	List<Answer> queryAList(int uid);

}
