package com.zjwm.wyx.user.service.impl;

import com.zjwm.wyx.user.service.StudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * description
 *
 * @author 王俊涛
 * @date 2019/7/30 16:03
 */
@Service("studentService")
public class StudentServiceImpl implements StudentService {

    @Resource
    private StudentMapper studentMapper;

    @Override
    public Student queryById(int uid) {
        return studentMapper.queryObject(uid);
    }
}
