package com.zjwm.wyx.recruitment.controller;

import com.zjwm.wyx.recruitment.entity.Learning;
import com.zjwm.wyx.recruitment.service.LearningService;
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
@RequestMapping("/learning")
public class LearningController {
	
	@Autowired
	private LearningService learningService;
	/**
	 * 全部问题
	 * @return
	 */
	@RequestMapping("/all")
	public List<Learning> getAllCourse() {
		List<Learning> list = learningService.queryList();
		return list;	
	}
	
}
