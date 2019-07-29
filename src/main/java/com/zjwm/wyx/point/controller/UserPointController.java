/*
  Copyright: 2016-2019，中教网盟科技有限公司
  FileName: UserPointController
  Author: 王俊涛
  Date：2019/7/28 0028 15:54
  History:
  <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.point.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.point.entity.UserSign;
import com.zjwm.wyx.point.service.UserPointService;
import com.zjwm.wyx.point.service.UserSignService;
import com.zjwm.wyx.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Description: 用户积分列表，签到
 * version 2018.3
 */
@RestController
@RequestMapping("point")
@Api(description = "我的积分")
public class UserPointController {
	@Resource
	private UserSignService userSignService;
	@Resource
	private UserPointService userPointService;

	/**
	 *功能描述：根据用户id获得所有积分信息
	 *@author 王俊涛
	 *@version 2018.3
	 *@param uid 用户id
	 *@param currPage 当前页，默认是1
	 *@return com.github.pagehelper.PageInfo<com.zjwm.wyx.point.entity.UserPoint>
	 */
	@GetMapping("list")
	@ApiOperation(value = "根据用户id获得所有积分信息")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "currPage", value = "当前页，默认是1", required = true, dataType = "int"),
			@ApiImplicitParam(paramType = "query", name = "uid", value = "用户id,如15443", required = true, dataType = "int")
	})
	public PageInfo<UserPoint> getList(int uid,Integer currPage) {
		currPage = (currPage == null) ? 1 : currPage;
		PageHelper.startPage(currPage, 14);
		List<UserPoint> pointList = userPointService.queryByUid(uid);
		for (UserPoint userPoint : pointList) {
			long addTime = userPoint.getAddTime();
			String f = DateUtils.timeStampToDate(String.valueOf(addTime), "yyyy-MM-dd HH:mm");
			userPoint.setDateTime(f);
		}
		return new PageInfo<>(pointList);
	}

	/**
	 *功能描述：根据用户id操作签过流程
	 *@author 王俊涛
	 *@version 2018.3
	 *@param uid 用户id
	 *@return java.util.Map<java.lang.String,java.lang.String>
	 */
	@GetMapping("/sign")
	@ApiOperation(value = "根据用户id操作签过流程")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int")
	})
	public Map<String, String> sign(int uid) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Map<String, String> map = new HashMap<>();
		// 上次签到的时间
		int addTime = userPointService.queryByUid(uid).get(0).getAddTime();
		// 签到时间
		int nowTime = (int) (System.currentTimeMillis() / 1000);
		if (signToday(addTime, nowTime)) {
			map.put("data", "今天已签过到");
			return map;
		} else {
			// 积分表
			UserPoint userPoint = new UserPoint();
			userPoint.setUid(uid);
			userPoint.setMethod("每日签到");
			userPoint.setType(0);

			userPoint.setAddTime(nowTime);

			// 判断是否上次签到是昨天

			String d = DateUtils.timeStampToDate(String.valueOf(addTime), "yyyy-MM-dd");

			int t = 0;
			try {
				t = (int) (sdf.parse(d).getTime() / 1000);
			} catch (ParseException e) {
				e.printStackTrace();
			}

			boolean isYesterday = compareOneAndYesterday(t);

			// 先判断签到表中是否存在该对象
			UserSign us = userSignService.queryByUid(uid);
			// 如果不存在，先创建一个,第一次签到
			if (us == null) {
				// 存入签到表
				UserSign userSign = new UserSign();
				userSign.setUid(uid);
				userSign.setTimes(1);
				userSign.setAddTime(nowTime);
				userSignService.save(userSign);
				// 存入积分表
				userPoint.setContent("签到成功");
				userPoint.setFen("+3");
				userPointService.insertUserPoint(userPoint);

			} else {
				us.setAddTime(nowTime);
				// 如果存在，改变签到次数
				int times = us.getTimes();
				times = isYesterday ? (times + 1) : 1;
				us.setTimes(times);
				userSignService.update(us);
				// 连续签到1-4天
				if (times < 5) {
					// 存入积分表
					userPoint.setContent("签到成功");
					userPoint.setFen("+3");
					userPointService.insertUserPoint(userPoint);
				} else if (times == 5) {
					// 连续签到5天，奖励10分
					userPoint.setContent("签到成功");
					userPoint.setFen("+3");
					userPointService.insertUserPoint(userPoint);
					userPoint.setContent("连续签到5天");
					userPoint.setFen("+10");
					userPointService.insertUserPoint(userPoint);
				} else if (times <= 30) {
					// 连续签到6-30天，每年积分+5
					userPoint.setContent("签到成功");
					userPoint.setFen("+5");
					userPointService.insertUserPoint(userPoint);
					// 连续签到10天，15分奖励
					if (times == 10) {
						userPoint.setContent("连续签到10天");
						userPoint.setFen("+15");
						userPointService.insertUserPoint(userPoint);
					} else if (times == 20) {
						userPoint.setContent("连续签到20天");
						userPoint.setFen("+20");
						userPointService.insertUserPoint(userPoint);
					} else if (times == 30) {
						userPoint.setContent("连续签到30天");
						userPoint.setFen("+30");
						userPointService.insertUserPoint(userPoint);
					}
				} else {
					userPoint.setContent("签到成功");
					userPoint.setFen("+8");
					userPointService.insertUserPoint(userPoint);
				}
			}

			map.put("data", "签到成功");
		}

		return map;

	}

	/**
	 * 判断是否是昨天
	 * @param oneTime 要判断的时间
	 * @return boolean
	 */
	private static boolean compareOneAndYesterday(int oneTime) {

		// 获得昨天的值
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.DAY_OF_MONTH, -1);

		String twoTime = sdf.format(calendar.getTime());
		int d = 0;
		try {
			d = (int) (sdf.parse(twoTime).getTime() / 1000);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		// 比较
		return oneTime == d;
	}


	/**
	 * 判段今天是否签到
	 * @param yesterday 昨天的时间
	 * @param today 今天的时间
	 * @return boolean
	 */
	private boolean signToday(int yesterday, int today) {
		String yesStr = DateUtils.timeStampToDate(String.valueOf(yesterday), "yyyy-MM-dd");
		String todayStr = DateUtils.timeStampToDate(String.valueOf(today), "yyyy-MM-dd");
		return yesStr.equals(todayStr);
	}

}
