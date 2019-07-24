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
	 * 收藏试卷
	 *
	 * @param uid
	 * @return
	 */
	List<HoldExam> queryEList(int uid);
	/**
	 * 收藏试题
	 * @param uid
	 * @return
	 */
	List<HoldQuestion> queryQList(int uid);
	/**
	 * 做题记录
	 *
	 * @param uid
	 * @return
	 */
	List<ExamDo> queryExamDo(int uid);

}
