package com.zjwm.wyx.course.service;

import com.zjwm.wyx.course.entity.Comment;

import java.util.List;

public interface CommentService {

	List<Comment> queryList(int uid,String type);


	int save(Comment comment);
}
