package com.zjwm.wyx.charts.controller;

import com.zjwm.wyx.charts.entity.Time;
import com.zjwm.wyx.charts.service.TimeService;
import com.zjwm.wyx.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.*;

/**
 * 数据统计
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/charts")
public class TimeController {

    @Autowired
    private TimeService timeService;

    /**
     * 7天时间数据
     * @param uid
     * @param type
     * @return
     */
    @RequestMapping("SevenList")
    public Map<Object, Object> getTime(int uid,Integer type) {
        //存放日期-时长,并进行日期排序
        Map map = new TreeMap(new Comparator<String> (){
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Time> list = null;
        switch (type){
            //获取最后登录的7天数据
            case 1:
                list = timeService.queryOnList(uid);
                break;
            //获取最后学习的7天数据
            case 2:
                list = timeService.queryStudyList(uid);
                break;
        }

        //获取过去七天的日期
        ArrayList<String> pastTime = DateUtils.test(7);

        //遍历7天
        for (int i = 0; i < pastTime.size(); i++) {
            String past = pastTime.get(i);
            for (int j = 0;j<list.size();j++){
                //每个登录对象
                Time time = list.get(j);
                //把实际日期和登录的日期作对比，如果有实际的日期，设置该对象登录时间，如果没有这七天的日期，时间设为0
                if (past.equals(DateUtils.timeStampToDate(String.valueOf(time.getAddTime()), "yyyy-MM-dd"))) {
                    map.put(past, Math.round(Integer.valueOf(time.getStudyTime()) / 60));
                    break;
                } else {
                    map.put(past, 0);
                }
            }

        }
        return map;
    }

    /**
     * 一个月时间数据
     * @param uid
     * @param type
     * @return
     */
    @RequestMapping("monthList")
    public Map<Object, Object> getMonth(int uid,Integer type) {
        //存放日期-时长,并进行日期排序
        Map map = new TreeMap(new Comparator<String> (){
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Time> list = null;
        switch (type){
            //获取最后登录的一个月数据
            case 1:
                list = timeService.queryOnMonthList(uid);
                break;
            //获取最后学习的一个月数据
            case 2:
                list = timeService.queryStudyMonthList(uid);
                break;
        }

        //获取过去一个月的日期
        List<String> pastTime = DateUtils.getDateStr();

        //遍历7天
        for (int i = 0; i < pastTime.size(); i++) {
            String past = pastTime.get(i);
            for (int j = 0;j<list.size();j++){
                //每个登录对象
                Time time = list.get(j);
                //把实际日期和登录的日期作对比，如果有实际的日期，设置该对象登录时间，如果没有这七天的日期，时间设为0
                if (past.equals(DateUtils.timeStampToDate(String.valueOf(time.getAddTime()), "yyyy-MM-dd"))) {
                    map.put(past, Math.round(Integer.valueOf(time.getStudyTime()) / 60));
                    break;
                } else {
                    map.put(past, 0);
                }
            }

        }
        return map;
    }


    /**
     * 一年时间数据
     * @param uid
     * @param type
     * @return
     */
    /*@RequestMapping("yearList")
    public Map<Object, Object> getYear(int uid,Integer type) {
        //存放日期-时长,并进行日期排序
        Map map = new TreeMap(new Comparator<String> (){
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Time> list = null;
        switch (type){
            //获取登录一年数据
            case 1:
                list = timeService.queryOnYearList(uid);
                break;
            //获取学习一年数据
            case 2:
                list = timeService.queryStudyYearList(uid);
                break;
        }

        //获取过去一年的日期
        List<String> pastTime = DateUtils.getYearStr();

        //遍历
        for (int i = 0; i < pastTime.size(); i++) {
            String past = pastTime.get(i);
            for (int j = 0;j<list.size();j++){
                //每个登录对象
                Time time = list.get(j);
                //把实际日期和登录的日期作对比，如果有实际的日期，设置该对象登录时间，如果没有这七天的日期，时间设为0
                if (past.equals(DateUtils.timeStampToDate(String.valueOf(time.getAddTime()), "yyyy-MM"))) {
                    double studyTime = Double.valueOf(time.getStudyTime());
                    System.out.println(studyTime);
                    if (studyTime<1.0 && studyTime>0.0){
                        map.put(past, 1);
                    }else if (studyTime>1.0){
                        map.put(past, 23);
                    }

                    break;
                } else {
                    map.put(past, 0);
                }
            }

        }
        return map;
    }*/
}
