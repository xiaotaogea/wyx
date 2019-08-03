package com.zjwm.wyx.login.service.impl;

import com.zjwm.wyx.login.dao.HbbUserMapper;
import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.utils.RRException;
import org.apache.commons.codec.digest.DigestUtils;
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
    public int login(String mobile, String password) {
        HbbUser user = queryByMobile(mobile);
        if (user==null){
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

    @Override
    public int save(HbbUser hbbUser) {

        return userMapper.save(hbbUser);
    }

    @Override
    public HbbUser queryByEmail(String email) {
        return userMapper.queryByEmail(email);
    }


}
