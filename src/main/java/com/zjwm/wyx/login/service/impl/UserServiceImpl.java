package com.zjwm.wyx.login.service.impl;

import com.zjwm.wyx.login.dao.HbbUserMapper;
import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.point.dao.UserPointMapper;
import com.zjwm.wyx.point.entity.UserPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Resource
    private HbbUserMapper userMapper;
    @Resource
    private UserPointMapper pointMapper;

    @Override
    public HbbUser queryObject(int userId) {
        return userMapper.queryObject(userId);
    }

    @Override
    public HbbUser queryByMobile(String mobile) {
        return userMapper.queryByMobile(mobile);
    }


    @Transactional
    @Override
    public int save(HbbUser hbbUser, UserPoint userPoint) {
        return userMapper.save(hbbUser) + pointMapper.save(userPoint);
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
    public int updateFen(HbbUser hbbUser) {
        return userMapper.updateFen(hbbUser);
    }


}
