/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: JobController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.recruitment.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.recruitment.entity.Job;
import com.zjwm.wyx.recruitment.entity.Welfare;
import com.zjwm.wyx.recruitment.service.JobService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Description: 我的求职-职位信息
 * version 2018.3
 */
@RestController
@RequestMapping("/job")
@Api(description = "我的求职-职位信息")

public class JobController {
    @Resource
    private JobService jobService;


    /**
     * 浏览列表
     */
    @GetMapping("/history")
    @ApiOperation(value = "查询用户浏览过的职位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如15443", required = true, dataType = "int"),
    })
    public PageInfo<Job> getHostory(int uid,Integer currPage) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 5);
        List<Job> jobs = jobService.queryHistory(uid);
        return new PageInfo<>(jobs);
    }
    /**
     * 收藏列表
     */
    @GetMapping("/collect")
    @ApiOperation(value = "查询用户收藏过的职位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如13932", required = true, dataType = "int"),
    })
    public PageInfo<Job> getCollect(int uid,Integer currPage) {
        currPage = currPage == null ? 1 : currPage;
        PageHelper.startPage(currPage, 5);
        List<Job> jobs = jobService.queryCollect(uid);
        return new PageInfo<>(jobs);
    }

    /**
     * 信息
     */
    @GetMapping("/info")
    @ApiOperation(value = "根据职位id查询信息")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "职位id,如20", required = true, dataType = "int"),
    })
    public Job info(Integer id) {
        Job job = jobService.queryObject(id);
        // 待遇
        String welfare = job.getWelfare();

        if (welfare != null) {
            String[] arr = welfare.split(",");
            List<Welfare> welfares = new ArrayList<>();
            for (String s : arr) {
                Welfare wel = jobService.queryWelfares(Integer.valueOf(s));
                welfares.add(wel);
            }
            job.setWelfares(welfares);
        }else {
            job.setWelfares(null);
        }
        return job;
    }

	/**
	 * 删除浏览
	 */
	@GetMapping("/delHistory")
    @ApiOperation(value = "删除用户浏览过的职位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "职位id", required = true, dataType = "int"),
    })
	public void deleteHis(Integer id) {
		jobService.deleteHistory(id);
	}
    /**
     * 删除收藏
     */
    @GetMapping("/delCollect")
    @ApiOperation(value = "删除用户收藏过的职位")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "id", value = "职位id", required = true, dataType = "int"),
    })
    public void deleteCol(Integer id) {
        jobService.deleteHistory(id);
    }

}
