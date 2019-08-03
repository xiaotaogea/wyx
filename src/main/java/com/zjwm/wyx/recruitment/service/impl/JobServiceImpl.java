package com.zjwm.wyx.recruitment.service.impl;

import com.zjwm.wyx.recruitment.dao.JobMapper;
import com.zjwm.wyx.recruitment.entity.Job;
import com.zjwm.wyx.recruitment.entity.Welfare;
import com.zjwm.wyx.recruitment.service.JobService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;


@Service("jobService")
public class JobServiceImpl implements JobService {
	@Resource
	private JobMapper jobMapper;


    @Override
    public Job queryObject(int id) {
        return jobMapper.queryObject(id);
    }

    @Override
    public String queryCompanyName(Integer userId) {
        return jobMapper.queryCompanyName(userId);
    }

    @Override
    public Welfare queryWelfares(Integer id) {
        return jobMapper.queryWelfares(id);
    }

    @Override
    public List<Job> queryHistory(int uid) {
        return jobMapper.queryHistory(uid);
    }

    @Override
    public List<Job> queryCollect(int uid) {
        return jobMapper.queryCollect(uid);
    }

    @Override
    public int deleteHistory(int id) {
        return jobMapper.delete(id);
    }

    @Override
    public int deleteCollect(int id) {
        return jobMapper.deleteCollect(id);
    }
}
