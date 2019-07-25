package com.zjwm.wyx.recruitment.service;

import com.zjwm.wyx.recruitment.entity.Job;
import com.zjwm.wyx.recruitment.entity.Welfare;

import java.util.List;

/**
 * 用户
 *
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface JobService {
    Job queryObject(int id);

    //公司名称
    String queryCompanyName(Integer userId);

    //工作福利
    Welfare queryWelfares(Integer id);

    //浏览记录
    List<Job> queryHistory(int uid);
    //浏览记录
    List<Job> queryCollect(int uid);
    //删除浏览
    int deleteHistory(int id);
    //删除收藏
    int deleteCollect(int id);

}
