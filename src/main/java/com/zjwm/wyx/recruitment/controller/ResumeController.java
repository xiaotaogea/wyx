package com.zjwm.wyx.recruitment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.recruitment.entity.Employment;
import com.zjwm.wyx.recruitment.entity.Project;
import com.zjwm.wyx.recruitment.entity.Resume;
import com.zjwm.wyx.recruitment.service.ResumeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 简历管理
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@RestController
@RequestMapping("/resume")
public class ResumeController {
	
	@Resource
	private ResumeService resumeService;


	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public PageInfo<Resume> list(int uid, Integer currPage) {
        currPage = currPage == null ? 1 : currPage;
		PageHelper.startPage(currPage, 10);
        //从session里獲得用户id
//        Integer uid = (Integer) request.getSession().getAttribute("userId");
		List<Resume> resumes = resumeService.queryList(uid);
		PageInfo<Resume> page = new PageInfo<>(resumes);
		return page;
		
	}
    /**
     * 简历信息
     */
    @RequestMapping("/info")
    public Resume getInfo(Integer id){
        return resumeService.queryById(id);
    }
    /**
     * 删除简历
     */
    @RequestMapping("/delete")
    public void delete(Integer id){
        resumeService.delete(id);
    }
	/**
	 * 父职位
	 */
	@RequestMapping("/pName")
	public List<String> getPName(){
		return resumeService.queryPName();
	}
	/**
	 * 子职位
	 */
	@RequestMapping("/sName")
	public List<String> getSName(Integer id){
		return resumeService.querySName(id);
	}
	/**
	 * 父地区
	 */
	@RequestMapping("/pArea")
	public List<String> getPArea(){
		return resumeService.queryPArea();
	}
	/**
	 * 子地区
	 */
	@RequestMapping("/sArea")
	public List<String> getSArea(Integer aid){
		return resumeService.querySArea(aid);
	}

	/**
	 *
	 *  发布简历
	 */
	@RequestMapping("/create")
	public Map<String,String> createResume(HttpServletRequest request, Resume resume, Employment employment, Project project,Integer current){
        //从session里獲得用户id
        Integer uid = (Integer) request.getSession().getAttribute("userId");
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
        Resume res = new Resume();
		res.setUserId(uid);
		res.setResumeName(resume.getResumeName());
		res.setUserName(resume.getUserName());
		res.setGender(resume.getGender());
		res.setPhone(resume.getPhone());
		res.setQq(resume.getQq());
		res.setEmail(resume.getEmail());
		res.setBirthday(resume.getBirthday());
		res.setWorkYear(resume.getWorkYear());
		res.setEducation(resume.getEducation());
		res.setAge(resume.getAge());
		res.setSkill(resume.getSkill());
		res.setIndustryId(resume.getIndustryId());
		res.setJobType(resume.getJobType());
		res.setExpectEmolumentLow(resume.getExpectEmolumentLow());
		res.setExpectEmolumentHigh(resume.getExpectEmolumentHigh());
		res.setHiredate(resume.getHiredate());
		res.setCreateTime((int) (System.currentTimeMillis()/1000));
		res.setUpdateTime((int) (System.currentTimeMillis()/1000));
        //创建工作经验对象
        Employment emp = new Employment();
        emp.setResumeId(res.getId());
        emp.setBeginTime(employment.getBeginTime());
        emp.setEndTime(employment.getEndTime());
        emp.setWorkCompany(employment.getWorkCompany());
        emp.setWorkJob(employment.getWorkJob());
        emp.setWorkEmolumentLow(employment.getWorkEmolumentLow());
        emp.setWorkEmolumentHigh(employment.getWorkEmolumentHigh());
        emp.setResponsibility(employment.getResponsibility());
        emp.setCreateTime((int) (System.currentTimeMillis()/1000));
        emp.setUpdateTime((int) (System.currentTimeMillis()/1000));
        //创建项目经验对象
        Project pro = new Project();
        pro.setResumeId(res.getId());
        pro.setBeginTime(project.getBeginTime());
        pro.setEndTime(project.getEndTime());
        pro.setProjectName(project.getProjectName());
        pro.setIntro(project.getIntro());
        pro.setResponsibility(project.getResponsibility());
        pro.setCreateTime((int) (System.currentTimeMillis()/1000));
        pro.setUpdateTime((int) (System.currentTimeMillis()/1000));

        int rest = resumeService.save(res,emp,pro);
        if (rest!=3){
            map.put("data","添加失败");
        }else {
            map.put("data","添加成功");
        }
		return map;
	}
	

}
