package com.zjwm.wyx.recruitment.service.impl;

import com.zjwm.wyx.recruitment.dao.ResumeMapper;
import com.zjwm.wyx.recruitment.entity.Resume;
import com.zjwm.wyx.recruitment.service.ResumeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
	@Autowired
	private ResumeMapper resumeMapper;

	@Override
	public Resume queryById(int id) {
		// TODO Auto-generated method stub
		return resumeMapper.queryObject(id);
	}

	@Override
	public List<Resume> queryList(int userId) {
		// TODO Auto-generated method stub
		return resumeMapper.queryList(userId);
	}

	@Override
	public int queryCountByUid(int uid) {
		return resumeMapper.queryCountByUid(uid);
	}

	@Override
	public String queryNameByUid(int uid) {
		return resumeMapper.queryNameByUid(uid);
	}

	@Override
	public int delete(int id) {
		return resumeMapper.delete(id);
	}

}
