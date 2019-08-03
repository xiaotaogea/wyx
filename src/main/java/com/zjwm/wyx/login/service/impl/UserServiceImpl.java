package com.zjwm.wyx.login.service.impl;

import com.zjwm.wyx.login.dao.HbbUserMapper;
import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.point.dao.UserPointMapper;
import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.utils.RRException;
import org.apache.commons.codec.digest.DigestUtils;
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

    @Override
    public int login(String mobile, String password) {
        HbbUser user = queryByMobile(mobile);
        if (user == null) {
            return -1;
        }

        //密码错误
        String userpassword = DigestUtils.sha256Hex(password);
        System.out.println(userpassword);
        if (!user.getPassword().equals(userpassword)) {
            throw new RRException("密码错误");
        }

        return user.getId();
    }

    @Transactional
    @Override
    public int save(HbbUser hbbUser, UserPoint userPoint) {
        return userMapper.save(hbbUser) + pointMapper.save(userPoint);
    }

    @Override
    public HbbUser queryByEmail(String email) {
        return userMapper.queryByEmail(email);
    }


}
