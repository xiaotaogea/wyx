package com.zjwm.wyx.login.dao;

import com.zjwm.wyx.login.entity.UserEntity;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 用户
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {
    UserEntity queryByMobile(@Param("mobile") String mobile);

    int updateFen(UserEntity userEntity);
}
