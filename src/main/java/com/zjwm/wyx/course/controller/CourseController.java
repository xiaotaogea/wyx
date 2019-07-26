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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

/**
 * 课程
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/course")
public class CourseController {

    @Autowired
    private UserClassService userClassService;
    @Resource
    private NoteService noteService;
    @Resource
    private CommentService commentService;
    @Autowired
    private HoldService holdService;

    /**
     * web名字列表
     * @return
     */
    @RequestMapping("/webNames")
    public List<String> getNames() {
        return userClassService.queryWebNames();
    }

    @RequestMapping("/acNames")
    public List<String> getAcNames(int wid) {
        return userClassService.queryAcNames(wid);
    }

    /**
     * 我的课程
     *
     * @param currPage 当前页
     * @param parent   一级筛选
     * @param child    二级筛选
     * @param status   课程完成情况
     * @return
     */
    @RequestMapping("/all")
    public PageInfo<UserHClass> getAllCourse(HttpServletRequest request, Integer currPage, Integer parent, Integer child, Integer status) {
        //从session里獲得用户id
        Integer uid = (Integer) request.getSession().getAttribute("userId");
        currPage = (currPage == null) ? 1 : currPage;
        PageHelper.startPage(currPage, 5);

        PageInfo<UserHClass> page = null;
        List<Integer> cids = null;

        List<UserHClass> hList = new ArrayList<>();
        // uid不为null时，为个人完成课程情况
        if (status != null) {
            //status为0时，未完成，为1时，已完成
            cids = userClassService.queryByTjAndUid(parent, child, uid, status);

            for (Integer cid : cids) {
                UserHClass userHClass = userClassService.queryById(cid);
                //得到每个用户每个课程的观看时间
                String wTime = userClassService.queryTimeByUidAndClid(uid, cid);
                userHClass.setWTime(Integer.valueOf(wTime));
                hList.add(userHClass);
            }
            page = new PageInfo<>(hList);

        } else {// 查全部课程
            List<Integer> clids = userClassService.queryByTj(parent,child);

            for (Integer clid : clids) {
                hList.add(userClassService.queryById(clid));
            }
            page = new PageInfo<>(hList);


        }

        return page;

    }

    /**
     * 课程 笔记、列表
     *
     * @return
     */
    @RequestMapping("/note")
    public PageInfo<?> getListNote(HttpServletRequest request,Integer currPage, String token) {
        //从session里獲得用户id
        Integer uid = (Integer) request.getSession().getAttribute("userId");
        currPage = (currPage == null) ? 1 : currPage;
        PageHelper.startPage(currPage, 8);
        List<UserHClass> hClass = new ArrayList<>();

        // 用户所有笔记,按课程分组
        List<Note> notes = noteService.queryNotesByUid(uid);

        for (Note note : notes) {
            int cid = note.getClid();
            int noteNum = noteService.queryCount(uid, cid);
            UserHClass classNote = userClassService.queryById(cid);
            classNote.setNoteNum(noteNum);
            hClass.add(classNote);
            // 每个课程的笔记列表详情
            if (token != null && token.equals("detail")) {
                List<Note> noteDetails = noteService.queryNotesByUidAndCid(uid, cid);
                PageInfo<Note> page = new PageInfo<>(noteDetails);
                return page;
            }

        }

        PageInfo<UserHClass> page = new PageInfo<>(hClass);
        return page;
    }

    /**
     * 课程 评价
     *
     * @return
     */
    @RequestMapping("/comment")
    public PageInfo<?> getListComment(Integer currPage, HttpServletRequest request, String type) {
        //从session里獲得用户id
        Integer uid = (Integer) request.getSession().getAttribute("userId");
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
            default:
                comments = commentService.queryBadList(uid);
                break;
        }

        PageInfo<Comment> page = new PageInfo<>(comments);
        return page;
    }

    /**
     * 收藏课程
     *
     * @return
     */
    @RequestMapping("/hold")
    public PageInfo<Hold> getAllCourse(Integer currPage,HttpServletRequest request) {
        //从session里獲得用户id
        Integer uid = (Integer) request.getSession().getAttribute("userId");
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 5);
        // 收藏的所有试课程
        List<Hold> list = holdService.holdList(uid);
        PageInfo<Hold> page = new PageInfo<>(list);
        return page;
    }

    /**
     * 取消收藏
     *
     * @return
     */
    @RequestMapping("/delHold")
    public void delHold(int uid, int clid) {
        holdService.delHold(uid, clid);
    }

}
