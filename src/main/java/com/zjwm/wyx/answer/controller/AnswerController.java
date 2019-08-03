/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: AnswerController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.answer.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.answer.entity.Answer;
import com.zjwm.wyx.answer.service.AnswerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 课堂答疑：提问和回答
 * version 2018.3
 */
@RestController
@RequestMapping("/answer")
@Api(description = "课堂答疑")
public class AnswerController {
    @Resource
    private AnswerService answerService;

    /**
     *功能描述：通过用户id，查出所有的提问和回答信息
     *@author 王俊涛
     *@version 2018.3
     *@param currPage 当前页，默认是1
     *@param uid 用户id
     *@param type 1是提问，2是回答
     *@return com.github.pagehelper.PageInfo<com.zjwm.wyx.answer.entity.Answer>
     */
    @GetMapping("/all")
    @ApiOperation(value = "获取所有的提问和回答信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "1是提问，2是回答", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如889", required = true, dataType = "int")
    })

    public PageInfo<Answer> getAllCourse(Integer currPage, Integer uid, Integer type) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 10);
        List<Answer> list = null;
        switch (type) {
            case 1:
                list = answerService.queryQList(uid);
                break;
            case 2:
                list = answerService.queryAList(uid);
                break;
        }
        PageInfo<Answer> page = null;
        if (list!=null){
            page = new PageInfo<>(list);
        }

        return page;
    }
}
