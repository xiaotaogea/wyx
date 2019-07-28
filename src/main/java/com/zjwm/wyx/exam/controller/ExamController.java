/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: ExamController
  Author: 王俊涛
  Date：2019/7/28 0028 16:40
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.exam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.exam.entity.ExamDo;
import com.zjwm.wyx.exam.entity.HoldExam;
import com.zjwm.wyx.exam.entity.HoldQuestion;
import com.zjwm.wyx.exam.service.HoldExamService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@RestController
@RequestMapping("/question")
@Api(description = "题库中心")
/*
  @Description: 题库中心,收藏的试卷试题和做题记录
  @version 2018.3
 */
public class ExamController {
    @Resource
    private HoldExamService holdExamService;

    /**
     * 功能描述：根据用户id查询收藏的试卷
     *
     * @param currPage 当前页，默认1
     * @param uid      用户id
     * @return com.github.pagehelper.PageInfo<com.zjwm.wyx.exam.entity.HoldExam>
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/exam")
    @ApiOperation(value = "根据用户id查询收藏的试卷")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认1", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int"),
    })
    public PageInfo<HoldExam> getAllExam(Integer currPage, int uid) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 10);
        // 收藏的所有试卷
        List<HoldExam> list = holdExamService.queryEList(uid);

//        for (Hold hold : list) {
//            Exam exam = examService.queryById(hold.getAcid());
//            hold.setExamName(exam.getExamName());
//            int addTime = hold.getAddTime();
//            String dateTime = DateUtils.timeStampToDate(String.valueOf(addTime), "yyyy-MM-dd HH:mm");
//            hold.setDateTime(dateTime);
//        }
        return new PageInfo<>(list);
    }

    /**
     * 功能描述：根据用户id查询收藏的试卷
     *
     * @param currPage 当前页，默认1
     * @param uid      用户id
     * @return com.github.pagehelper.PageInfo<com.zjwm.wyx.exam.entity.HoldQuestion>
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/test")
    @ApiOperation(value = "根据用户id查询收藏的试题")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认1", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int"),
    })
    public PageInfo<HoldQuestion> getAllQue(Integer currPage, int uid) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 10);
        // 收藏的所有试卷
        List<HoldQuestion> list = holdExamService.queryQList(uid);

        return new PageInfo<>(list);
    }

    /**
     * 功能描述：根据用户id查询做题记录
     *
     * @param currPage 当前页，默认1
     * @param uid      用户id
     * @return com.github.pagehelper.PageInfo<com.zjwm.wyx.exam.entity.ExamDo>
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/examDo")
    @ApiOperation(value = "根据用户id查询做题记录")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认1", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int"),
    })
    public PageInfo<ExamDo> getExamDo(Integer currPage, int uid) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 10);
        // 做过的试卷
        List<ExamDo> list = holdExamService.queryExamDo(uid);
        return new PageInfo<>(list);
    }
}
