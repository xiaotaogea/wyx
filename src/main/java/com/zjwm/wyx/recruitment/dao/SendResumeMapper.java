package com.zjwm.wyx.recruitment.dao;

import com.zjwm.wyx.recruitment.entity.SendResume;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 职位
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface SendResumeMapper extends BaseDao<SendResume> {

	List<SendResume> queryList(int uid);

	List<SendResume> querySeeList(int uid);

	List<SendResume> queryYesList(int uid);

	List<SendResume> queryNoList(int uid);
}
