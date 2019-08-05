package com.zjwm.wyx.login.service;

import com.zjwm.wyx.login.entity.HbbUser;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface UserService {
	
	HbbUser queryObject(int userId);

    HbbUser queryByMobile(String mobile);


    int save(HbbUser hbbUser);
    HbbUser queryByEmail(String email);
    int updateFen(HbbUser hbbUser);

}
