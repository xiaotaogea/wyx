package com.zjwm.wyx.recruitment.dao;

import com.zjwm.wyx.recruitment.entity.Resume;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ResumeMapper extends BaseDao<Resume> {

//    Resume queryObject(@Param("id") int id);
    /**
     * 每个用户的简历数量
     * @param uid
     * @return
     */
    int queryCountByUid(int uid);
    /**
     * 检查名字是否重复
     * @param uid
     * @return
     */
    String queryNameByUid(int uid);

    /**
     * 父职位
     * @return
     */
    List<String> queryPName();
    /**
     * 子职位
     * @return
     */
    List<String> querySName(Integer id);


    /**
     * 父地区
     * @return
     */
    List<String> queryPArea();

    /**
     * 子地区
     * @param aid
     * @return
     */
    List<String> querySArea(Integer aid);
}