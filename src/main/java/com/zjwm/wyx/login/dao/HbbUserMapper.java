package com.zjwm.wyx.login.dao;

import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface HbbUserMapper extends BaseDao<HbbUser> {

    HbbUser queryByMobile(String mobile);
    HbbUser queryByEmail(String Email);

    int updateFen(HbbUser hbbUser);
}
