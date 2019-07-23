package com.zjwm.wyx.recruitment.service.impl;

import com.zjwm.wyx.recruitment.dao.LearningMapper;
import com.zjwm.wyx.recruitment.entity.Learning;
import com.zjwm.wyx.recruitment.service.LearningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;




@Service("learningService")
public class LearningServiceImpl implements LearningService {
	@Autowired
	private LearningMapper learningMapper;

	@Override
	public List<Learning> queryList() {
		// TODO Auto-generated method stub
		return learningMapper.queryList();
	}
	
	
	
}
