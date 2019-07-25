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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * 简历投递
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@RestController
@RequestMapping("/sendResume")
public class SendResumeController {

	@Autowired
	private SendResumeService sendResumeService;
	@Resource
	private JobService jobService;
	@Resource
	private ResumeService resumeService;

	/**
	 * 列表
	 */
	@RequestMapping("/list")
	public PageInfo<SendResume> list(Integer uid, Integer current, Integer type) {
		current = current == null ? 1 : current;
        type = type == null ? 1 : type;
		PageHelper.startPage(current, 10);
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
			// 简历名称
			String resumeName = re.getResumeName();
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
				for (int i = 0, len = arr.length; i < len; i++) {
					Welfare wel  = jobService.queryWelfares(Integer.valueOf(arr[i]));
					stringBuilder.append(wel.getName() + " ");
				}
				job.setWelfare(new String(stringBuilder));
			}
			sendResume.setWelfare(job.getWelfare());
		}
		PageInfo<SendResume> page = new PageInfo<>(list);
		return page;

	}

}
