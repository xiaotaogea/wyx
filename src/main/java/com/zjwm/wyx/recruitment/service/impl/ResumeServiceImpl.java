package com.zjwm.wyx.recruitment.service.impl;

import com.zjwm.wyx.recruitment.dao.EmploymentMapper;
import com.zjwm.wyx.recruitment.dao.ProjectMapper;
import com.zjwm.wyx.recruitment.dao.ResumeMapper;
import com.zjwm.wyx.recruitment.entity.Employment;
import com.zjwm.wyx.recruitment.entity.Project;
import com.zjwm.wyx.recruitment.entity.Resume;
import com.zjwm.wyx.recruitment.service.ResumeService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("resumeService")
public class ResumeServiceImpl implements ResumeService {
    @Resource
    private ResumeMapper resumeMapper;
    @Resource
    private EmploymentMapper employmentMapper;
    @Resource
    private ProjectMapper projectMapper;

    @Override
    public Resume queryById(int id) {
        // TODO Auto-generated method stub
        return resumeMapper.queryObject(id);
    }

    @Override
    public List<String> queryPName() {
        return resumeMapper.queryPName();
    }

    @Override
    public List<String> querySName(Integer id) {
        return resumeMapper.querySName(id);
    }

    @Override
    public List<String> queryPArea() {
        return resumeMapper.queryPArea();
    }

    @Override
    public List<String> querySArea(Integer pid) {
        return resumeMapper.querySArea(pid);
    }

    @Override
    public List<Resume> queryList(int userId) {
        // TODO Auto-generated method stub
        return resumeMapper.queryList(userId);
    }

    @Override
    public int queryCountByUid(int uid) {
        return resumeMapper.queryCountByUid(uid);
    }

    @Override
    public String queryNameByUid(int uid) {
        return resumeMapper.queryNameByUid(uid);
    }

    @Transactional
    @Override
    public int save(Resume resume, Employment employment, Project project) {
        int res1 = resumeMapper.save(resume);
        int res2 = employmentMapper.save(employment);
        int res3 = projectMapper.save(project);
        return res1 + res2 + res3;
    }

    @Transactional
    @Override
    public int delete(int id) {
        int res1 = resumeMapper.delete(id);
        int res2 = employmentMapper.delete(id);
        int res3 = projectMapper.delete(id);
        return res1 + res2 + res3;
    }

}
