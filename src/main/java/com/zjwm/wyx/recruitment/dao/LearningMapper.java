package com.zjwm.wyx.recruitment.dao;

import com.zjwm.wyx.recruitment.entity.Learning;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 用户
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface LearningMapper extends BaseDao<Learning> {
    List<Learning> queryList();
}
