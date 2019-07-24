package com.zjwm.wyx.bbs.dao;

import com.zjwm.wyx.bbs.entity.Bbs;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface BbsMapper extends BaseDao<Bbs> {
    /**
     * 参与
     * @param userId
     * @return
     */
    List<Bbs> queryReply(@Param("userId") int userId);

    /**
     *
     * @return 帖子的父种类
     */
    List<String> querycateParentName();


    /**
     * 帖子的子类
     * @param id
     * @return
     */
    List<String> querycateChildName(@Param("id") int id);

    /**
     * 标签
     * @return
     */
    List<String> queryLabs();
}
