package com.zjwm.wyx.answer.service;

import com.zjwm.wyx.answer.entity.Answer;

import java.util.List;

public interface AnswerService {


    List<Answer> queryQList(int uid);

    List<Answer> queryAList(int uid);

}
