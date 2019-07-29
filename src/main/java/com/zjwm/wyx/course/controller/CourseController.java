/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: CourseController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.course.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.course.entity.Comment;
import com.zjwm.wyx.course.entity.Hold;
import com.zjwm.wyx.course.entity.Note;
import com.zjwm.wyx.course.entity.UserHClass;
import com.zjwm.wyx.course.service.CommentService;
import com.zjwm.wyx.course.service.HoldService;
import com.zjwm.wyx.course.service.NoteService;
import com.zjwm.wyx.course.service.UserClassService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 查询课程列表，课程详情，笔记，评论
 * version 2018.3
 */
@RestController
@RequestMapping("/course")
@Api(description = "我的课程")
public class CourseController {

    @Resource
    private UserClassService userClassService;
    @Resource
    private NoteService noteService;
    @Resource
    private CommentService commentService;
    @Resource
    private HoldService holdService;


    /**
     * 功能描述：查询一级分类课程
     *
     * @return 一级课程分类列表
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/webNames")
    @ApiOperation(value = "一级分类课程")
    public List<String> getNames() {
        return userClassService.queryWebNames();
    }

    /**
     * 功能描述：根据一级课程id查询类别下的课程列表
     *
     * @return 二级课程分类列表
     * @author 王俊涛
     * @version 2018.3
     * @Parmm wid web一级课程id
     */
    @GetMapping("/acNames")
    @ApiOperation(value = "二级分类课程")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "wid", value = "一级课程id,如3", required = true, dataType = "int")
    })
    public List<String> getAcNames(int wid) {
        return userClassService.queryAcNames(wid);
    }


    /**
     * 功能描述：
     *
     * @param uid      用户id
     * @param currPage 当前页,默认1
     * @param parent   一级课程id
     * @param child    二级课程id
     * @param status   0用户未完成，1用户已完成
     * @return com.github.pagehelper.PageInfo<com.zjwm.wyx.course.entity.UserHClass>
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/all")
    @ApiOperation(value = "课程管理：全部课程、用户课程列表接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id，如889", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页,默认1", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "parent", value = "一级查询课程id，如3", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "child", value = "二级查询课程id，如24", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "status", value = "0用户未完成，1用户已完成", required = false, dataType = "int")
    })

    public PageInfo<?> getAllCourse(Integer uid, Integer currPage, Integer parent, Integer child, Integer status) {
        currPage = (currPage == null) ? 1 : currPage;

        PageInfo<UserHClass> page = null;
        PageHelper.startPage(currPage, 5);

        // uid不为null时，为个人完成课程情况
        if (status != null) {
            //status为0时，未完成，为1时，已完成
            List<UserHClass> classes = userClassService.queryByTjAndUid(uid, status, parent, child);
            for (UserHClass hclass : classes) {
                //得到每个用户每个课程的观看时间
                String wTime = userClassService.queryTimeByUidAndClid(uid, hclass.getId());
                hclass.setWTime(Integer.valueOf(wTime));

            }
            page = new PageInfo<>(classes);

        } else {// 查全部课程
            List<UserHClass> hList = new ArrayList<>();
            if (parent == null && child == null) {
                hList = userClassService.queryAll();
            } else {
                hList = userClassService.queryByTj(parent, child);
            }
            page = new PageInfo<>(hList);
        }
        return page;

    }

    /**
     * 功能描述：查询用户的笔记和详情信息
     *
     * @param uid      用户id
     * @param currPage 当前页,默认1
     * @param token    查看笔记详情时,必选值detail
     * @return com.github.pagehelper.PageInfo<?> 笔记列表和笔记详情列表
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/note")
    @ApiOperation(value = "课程笔记和详情接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id，如15443", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页,默认1", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "token", value = "查看笔记详情时,必选值detail", required = false, dataType = "string"),
    })
    public PageInfo<?> getListNote(int uid, Integer currPage, String token) {
        currPage = (currPage == null) ? 1 : currPage;
        PageHelper.startPage(currPage, 8);
        List<UserHClass> hClass = new ArrayList<>();

        // 用户所有笔记,按课程分组
        List<Note> notes = noteService.queryNotesByUid(uid);

        for (Note note : notes) {
            int cid = note.getClid();
            int noteNum = noteService.queryCount(uid, cid);
            UserHClass userHClass = userClassService.queryById(cid);
            note.setNoteNum(noteNum);
            note.setUserHClass(userHClass);
            // 每个课程的笔记列表详情
            if (token != null && token.equals("detail")) {
                List<Note> noteDetails = noteService.queryNotesByUidAndCid(uid, cid);
                PageInfo<Note> page = new PageInfo<>(noteDetails);
                return page;
            }

        }

        PageInfo<Note> page = new PageInfo<>(notes);
        return page;
    }

    /**
     * 功能描述：查询用户的评论信息
     *
     * @param uid      用户id
     * @param currPage 当前页,默认1
     * @param type     all:全部，good：好评，mid：中评,bad：差评  默认all
     * @return com.github.pagehelper.PageInfo<?>
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/comment")
    @ApiOperation(value = "课程评论接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id，如15443", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页,默认1", required = false, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "all:全部，good：好评，mid：中评,bad：差评  默认all", required = false, dataType = "string"),
    })
    public PageInfo<Comment> getListComment(int uid, Integer currPage, String type) {
        currPage = (currPage == null) ? 1 : currPage;
        type = (type == null) ? "all" : type;
        PageHelper.startPage(currPage, 2);
        List<Comment> comments = null;
        switch (type) {
            // 全部
            case "all":
                comments = commentService.queryList(uid);
                break;
            // 好评
            case "good":
                comments = commentService.queryGoodList(uid);
                break;
            // 中评
            case "mid":
                comments = commentService.queryMidList(uid);
                break;
            // 差评
            case "bad":
                comments = commentService.queryBadList(uid);
                break;
        }

        return new PageInfo<>(comments);
    }

    /**
     * 功能描述：查询用户的收藏课程列表
     *
     * @param uid      用户id
     * @param currPage 当前页,默认1
     * @return com.github.pagehelper.PageInfo<com.zjwm.wyx.course.entity.Hold>
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/hold")
    @ApiOperation(value = "收藏课程接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页,默认1", required = true, dataType = "int"),
    })
    public PageInfo<Hold> getAllCourse(int uid, Integer currPage) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 5);
        // 收藏的所有试课程
        List<Hold> list = holdService.holdList(uid);
        PageInfo<Hold> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 功能描述：取消收藏
     *
     * @param uid  用户id
     * @param clid 要取消的课程id
     * @return void
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("/delHold")
    @ApiOperation(value = "取消课程收藏接口")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "clid", value = "要取消的课程id", required = true, dataType = "int"),
    })
    public void delHold(int uid, int clid) {
        holdService.delHold(uid, clid);
    }

}
