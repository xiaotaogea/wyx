package com.zjwm.wyx.bbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.bbs.entity.Bbs;
import com.zjwm.wyx.bbs.service.BbsService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 我的论坛
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/bbs")
public class BbsController {

    @Resource
    private BbsService bbsService;

    /**
     * 我的
     *
     * @param current
     * @param uid
     * @param type    1：我的帖子 其他：参与
     * @return
     */
    @RequestMapping("list")
    private PageInfo<Bbs> getBbs(Integer current, int uid, Integer type) {
        current = current == null ? 1 : current;
        List<Bbs> bbs = null;

        PageHelper.startPage(current, 5);
        switch (type) {
            case 1:
                bbs = bbsService.queryList(uid);
                break;
            default:
                bbs = bbsService.queryReply(uid);
                break;
        }
        PageInfo<Bbs> page = new PageInfo<>(bbs);
        return page;

    }

    /**
     * 发帖
     *
     * @param bs
     * @return
     */
    @RequestMapping("save")
    private Map<String, String> save(HttpServletRequest request, Bbs bs) {
        int userId = (int) request.getSession().getAttribute("userId");
        Map<String, String> map = new HashMap<>();
        Bbs bbs = new Bbs();
        bbs.setCateId(bs.getCateId());
        bbs.setFen(bs.getFen());
        bbs.setContent(bs.getContent());
        bbs.setTitle(bs.getTitle());
        bbs.setUid(userId);
        bbs.setLable(bs.getLable());
        bbs.setCreateTime((int) (System.currentTimeMillis() / 1000));
        bbs.setType(bs.getType());
        int res = bbsService.save(bbs);
        if (res==1){
            map.put("data","发表成功");
        }else {
            map.put("data","发表失败");
        }
        return map;
    }

    /**
     * 帖子的信息
     *
     * @param id
     * @return
     */
    @RequestMapping("info")
    private Bbs getBbsInfo(int id) {
        return bbsService.queryById(id);
    }

    /**
     * 一级种类名称
     *
     * @return
     */
    @RequestMapping("cateName")
    private List<String> getBbsCate() {
        return bbsService.querycateParentName();
    }

    /**
     * 二级种类名称
     *
     * @param id 父类的id
     * @return
     */
    @RequestMapping("names")
    private List<String> getBbsCateName(int id) {
        return bbsService.querycateChildName(id);
    }

    /**
     * 标签
     *
     * @return
     */
    @RequestMapping("labs")
    private List<String> getLabs() {
        return bbsService.queryLabs();
    }
}
