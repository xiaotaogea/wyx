/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: DateStatisticController
  Author: 王俊涛
  Date：2019/7/28 0028 16:40
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.charts.controller;

import com.zjwm.wyx.charts.entity.Time;
import com.zjwm.wyx.charts.service.TimeService;
import com.zjwm.wyx.utils.CountUtil;
import com.zjwm.wyx.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.DecimalFormat;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * @version 2018.3
 * @Description 统计周、月、年的学习和登录数据
 */
@RestController
@RequestMapping("/charts")
@Api(description = "数据统计")
public class DateStatisticController {
    @Resource
    private TimeService timeService;

    /**
     * 功能描述：用户指定的时间数据统计
     *
     * @param uid  用户id
     * @param type 1：登录时间 2：学习时间
     * @return java.util.Map<java.lang.Object , java.lang.Object  >  日期 -- 学习、登录时间                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                         ,                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                               java.lang.Object>
     * @author 王俊涛
     * @version 2018.3
     */
    @GetMapping("list")
    @SuppressWarnings("unchecked")
    @ApiOperation(value = "获取指定用户日期的登录和学习数据")
    @ApiImplicitParams(value = {
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如15443", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "num", value = "1是登录时间，2是学习时间", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "week是一周，month是一月，year是一年", required = true, dataType = "string")
    })
    public Map<Object, Object> getTime(int uid, Integer num, String type) {
        //存放日期-时长,并进行日期排序
        Map<Object, Object> map = new TreeMap((Comparator<String>) (o1, o2) -> o2.compareTo(o1));
        List<Time> list = null;
        switch (num) {
            //获取指定登录日期数据
            case 1:
                switch (type) {
                    case "week":
                        list = timeService.queryOnList(uid);
                        break;
                    case "month":
                        list = timeService.queryOnMonthList(uid);
                        break;
                    case "year":
                        list = timeService.queryOnYearList(uid);
                        break;
                }

                break;
            //获取指定学习时间数据
            case 2:
                switch (type) {
                    case "week":
                        list = timeService.queryStudyList(uid);
                        break;
                    case "month":
                        list = timeService.queryStudyMonthList(uid);
                        break;
                    case "year":
                        list = timeService.queryStudyYearList(uid);
                        break;
                }

        }
        //获取过去各自的日期
        List<String> pastDate = null;
        switch (type) {
            case "week":
                pastDate = DateUtils.test(7);
                break;
            case "month":
                pastDate = DateUtils.getDateStr();
                break;
            case "year":
                pastDate = DateUtils.getYearStr();
                break;
        }

        DecimalFormat df = new DecimalFormat("######0.00");
        String timesStr;
        StringBuilder stringBuilder = new StringBuilder();
        //遍历日期
        assert pastDate != null;
        for (String past : pastDate) {
            assert list != null;
            for (Time time : list) {
                //把实际日期和登录的日期作对比，如果有实际的日期，设置该对象登录时间，如果没有日期，时间设为0
                if (type.equals("year")) {
                    if (past.equals(DateUtils.timeStampToDate(String.valueOf(time.getAddTime()), "yyyy-MM"))) {
                        Double times = Double.valueOf(time.getStudyTime()) / 3600.0;
                        timesStr = df.format(times);
                        stringBuilder.append("+").append(timesStr);
                        break;
                    } else {
                        stringBuilder.append("+0");
                    }

                } else {
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
            //年统计，把每月的数据相加
            if (type.equals("year")) {
                //计算总时间
                Object total = CountUtil.total(new String(stringBuilder));
                map.put(past, total);
            }


        }
        return map;
    }
}
