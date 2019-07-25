package com.zjwm.wyx.recruitment.dao;

import com.zjwm.wyx.recruitment.entity.Job;
import com.zjwm.wyx.recruitment.entity.Welfare;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface JobMapper extends BaseDao<Job> {
//    Job queryObject(@Param("id") Integer id);

    //公司名称
    String queryCompanyName(@Param("userId") Integer userId);

    //工作福利
    Welfare queryWelfares(@Param("id") Integer id);
    //浏览记录
    List<Job> queryHistory(@Param("uid") int uid);
    //浏览记录
    List<Job> queryCollect(@Param("uid") int uid);
    //删除收藏
    int deleteCollect(@Param("id") int id);
}
