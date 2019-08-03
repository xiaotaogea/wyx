package com.zjwm.wyx.recruitment.service.impl;

import com.zjwm.wyx.recruitment.dao.SendResumeMapper;
import com.zjwm.wyx.recruitment.entity.SendResume;
import com.zjwm.wyx.recruitment.service.SendResumeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



@Service("sendResumeService")
public class SendResumeServiceImpl implements SendResumeService {
	@Resource
	private SendResumeMapper sendResumeMapper;

	@Override
	public List<SendResume> querySeeList(int uid) {
		// TODO Auto-generated method stub
		return sendResumeMapper.querySeeList(uid);
	}

	@Override
	public List<SendResume> queryYesList(int uid) {
		// TODO Auto-generated method stub
		return sendResumeMapper.queryYesList(uid);
	}

	@Override
	public List<SendResume> queryNoList(int uid) {
		// TODO Auto-generated method stub
		return sendResumeMapper.queryNoList(uid);
	}

	@Override
	public List<SendResume> queryList(int uid) {
		// TODO Auto-generated method stub
		return sendResumeMapper.queryList(uid);
	}

	

}
