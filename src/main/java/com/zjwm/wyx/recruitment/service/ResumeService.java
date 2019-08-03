package com.zjwm.wyx.recruitment.service;

import com.zjwm.wyx.recruitment.entity.Employment;
import com.zjwm.wyx.recruitment.entity.Project;
import com.zjwm.wyx.recruitment.entity.Resume;

import java.util.List;

/**
 * 用户
 *
 * @author Andy
 * @email andyeasons@163.com
 * @date 2017-10-23 21:23:54
 */
public interface ResumeService {

    Resume queryById(int id);

    /**
     * 父职位
     */
    List<String> queryPName();

    /**
     * 子职位
     */
    List<String> querySName(Integer id);

    /**
     * 父地区
     */
    List<String> queryPArea();

    /**
     * 子地区
     */
    List<String> querySArea(Integer pid);

    /**
     * 用户简历列表
     */

    List<Resume> queryList(int userId);

    /**
     * 每个用户的简历数量
     */
    int queryCountByUid(int uid);

    /**
     * 检查名字是否重复
     */
    String queryNameByUid(int uid);

    /**
     * 保存  同时三张表
     */
    int save(Resume resume, Employment employment, Project project);

    /**
     * 删除
     */

    int delete(int id);


}
