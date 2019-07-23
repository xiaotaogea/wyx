package com.zjwm.wyx.recruitment.service;

import com.zjwm.wyx.recruitment.entity.Article;

import java.util.List;

/**
 * 用户
 * 
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface ArticleService {
	Article queryObject(int id);
	
	List<Article> queryList();
	
	
	void delete(int id);
	
}
