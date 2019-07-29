/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: SendResumeController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.recruitment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.recruitment.entity.Job;
import com.zjwm.wyx.recruitment.entity.Resume;
import com.zjwm.wyx.recruitment.entity.SendResume;
import com.zjwm.wyx.recruitment.entity.Welfare;
import com.zjwm.wyx.recruitment.service.JobService;
import com.zjwm.wyx.recruitment.service.ResumeService;
import com.zjwm.wyx.recruitment.service.SendResumeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Description: 我的求职-投递记录
 * version 2018.3
 */
@RestController
@RequestMapping("/sendResume")
@Api(description = "我的求职-投递记录")
public class SendResumeController {

	@Resource
	private SendResumeService sendResumeService;
	@Resource
	private JobService jobService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 列表
	 */
	@GetMapping("/list")
	@ApiOperation(value = "查询所有投递的记录")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如13932", required = true, dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "type", value = "1:全部，2:已查看,3:约面试,4:拒绝 默认1", dataType = "int"),
	})
	public PageInfo<SendResume> list(Integer uid, Integer currPage, Integer type) {
        currPage = currPage == null ? 1 : currPage;
        type = type == null ? 1 : type;
		PageHelper.startPage(currPage, 10);
		List<SendResume> list = null;
		switch (type) {
		case 1:
			// 全部投递记录
			list = sendResumeService.queryList(uid);
			break;
		case 2:
			// 已查看
			list = sendResumeService.querySeeList(uid);
			break;
		case 3:
			// 约面试
			list = sendResumeService.queryYesList(uid);
			break;
		case 4:
			// 拒绝
			list = sendResumeService.queryNoList(uid);
			break;
		}
		if (list == null){
			return null;
		}
		//得到每条记录的具体信息
		for (SendResume sendResume : list) {
			// 公司id
			int companyId = sendResume.getCompanyId();
			// 公司名称
			String companyName = jobService.queryCompanyName(companyId);
			sendResume.setCompanyName(companyName);
			// 简历id
			int resumeId = sendResume.getResumeId();

            Resume re = resumeService.queryById(resumeId);
			String resumeName;
            if (re==null){
            	resumeName = "简历已删除";
			}else {
				// 简历名称
				resumeName = re.getResumeName();
			}
			sendResume.setResumeName(resumeName);
			// 职位id
			int jobId = sendResume.getJobId();
			// 职位名称
			Job job = jobService.queryObject(jobId);
			sendResume.setJobName(job.getJobName());
			// 待遇
			String welfare = job.getWelfare();

			if (welfare != null) {
				String[] arr = welfare.split(",");
				StringBuilder stringBuilder = new StringBuilder();
				for (String s : arr) {
					Welfare wel = jobService.queryWelfares(Integer.valueOf(s));
					stringBuilder.append(wel.getName()).append(" ");
				}
				job.setWelfare(new String(stringBuilder));
			}
			sendResume.setWelfare(job.getWelfare());
		}
		return new PageInfo<>(list);

	}

}
