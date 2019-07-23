package com.zjwm.wyx.recruitment.service.impl;

import com.zjwm.wyx.recruitment.dao.ArticleMapper;
import com.zjwm.wyx.recruitment.entity.Article;
import com.zjwm.wyx.recruitment.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;



@Service("articleService")
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleMapper articleMapper;

	@Override
	public List<Article> queryList() {
		// TODO Auto-generated method stub
		return articleMapper.queryAll();
	}


	@Override
	public Article queryObject(int id) {
		// TODO Auto-generated method stub
		return articleMapper.queryObject(id);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		articleMapper.delete(id);
	}
	
	
}
