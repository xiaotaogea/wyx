package com.zjwm.wyx.answer.service.impl;

import com.zjwm.wyx.answer.dao.AnswerMapper;
import com.zjwm.wyx.answer.entity.Answer;
import com.zjwm.wyx.answer.service.AnswerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("answerService")
public class AnswerServiceImpl implements AnswerService {
	@Autowired
	private AnswerMapper answerMapper;

	@Override
	public List<Answer> queryList(int pid,int uid) {
		// TODO Auto-generated method stub
		return answerMapper.queryList(pid,uid);
	}

//	@Override
//	public List<Answer> queryAList(int uid) {
//		// TODO Auto-generated method stub
//		return answerMapper.queryAList(uid);
//	}

	

}
