package com.zjwm.wyx.login.service.impl;

import com.zjwm.wyx.login.dao.UserDao;
import com.zjwm.wyx.login.entity.UserEntity;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.utils.RRException;
import org.apache.commons.codec.digest.DigestUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;


@Service("userService")
public class UserServiceImpl implements UserService {


    @Autowired
    private UserDao userDao;

    @Override
    public UserEntity queryObject(int userId) {
        return userDao.queryObject(userId);
    }

    @Override
    public UserEntity queryByMobile(String mobile) {
        return userDao.queryByMobile(mobile);
    }

    @Override
    public int login(String mobile, String password) {
        UserEntity user = queryByMobile(mobile);
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
    public void save(String mobile, String password) {
        UserEntity userEntity = new UserEntity();
        userEntity.setMobile(mobile);
        userEntity.setPassword(password);
        userEntity.setPassword(DigestUtils.sha256Hex(userEntity.getPassword()));
        userEntity.setCreateTime(new Date());
        userDao.save(userEntity);
    }

    @Override
    public int updateFen(UserEntity userEntity) {
        return userDao.updateFen(userEntity);
    }

}
