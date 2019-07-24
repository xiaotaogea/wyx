package com.zjwm.wyx.exam.service.impl;

import com.zjwm.wyx.exam.dao.HoldExamMapper;
import com.zjwm.wyx.exam.entity.ExamDo;
import com.zjwm.wyx.exam.entity.HoldExam;
import com.zjwm.wyx.exam.entity.HoldQuestion;
import com.zjwm.wyx.exam.service.HoldExamService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service("holdExamService")
public class HoldExamServiceImpl implements HoldExamService {
	@Autowired
	private HoldExamMapper holdExamMapper;




	@Override
	public List<HoldExam> queryEList(int uid) {
		return holdExamMapper.queryEList(uid);
	}

	@Override
	public List<HoldQuestion> queryQList(int uid) {
		return holdExamMapper.queryQList(uid);
	}

	@Override
	public List<ExamDo> queryExamDo(int uid) {
		return holdExamMapper.queryExamDo(uid);
	}


}
