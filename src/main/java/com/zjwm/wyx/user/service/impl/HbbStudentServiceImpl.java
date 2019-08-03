/*
  @Copyright: 2016-2019，中教网盟科技有限公司
 * @FileName: HbbStudentServiceImpl
 * @Author: 王俊涛
 * @Date：2019/8/1 0001 8:52
 * @History: <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.user.service.impl;

import com.zjwm.wyx.user.dao.HbbStudentMapper;
import com.zjwm.wyx.user.entity.HbbStudent;
import com.zjwm.wyx.user.service.HbbStudentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Description: 学生信息操作
 * @version 2018.3
 *
 */
@Service("studentService")
public class HbbStudentServiceImpl implements HbbStudentService {

    @Resource
    private HbbStudentMapper studentMapper;
    @Override
    public HbbStudent queryById(int uid) {
        return studentMapper.queryObject(uid);
    }

    @Override
    public int updateStudent(HbbStudent student) {
        return studentMapper.update(student);
    }
}
