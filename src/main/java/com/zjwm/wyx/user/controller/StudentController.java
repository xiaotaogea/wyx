package com.zjwm.wyx.user.controller;


import com.zjwm.wyx.user.service.HbbStudentService;
import com.zjwm.wyx.user.entity.HbbStudent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;


/**
 * @version 2018.3
 * @Description: 根据用户id对用户进行操作
 */
@RestController
@RequestMapping("student")
@Api(description = "学生信息")
public class StudentController {

    @Resource
    private HbbStudentService studentService;

    @GetMapping("info")
    @ApiOperation("根据用户id获取信息")
    @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如15499", required = true, dataType = "int")
    public HbbStudent getInfo(int uid) {

        return studentService.queryById(uid);
    }

    @GetMapping("update")
    @ApiOperation("根据用户id修改信息")
    @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如15499", required = true, dataType = "int")
    public Map<String, String> updateInfo(int uid) {
        Map<String, String> map = new HashMap<>();
        int res = studentService.updateStudent(studentService.queryById(uid));
        if (res == 1) {
            map.put("msg", "修改成功");
        } else {
            map.put("msg", "修改失败");
        }
        return map;
    }

}
