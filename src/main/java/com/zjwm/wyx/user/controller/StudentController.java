package com.zjwm.wyx.user.controller;

import com.zjwm.wyx.user.service.StudentService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * description
 *
 * @author 王俊涛
 * @date 2019/7/30 16:06
 */
@RestController
@RequestMapping("student")
@Api(description = "个人信息-学生")
public class StudentController {

    @Resource
    private StudentService studentService;
    @GetMapping("info")
    @ApiOperation(value = "根据学生id查询信息")
    @ApiImplicitParam(paramType = "query",name = "uid",value = "学生id",required = true,dataType = "int")
    public Student getInfo(int uid){
        return studentService.queryById(uid);
    }
}
