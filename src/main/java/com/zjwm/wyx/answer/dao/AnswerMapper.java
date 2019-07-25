package com.zjwm.wyx.answer.dao;

import com.zjwm.wyx.answer.entity.Answer;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface AnswerMapper extends BaseDao<Answer> {

    List<Answer> queryQList(@Param("uid") int uid);
    List<Answer> queryAList(@Param("uid") int uid);
}
