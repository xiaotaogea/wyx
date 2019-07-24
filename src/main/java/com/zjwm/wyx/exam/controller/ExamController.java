package com.zjwm.wyx.exam.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.exam.entity.ExamDo;
import com.zjwm.wyx.exam.entity.HoldExam;
import com.zjwm.wyx.exam.entity.HoldQuestion;
import com.zjwm.wyx.exam.service.HoldExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 题库中心
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/question")
public class ExamController {
    @Autowired
    private HoldExamService holdExamService;

    /**
     * 收藏试卷
     *
     * @return
     */
    @RequestMapping("/exam")
    public PageInfo<HoldExam> getAllExam(Integer current, int uid) {
        current = current == null ? 1 : current;
        PageHelper.startPage(current, 10);
        // 收藏的所有试卷
        List<HoldExam> list = holdExamService.queryEList(uid);

//        for (Hold hold : list) {
//            Exam exam = examService.queryById(hold.getAcid());
//            hold.setExamName(exam.getExamName());
//            int addTime = hold.getAddTime();
//            String dateTime = DateUtils.timeStampToDate(String.valueOf(addTime), "yyyy-MM-dd HH:mm");
//            hold.setDateTime(dateTime);
//        }
        PageInfo<HoldExam> page = new PageInfo<>(list);
        return page;
    }
    /**
     * 收藏试题
     *
     * @return
     */
    @RequestMapping("/question")
    public PageInfo<HoldQuestion> getAllQue(Integer current, int uid) {
        current = current == null ? 1 : current;
        PageHelper.startPage(current, 10);
        // 收藏的所有试卷
        List<HoldQuestion> list = holdExamService.queryQList(uid);

//        for (Hold hold : list) {
//            Exam exam = examService.queryById(hold.getAcid());
//            hold.setExamName(exam.getExamName());
//            int addTime = hold.getAddTime();
//            String dateTime = DateUtils.timeStampToDate(String.valueOf(addTime), "yyyy-MM-dd HH:mm");
//            hold.setDateTime(dateTime);
//        }
        PageInfo<HoldQuestion> page = new PageInfo<>(list);
        return page;
    }
    /**
     * 做题记录
     *
     * @return
     */
    @RequestMapping("/examDo")
    public PageInfo<ExamDo> getExamDo(Integer current, int uid) {
        current = current == null ? 1 : current;
        PageHelper.startPage(current, 10);
        // 做过的试卷
        List<ExamDo> list = holdExamService.queryExamDo(uid);
        PageInfo<ExamDo> page = new PageInfo<>(list);
        return page;
    }
}
