package com.zjwm.wyx.exam.service;

import com.zjwm.wyx.exam.entity.ExamDo;
import com.zjwm.wyx.exam.entity.HoldExam;
import com.zjwm.wyx.exam.entity.HoldQuestion;

import java.util.List;

/**
 * 收藏试卷
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface HoldExamService {


	/**
	 *
	 * @param uid 用户id
	 * @return 收藏试卷
	 */
	List<HoldExam> queryEList(int uid);
	/**
	 *
	 * @param uid 用户id
	 * @return 收藏试题
	 */
	List<HoldQuestion> queryQList(int uid);
	/**
	 *
	 *
	 * @param uid 用户id
	 * @return 做题记录
	 */
	List<ExamDo> queryExamDo(int uid);

}
