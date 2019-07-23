package com.zjwm.wyx.recruitment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
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
	public PageInfo<Resume> list(HttpServletRequest request, Integer current) {
		current = current == null ? 1 : current;
		PageHelper.startPage(current, 10);
        //从session里獲得用户id
        Integer uid = (Integer) request.getSession().getAttribute("userId");
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
	 *
	 *  创建简历
	 */
	@RequestMapping("/create")
	public Map<String,String> createResume(HttpServletRequest request,Resume resume,Integer current){
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
		return map;
	}
	

}
