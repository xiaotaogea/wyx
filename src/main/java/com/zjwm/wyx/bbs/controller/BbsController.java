/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: BbsController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.bbs.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.bbs.entity.Bbs;
import com.zjwm.wyx.bbs.service.BbsService;
import com.zjwm.wyx.login.entity.UserEntity;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.point.service.UserPointService;
import com.zjwm.wyx.utils.CountUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 我的论坛：我的帖子，参与，发帖
 * version 2018.3
 */

@RestController
@RequestMapping("/bbs")
@Api(description = "我的论坛")
public class BbsController {

    @Resource
    private BbsService bbsService;
    @Resource
    private UserService userService;
    @Resource
    private UserPointService pointService;

    /**
     * 我的帖子
     *
     * @param currPage 当前页，默认是1
     * @param uid      用户id
     * @param type     1：我的帖子 其他：参与
     * @return 帖子分页数据
     */
    @GetMapping("list")
    @ApiOperation(value = "查询关于用户的所有帖子")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如889", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "1:我的帖子，2:我的参与  默认1", dataType = "int"),
    })
    public PageInfo<Bbs> getBbs(Integer currPage, int uid, Integer type) {
        currPage = currPage == null ? 1 : currPage;
        List<Bbs> bbs = null;
        type = type == null ? 1 : type;
        PageHelper.startPage(currPage, 5);
        switch (type) {
            case 1:
                bbs = bbsService.queryList(uid);
                break;
            case 2:
                bbs = bbsService.queryReply(uid);
                break;
        }
        if (bbs == null) {
            return null;
        }
        return new PageInfo<>(bbs);

    }

    /**
     * 发帖，同时添加到积分表里,同时用户表的总积分改变
     *
     * @param uid 用户id
     * @param bbs  帖子对象
     * @return Map<String   ,       String>
     */
    @GetMapping("save")
    @ApiOperation(value = "发帖")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如889", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "bbs", value = "帖子对象", required = true, dataType = "com.zjwm.wyx.bbs.entity.Bbs"),
    })
    public Map<String, String> save(int uid, Bbs bbs) {
        Map<String, String> map = new HashMap<>();
        bbs.setUid(uid);
        bbs.setCreateTime((int) (System.currentTimeMillis() / 1000));
        //积分表对象
        UserPoint userPoint = new UserPoint();
        userPoint.setUid(uid);
        userPoint.setAddTime((int) (System.currentTimeMillis() / 1000));
        int type = bbs.getType();
        switch (type){
            case 1:
                userPoint.setMethod("帖子加精奖励");
                userPoint.setType(0);
                userPoint.setContent("帖子:"+bbs.getId()+"-"+bbs.getTitle());
                userPoint.setFen("+10");
                break;
            case 2:
                userPoint.setMethod("悬赏贴");
                userPoint.setType(1);
                userPoint.setContent("发布悬赏贴");
                userPoint.setFen("-10");
                break;
        }
        UserEntity userEntity = userService.queryObject(uid);
        List<String> points = pointService.queryFen(uid);
        StringBuilder builder = null;
        for (String point : points) {
            builder.append(point);
        }
        //计算总积分，set到用户表
        Object total = CountUtil.total(new String(builder));
        userEntity.setFen((String) total);
        int res = bbsService.save(bbs,userPoint,userEntity);
        if (res == 3) {
            map.put("data", "发表成功");
        } else {
            map.put("data", "发表失败");
        }
        return map;
    }

    /**
     * 帖子的信息
     *
     * @param id 帖子id
     * @return Bbs
     */
    @GetMapping("info")
    @ApiOperation(value = "帖子信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "帖子id,如28", required = true, dataType = "int"),
    })
    public Bbs getBbsInfo(int id) {
        return bbsService.queryById(id);
    }

    /**
     * 一级种类名称
     *
     * @return 一级栏目名称列表
     */
    @GetMapping("cateName")
    @ApiOperation(value = "查询一级栏目分类")
    public List<String> getBbsCate() {
        return bbsService.querycateParentName();
    }

    /**
     * 二级种类名称
     *
     * @param id 父类的id
     * @return 子类栏目名称列表
     */
    @GetMapping("names")
    @ApiOperation(value = "根据一级栏目id查询子类栏目")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "一级帖子id，如2", required = true, dataType = "int"),
    })
    public List<String> getBbsCateName(int id) {
        return bbsService.querycateChildName(id);
    }

    /**
     * 标签
     *
     * @return 标签列表
     */
    @GetMapping("labs")
    @ApiOperation(value = "帖子所有标签")
    public List<String> getLabs() {
        return bbsService.queryLabs();
    }
}
