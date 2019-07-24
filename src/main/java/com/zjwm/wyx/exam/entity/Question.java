package com.zjwm.wyx.exam.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Question {

    private int id;
    //0判断，1填空，2单选，3多选，4操作
    private int flag;
    //标题
    private String title;
    //题目
    private String content;
    //选项
    private String option;
    //答案
    private String answer;
    //解析
    private String analyze;
    //课程id
    private int bookId;
    //视频id
    private int videoId;
    //添加时间
    private int addTime;
}
