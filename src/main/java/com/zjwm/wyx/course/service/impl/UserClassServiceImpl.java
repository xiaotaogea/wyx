package com.zjwm.wyx.course.service.impl;

import com.github.pagehelper.Page;
import com.zjwm.wyx.course.dao.UserHClassMapper;
import com.zjwm.wyx.course.dao.UserWClassMapper;
import com.zjwm.wyx.course.entity.UserHClass;
import com.zjwm.wyx.course.entity.UserWClass;
import com.zjwm.wyx.course.service.UserClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("userClassService")
public class UserClassServiceImpl implements UserClassService {
	@Autowired
	private UserHClassMapper userHClassMapper;
	@Autowired
	private UserWClassMapper userWClassMapper;

	@Override
	public Page<UserHClass> queryAll() {
		// TODO Auto-generated method stub
		return userHClassMapper.queryAll();
	}

	@Override
	public List<UserWClass> queryByUidAndStatusNo(int uid) {
		// TODO Auto-generated method stub
		return userWClassMapper.queryByUidAndStatusNo(uid);
	}

	@Override
	public UserHClass queryById(int cid) {
		// TODO Auto-generated method stub
		return userHClassMapper.queryObject(cid);
	}

	@Override
	public List<UserWClass> queryByUidAndStatusYes(int uid) {
		// TODO Auto-generated method stub
		return userWClassMapper.queryByUidAndStatusYes(uid);
	}


	@Override
	public List<Integer> queryByTj(int wid, int acid) {
		// TODO Auto-generated method stub
		return userHClassMapper.queryByTj(wid, acid);
	}

	@Override
	public List<Integer> queryByTjAndUid(int wwid, int acid, int uid,int status) {
		return userHClassMapper.queryByTjAndUid(wwid,acid,uid,status);
	}
}
