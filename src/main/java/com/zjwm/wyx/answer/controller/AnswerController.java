package com.zjwm.wyx.answer.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.answer.entity.Answer;
import com.zjwm.wyx.answer.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 学习评估
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/answer")
public class AnswerController {

	@Autowired
	private AnswerService answerService;

	/**
	 * 我的提问，我的回答
	 * 
	 * @return
	 */
	@RequestMapping("/all")
	public PageInfo<Answer> getAllCourse(Integer current, int uid, Integer type) {
		current = current == null ? 1 : current;
		PageHelper.startPage(current, 10);
		List<Answer> list = answerService.queryList(type,uid);
		PageInfo<Answer> page = new PageInfo<>(list);
		return page;
	}

}
