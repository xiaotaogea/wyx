package com.zjwm.wyx.course.service.impl;

import com.github.pagehelper.Page;
import com.zjwm.wyx.course.dao.ClassMapper;
import com.zjwm.wyx.course.entity.UserHClass;
import com.zjwm.wyx.course.service.UserClassService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("userClassService")
public class UserClassServiceImpl implements UserClassService {
	@Autowired
	private ClassMapper classMapper;

	@Override
	public Page<UserHClass> queryAll() {
		// TODO Auto-generated method stub
		return classMapper.queryAll();
	}


	@Override
	public UserHClass queryById(int cid) {
		// TODO Auto-generated method stub
		return classMapper.queryObject(cid);
	}

	@Override
	public List<String> queryWebNames() {
		return classMapper.queryWebNames();
	}

	@Override
	public List<String> queryAcNames(int wid) {
		return classMapper.queryAcNames(wid);
	}


	@Override
	public List<Integer> queryByTj(int wid, int acid) {
		// TODO Auto-generated method stub
		return classMapper.queryByTj(wid, acid);
	}

	@Override
	public String queryTimeByUidAndClid(int uid, int clid) {
		return classMapper.queryTimeByUidAndClid(uid,clid);
	}

	@Override
	public List<Integer> queryByTjAndUid(int wwid, int acid, int uid,int status) {
		return classMapper.queryByTjAndUid(wwid,acid,uid,status);
	}
}
