package com.zjwm.wyx.recruitment.controller;

import com.zjwm.wyx.recruitment.entity.Job;
import com.zjwm.wyx.recruitment.entity.Welfare;
import com.zjwm.wyx.recruitment.service.JobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * 用户职位
 *
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@RestController
@RequestMapping("/job")
public class JobController {
    @Autowired
    private JobService jobService;


    /**
     * 浏览列表
     */
    @RequestMapping("/hostory")
    public List<Job> getHostory(int uid) {
        List<Job> jobs = jobService.queryHistory(uid);
        return jobs;
    }
    /**
     * 收藏列表
     */
    @RequestMapping("/collect")
    public List<Job> getCollect(int uid) {
        List<Job> jobs = jobService.queryHistory(uid);
        return jobs;
    }

    /**
     * 信息
     */
    @RequestMapping("/info")
    public Job info(Integer id) {
        Job job = jobService.queryObject(id);
        // 待遇
        String welfare = job.getWelfare();

        if (welfare != null) {
            String[] arr = welfare.split(",");
            List<Welfare> welfares = new ArrayList<>();
            for (int i = 0, len = arr.length; i < len; i++) {
                Welfare wel = jobService.queryWelfares(Integer.valueOf(arr[i]));
                welfares.add(wel);
            }
            job.setWelfares(welfares);
        }
        return job;
    }

	/**
	 * 删除浏览
	 */
	@RequestMapping("/delHistory")
	public void deleteHis(Integer id) {
		jobService.deleteHistory(id);
	}
    /**
     * 删除收藏
     */
    @RequestMapping("/delCollect")
    public void deleteCol(Integer id) {
        jobService.deleteHistory(id);
    }

}
