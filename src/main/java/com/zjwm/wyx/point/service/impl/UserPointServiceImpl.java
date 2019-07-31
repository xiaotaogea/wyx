package com.zjwm.wyx.point.service.impl;

import com.zjwm.wyx.point.dao.UserPointMapper;
import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.point.service.UserPointService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("userPointService")
public class UserPointServiceImpl implements UserPointService {
	@Autowired
	private UserPointMapper userPointMapper;


	@Override
	public List<UserPoint> queryPointList(int uid, String fen) {
		return userPointMapper.queryPointList(uid,fen);
	}

	@Override
	public void insertUserPoint(UserPoint userPoint) {
		// TODO Auto-generated method stub
		userPointMapper.save(userPoint);
	}

	@Override
	public List<String> queryFen(int uid) {
		return userPointMapper.queryFen(uid);
	}


	@Override
	public List<UserPoint> queryByUid(int uid) {
		// TODO Auto-generated method stub
		return userPointMapper.queryByUid(uid);
	}
	
}
