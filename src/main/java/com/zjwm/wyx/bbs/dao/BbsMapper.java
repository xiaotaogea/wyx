package com.zjwm.wyx.bbs.dao;

import com.zjwm.wyx.bbs.entity.Bbs;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface BbsMapper extends BaseDao<Bbs> {
    /**
     * 参与
     * @param userId 用户id
     * @return 参与列表
     */
    List<Bbs> queryReply(@Param("userId") int userId);

    /**
     * @return 帖子的父种类
     */
    List<String> querycateParentName();


    /**
     * @param id 父种类id
     * @return 帖子的子类
     */
    List<String> querycateChildName(@Param("id") int id);

    /**
     * @return 标签列表
     */
    List<String> queryLabs();
}
