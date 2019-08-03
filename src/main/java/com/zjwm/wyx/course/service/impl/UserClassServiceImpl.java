package com.zjwm.wyx.course.service.impl;

import com.github.pagehelper.Page;
import com.zjwm.wyx.course.dao.ClassMapper;
import com.zjwm.wyx.course.entity.UserHClass;
import com.zjwm.wyx.course.service.UserClassService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;



@Service("userClassService")
public class UserClassServiceImpl implements UserClassService {
	@Resource
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
	public List<UserHClass> queryByTjAndUid(Integer uid, Integer status, Integer parent, Integer child) {
		return classMapper.queryByTjAndUid(uid,status,parent,child);
	}
}
