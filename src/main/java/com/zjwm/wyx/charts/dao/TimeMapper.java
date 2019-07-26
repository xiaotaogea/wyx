package com.zjwm.wyx.charts.dao;

import com.zjwm.wyx.charts.entity.Time;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface TimeMapper {

    List<Time> queryOnList(@Param("uid") int uid);
    List<Time> queryStudyList(@Param("uid") int uid);

    List<Time> queryOnMonthList(@Param("uid") int uid);
    List<Time> queryStudyMonthList(@Param("uid") int uid);

    List<Time> queryOnYearList(@Param("uid") int uid);
    List<Time> queryStudyYearList(@Param("uid") int uid);

}
