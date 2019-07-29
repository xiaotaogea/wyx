/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: LearningController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.recruitment.controller;

import com.zjwm.wyx.recruitment.entity.Learning;
import com.zjwm.wyx.recruitment.service.LearningService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 学习评估
 * version 2018.3
 */
@RestController
@RequestMapping("/learning")
@Api(description = "我的求职-学习评估")
public class LearningController {

    @Resource
    private LearningService learningService;

    /**
     * 全部问题
     *
     * @return 问题列表
     */
    @GetMapping("/all")
    @ApiOperation(value = "查询所有评估问题")
    public List<Learning> getList() {
        return learningService.queryList();
    }
}
