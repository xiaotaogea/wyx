package com.zjwm.wyx.answer.dao;

import com.zjwm.wyx.answer.entity.Answer;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author 王俊涛
 * @date 2019/7/28 0028 16:02
 */
@Mapper
public interface AnswerMapper extends BaseDao<Answer> {
    /**
     *功能描述：根据用户id查找提问
     *@author 王俊涛
     *@version 2018.3
     *@param uid 用户id
     *@return 提问列表
     */
    List<Answer> queryQList(@Param("uid") int uid);
    /**
     *功能描述：根据用户id查找回答
     *@author 王俊涛
     *@version 2018.3
     *@param uid 用户id
     *@return 回答列表
     */
    List<Answer> queryAList(@Param("uid") int uid);
}
