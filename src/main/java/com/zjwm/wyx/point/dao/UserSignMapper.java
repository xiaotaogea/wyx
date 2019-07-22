package com.zjwm.wyx.point.dao;

import com.zjwm.wyx.point.entity.UserSign;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;

/**
 * 用户签到
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserSignMapper extends BaseDao<UserSign> {
    
}
