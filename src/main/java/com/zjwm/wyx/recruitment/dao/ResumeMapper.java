package com.zjwm.wyx.recruitment.dao;

import com.zjwm.wyx.recruitment.entity.Resume;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ResumeMapper extends BaseDao<Resume> {
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
}