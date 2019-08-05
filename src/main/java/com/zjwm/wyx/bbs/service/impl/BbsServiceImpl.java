package com.zjwm.wyx.bbs.service.impl;

import com.zjwm.wyx.bbs.dao.BbsMapper;
import com.zjwm.wyx.bbs.entity.Bbs;
import com.zjwm.wyx.bbs.service.BbsService;
import com.zjwm.wyx.login.dao.HbbUserMapper;
import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.point.dao.UserPointMapper;
import com.zjwm.wyx.point.entity.UserPoint;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

@Service("bbsService")
public class BbsServiceImpl implements BbsService {
    @Resource
    private BbsMapper bbsMapper;
    @Resource
    private UserPointMapper pointMapper;
    @Resource
    private HbbUserMapper userDao;


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

    /**
     *
     * @param bbs 帖子
     * @param userPoint 积分
     * @param hbbUser 用户
     * @return 事物保存三张表
     */
    @Transactional
    @Override
    public int save(Bbs bbs, UserPoint userPoint, HbbUser hbbUser) {
        int res1 = bbsMapper.save(bbs);
        int res2 = pointMapper.save(userPoint);
        int res3 = userDao.update(hbbUser);
        return res1 + res2 + res3;
    }

}
