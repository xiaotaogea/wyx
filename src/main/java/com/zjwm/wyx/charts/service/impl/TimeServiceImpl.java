package com.zjwm.wyx.charts.service.impl;

import com.zjwm.wyx.charts.dao.TimeMapper;
import com.zjwm.wyx.charts.entity.Time;
import com.zjwm.wyx.charts.service.TimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("timeService")
public class TimeServiceImpl implements TimeService {
    @Autowired
    private TimeMapper timeMapper;

    @Override
    public List<Time> queryOnList(int uid) {
        return timeMapper.queryOnList(uid);
    }

    @Override
    public List<Time> queryStudyList(int uid) {
        return timeMapper.queryStudyList(uid);
    }

    @Override
    public List<Time> queryOnMonthList(int uid) {
        return timeMapper.queryOnMonthList(uid);
    }

    @Override
    public List<Time> queryStudyMonthList(int uid) {
        return timeMapper.queryStudyMonthList(uid);
    }

    @Override
    public List<Time> queryOnYearList(int uid) {
        return timeMapper.queryOnYearList(uid);
    }

    @Override
    public List<Time> queryStudyYearList(int uid) {
        return timeMapper.queryStudyYearList(uid);
    }
}
