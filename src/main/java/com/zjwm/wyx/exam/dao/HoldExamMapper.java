package com.zjwm.wyx.exam.dao;

import com.zjwm.wyx.exam.entity.ExamDo;
import com.zjwm.wyx.exam.entity.HoldExam;
import com.zjwm.wyx.exam.entity.HoldQuestion;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 收藏试卷
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface HoldExamMapper extends BaseDao<HoldExam> {

	/**
	 * 收藏试卷
	 *
	 * @param uid
	 * @return
	 */
	List<HoldExam> queryEList(@Param("uid") int uid);

	/**
	 * 收藏试题
	 * @param uid
	 * @return
	 */
	List<HoldQuestion> queryQList(@Param("uid") int uid);
	/**
	 * 做题记录
	 *
	 * @param uid
	 * @return
	 */
	List<ExamDo> queryExamDo(@Param("uid") int uid);

}
