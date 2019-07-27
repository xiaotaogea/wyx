package com.zjwm.wyx.charts.controller;

import com.zjwm.wyx.charts.entity.Time;
import com.zjwm.wyx.charts.service.TimeService;
import com.zjwm.wyx.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.text.DecimalFormat;
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
     *
     * @param uid
     * @param type
     * @return
     */
    @RequestMapping("SevenList")
    public Map<Object, Object> getTime(int uid, Integer type) {
        //存放日期-时长,并进行日期排序
        Map map = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Time> list = null;
        switch (type) {
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
        DecimalFormat df = new DecimalFormat("######0.00");
        String timesStr = null;
        //遍历7天
        for (int i = 0; i < pastTime.size(); i++) {
            String past = pastTime.get(i);
            for (int j = 0; j < list.size(); j++) {
                //每个登录对象
                Time time = list.get(j);
                //把实际日期和登录的日期作对比，如果有实际的日期，设置该对象登录时间，如果没有这七天的日期，时间设为0
                if (past.equals(DateUtils.timeStampToDate(String.valueOf(time.getAddTime()), "yyyy-MM-dd"))) {
                    Double times = Double.valueOf(time.getStudyTime()) / 60.0;
                    timesStr = df.format(times);
                    map.put(past, timesStr);
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
     *
     * @param uid
     * @param type
     * @return
     */
    @RequestMapping("monthList")
    public Map<Object, Object> getMonth(int uid, Integer type) {
        //存放日期-时长,并进行日期排序
        Map map = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Time> list = null;
        switch (type) {
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
        DecimalFormat df = new DecimalFormat("######0.00");
        String timesStr = null;
        //遍历7天
        for (int i = 0; i < pastTime.size(); i++) {
            String past = pastTime.get(i);
            for (int j = 0; j < list.size(); j++) {
                //每个登录对象
                Time time = list.get(j);
                //把实际日期和登录的日期作对比，如果有实际的日期，设置该对象登录时间，如果没有这七天的日期，时间设为0
                if (past.equals(DateUtils.timeStampToDate(String.valueOf(time.getAddTime()), "yyyy-MM-dd"))) {
                    Double times = Double.valueOf(time.getStudyTime()) / 60.0;
                    timesStr = df.format(times);
                    map.put(past, timesStr);
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
     *
     * @param uid
     * @param type
     * @return
     */
    @RequestMapping("yearList")
    public Map<Object, Object> getYear(int uid, Integer type) {
        //存放日期-时长,并进行日期排序
        Map map = new TreeMap(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o2.compareTo(o1);
            }
        });
        List<Time> list = null;
        switch (type) {
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
        DecimalFormat df = new DecimalFormat("######0.00");
        String timesStr = null;

        StringBuilder stringBuilder = new StringBuilder();

        //遍历
        for (int i = 0; i < pastTime.size(); i++) {
            String past = pastTime.get(i);
            for (int j = 0; j < list.size(); j++) {
                //每个登录对象
                Time time = list.get(j);
                //把实际日期和登录的日期作对比，如果有实际的日期，设置该对象登录时间，如果没有日期，时间设为0
                if (past.equals(DateUtils.timeStampToDate(String.valueOf(time.getAddTime()), "yyyy-MM"))) {
                    Double times = Double.valueOf(time.getStudyTime()) / 3600.0;
//                    System.out.println(past+"----------"+times);
                    timesStr = df.format(times);
                    stringBuilder.append("+" + timesStr);
                    break;
                } else {
                    stringBuilder.append("+0");
                }

            }

            //计算总时间
            ScriptEngineManager manager = new ScriptEngineManager();
            ScriptEngine engine = manager.getEngineByName("js");
            Object result = null;

            try {
                result = engine.eval(new String(stringBuilder));
            } catch (ScriptException e) {
                e.printStackTrace();
            }
            map.put(past, result);

        }
        return map;
    }
}
