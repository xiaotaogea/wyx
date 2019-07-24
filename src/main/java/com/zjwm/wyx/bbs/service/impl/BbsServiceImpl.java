package com.zjwm.wyx.bbs.service.impl;

import com.zjwm.wyx.bbs.dao.BbsMapper;
import com.zjwm.wyx.bbs.entity.Bbs;
import com.zjwm.wyx.bbs.service.BbsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {
    @Autowired
    private BbsMapper bbsMapper;

    @Override
    public List<Bbs> queryList(int uid) {
        // TODO Auto-generated method stub
        return bbsMapper.queryList(uid);
    }

    @Override
    public Bbs queryById(int id) {
        return bbsMapper.queryObject(id);
    }

    @Override
    public List<Bbs> queryReply(int userId) {
        return bbsMapper.queryReply(userId);
    }

    @Override
    public List<String> querycateParentName() {
        return bbsMapper.querycateParentName();
    }

    @Override
    public List<String> querycateChildName(int id) {
        return bbsMapper.querycateChildName(id);
    }

    @Override
    public List<String> queryLabs() {
        return bbsMapper.queryLabs();
    }

    @Override
    public int save(Bbs bbs) {
       return bbsMapper.save(bbs);
    }

}
