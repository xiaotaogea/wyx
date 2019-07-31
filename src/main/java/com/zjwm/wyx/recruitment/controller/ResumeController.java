/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: ResumeController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.recruitment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.recruitment.entity.Employment;
import com.zjwm.wyx.recruitment.entity.Project;
import com.zjwm.wyx.recruitment.entity.Resume;
import com.zjwm.wyx.recruitment.service.ResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Description: 我的求职-简历管理：用户的简历列表，发布简历
 * version 2018.3
 */
@RestController
@RequestMapping("/resume")
@Api(description = "我的求职-简历管理")
public class ResumeController {
	
	@Resource
	private ResumeService resumeService;


	/**
	 *功能描述：查询用户的所有简历
	 *@author 王俊涛
	 *@version 2018.3
	 *@param uid 用户id
	 *@param currPage 当前页，默认是1
	 *@return com.github.pagehelper.PageInfo<com.zjwm.wyx.recruitment.entity.Resume>
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询用户的所有简历")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如889", required = true, dataType = "int"),
	})
	public PageInfo<Resume> list(int uid, Integer currPage) {
        currPage = currPage == null ? 1 : currPage;
		PageHelper.startPage(currPage, 10);
        //从session里獲得用户id
//        Integer uid = (Integer) request.getSession().getAttribute("userId");
		List<Resume> resumes = resumeService.queryList(uid);
		return new PageInfo<>(resumes);
		
	}
    /**
     * 简历信息
     */
    @GetMapping("/info")
	@ApiOperation(value = "根据简历id查询简历信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "id", value = "简历id，如12", required = true, dataType = "int"),
	})
    public Resume getInfo(Integer id){
        return resumeService.queryById(id);
    }
    /**
     * 删除简历
     */
    @GetMapping("/delete")
	@ApiOperation(value = "根据简历id删除简历")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "id", value = "简历id", required = true, dataType = "int"),
	})
    public void delete(Integer id){
        resumeService.delete(id);
    }
	/**
	 * 父职位
	 */
	@GetMapping("/pName")
	@ApiOperation(value = "查询一级职位列表")
	public List<String> getPName(){
		return resumeService.queryPName();
	}
	/**
	 * 子职位
	 */
	@GetMapping("/sName")
	@ApiOperation(value = "根据父级职位id查出子类职位列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "id", value = "父级id，如45查询二级职位分类，46查三级职位分类", required = true, dataType = "int"),
	})
	public List<String> getSName(Integer id){
		return resumeService.querySName(id);
	}
	/**
	 * 父地区
	 */
	@GetMapping("/pArea")
	@ApiOperation(value = "查询一级地区列表")
	public List<String> getPArea(){
		return resumeService.queryPArea();
	}
	/**
	 * 子地区
	 */
	@GetMapping("/sArea")
	@ApiOperation(value = "根据父级地区id查出子类地区列表")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "pid", value = "父级id,如1532", required = true, dataType = "int"),
	})
	public List<String> getSArea(Integer pid){
		return resumeService.querySArea(pid);
	}

	/**
	 *功能描述：发布简历，用事物同时添加到三张表里
	 *@author 王俊涛
	 *@version 2018.3
	 *@param uid 用户id
	 *@param resume 简历表实体对象
	 *@param employment 工作经验对象
	 *@param project 项目经验对象
	 *@return java.util.Map<java.lang.String,java.lang.String>
	 */
	@GetMapping("/create")
	@ApiOperation(value = "发布简历")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "resume", value = "简历表实体对象", required = true, dataType = "com.zjwm.wyx.recruitment.entity.Resume"),
			@ApiImplicitParam(paramType = "query", name = "employment", value = "工作经验对象", required = true, dataType = "com.zjwm.wyx.recruitment.entity.Employment"),
			@ApiImplicitParam(paramType = "query", name = "project", value = "项目经验对象", required = true, dataType = "com.zjwm.wyx.recruitment.entity.Project"),
	})
	public Map<String,String> createResume(int uid, Resume resume, Employment employment, Project project){
		Map<String,String> map = new HashMap<>();
		int count = resumeService.queryCountByUid(uid);
		if (count>5){
			map.put("msg","每个用户最多只能制作5份简历");
			return map;
		}
		String resumeName = resumeService.queryNameByUid(uid);
		if (resume.getResumeName().equals(resumeName)){
            map.put("msg","该简历名称已存在！");
            return map;
        }
        //创建简历对象

		resume.setCreateTime((int) (System.currentTimeMillis()/1000));
		resume.setUpdateTime((int) (System.currentTimeMillis()/1000));
        //创建工作经验对象
		employment.setResumeId(resume.getId());
		employment.setCreateTime((int) (System.currentTimeMillis()/1000));
		employment.setUpdateTime((int) (System.currentTimeMillis()/1000));
        //创建项目经验对象
		project.setResumeId(resume.getId());
		project.setCreateTime((int) (System.currentTimeMillis()/1000));
		project.setUpdateTime((int) (System.currentTimeMillis()/1000));

        int rest = resumeService.save(resume,employment,project);
        if (rest!=3){
            map.put("data","发布失败");
        }else {
            map.put("data","发布成功");
        }
		return map;
	}
	

}
