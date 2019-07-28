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
	public List<String> queryAcNames(Integer wid) {
		return classMapper.queryAcNames(wid);
	}


	@Override
	public List<UserHClass> queryByTj(Integer wid, Integer acid) {
		// TODO Auto-generated method stub
		return classMapper.queryByTj(wid, acid);
	}

	@Override
	public String queryTimeByUidAndClid(Integer uid, Integer clid) {
		return classMapper.queryTimeByUidAndClid(uid,clid);
	}

	@Override
	public List<Integer> queryByTjAndUid(Integer wwid, Integer acid, Integer uid,Integer status) {
		return classMapper.queryByTjAndUid(wwid,acid,uid,status);
	}
}
