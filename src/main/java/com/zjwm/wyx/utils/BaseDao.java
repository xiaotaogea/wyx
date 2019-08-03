package com.zjwm.wyx.utils;

import java.util.List;
import java.util.Map;


public interface BaseDao<T> {

	int save(T t);

	void save(Map<String, Object> map);


	int update(T t);

	int delete(Object id);

	int delete(Map<String, Object> map);


	T queryObject(Object id);

	List<T> queryList(Map<String, Object> map);

	List<T> queryList(Object id);


	int queryTotal();
}
