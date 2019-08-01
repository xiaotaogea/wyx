package com.zjwm.wyx.user.service;

import com.zjwm.wyx.user.entity.HbbStudent;

/**
 * @author 王俊涛
 * @date 2019/8/1 0001 8:51
 */

public interface HbbStudentService {
    HbbStudent queryById(int uid);

    int updateStudent(HbbStudent student);
}
