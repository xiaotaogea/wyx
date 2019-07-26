package com.zjwm.wyx.charts.service;

import com.zjwm.wyx.charts.entity.Time;

import java.util.List;

public interface TimeService {
    List<Time> queryOnList(int uid);
    List<Time> queryStudyList(int uid);

    List<Time> queryOnMonthList( int uid);
    List<Time> queryStudyMonthList( int uid);

    List<Time> queryOnYearList( int uid);
    List<Time> queryStudyYearList( int uid);
}
