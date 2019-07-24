package com.zjwm.wyx.course.service.impl;

import com.zjwm.wyx.course.dao.HoldMapper;
import com.zjwm.wyx.course.entity.Hold;
import com.zjwm.wyx.course.service.HoldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("holdService")
public class HoldServiceImpl implements HoldService {
	@Autowired
	private HoldMapper holdMapper;


	@Override
	public List<Hold> holdList(int uid) {
		// TODO Auto-generated method stub
		return holdMapper.holdList(uid);
	}

	@Override
	public int delHold(int uid, int clid) {
		return holdMapper.delHold(uid, clid);
		
	}



}
