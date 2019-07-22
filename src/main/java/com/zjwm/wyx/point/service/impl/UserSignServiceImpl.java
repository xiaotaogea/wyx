package com.zjwm.wyx.point.service.impl;

import com.zjwm.wyx.point.dao.UserSignMapper;
import com.zjwm.wyx.point.entity.UserSign;
import com.zjwm.wyx.point.service.UserSignService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;




@Service("userSignService")
public class UserSignServiceImpl implements UserSignService {
	
	@Autowired
	private UserSignMapper userSignMapper;

	

	@Override
	public void save(UserSign userSign) {
		 userSignMapper.save(userSign);
		
	}

	@Override
	public UserSign queryByUid(int uid) {
		// TODO Auto-generated method stub
		return userSignMapper.queryObject(uid);
	}

	@Override
	public void update(UserSign userSign) {
		// TODO Auto-generated method stub
		userSignMapper.update(userSign);
	}
	
}
