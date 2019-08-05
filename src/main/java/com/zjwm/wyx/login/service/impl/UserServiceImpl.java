package com.zjwm.wyx.login.service.impl;

import com.zjwm.wyx.login.dao.HbbUserMapper;
import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private HbbUserMapper userMapper;

    @Override
    public HbbUser queryObject(int userId) {
        return userMapper.queryObject(userId);
    }

    @Override
    public HbbUser queryByMobile(String mobile) {
        return userMapper.queryByMobile(mobile);
    }


    @Override
    public int save(HbbUser hbbUser) {
        return userMapper.save(hbbUser);
    }

    @Override
    public HbbUser queryByEmail(String email) {
        return userMapper.queryByEmail(email);
    }

    @Override
    public int update(HbbUser hbbUser) {
        return userMapper.update(hbbUser);
    }


}
