package com.zjwm.wyx.answer.service.impl;

import com.zjwm.wyx.answer.dao.AnswerMapper;
import com.zjwm.wyx.answer.entity.Answer;
import com.zjwm.wyx.answer.service.AnswerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	@Resource
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> queryQList(int uid) {
		// TODO Auto-generated method stub
		return answerMapper.queryQList(uid);
	}

	@Override
	public List<Answer> queryAList(int uid) {
		// TODO Auto-generated method stub
		return answerMapper.queryAList(uid);
	}

	

}
