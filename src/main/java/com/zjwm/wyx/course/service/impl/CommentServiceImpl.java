package com.zjwm.wyx.course.service.impl;

import com.zjwm.wyx.course.dao.CommentMapper;
import com.zjwm.wyx.course.entity.Comment;
import com.zjwm.wyx.course.service.CommentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("commentService")
public class CommentServiceImpl implements CommentService {
	@Resource
	private CommentMapper commentMapper;

	@Override
	public List<Comment> queryList(int uid) {
		// TODO Auto-generated method stub
		return commentMapper.queryList(uid);
	}

	@Override
	public List<Comment> queryGoodList(int uid) {
		// TODO Auto-generated method stub
		return commentMapper.queryGoodList(uid);
	}

	@Override
	public List<Comment> queryMidList(int uid) {
		// TODO Auto-generated method stub
		return commentMapper.queryMidList(uid);
	}

	@Override
	public List<Comment> queryBadList(int uid) {
		// TODO Auto-generated method stub
		return commentMapper.queryBadList(uid);
	}

}
