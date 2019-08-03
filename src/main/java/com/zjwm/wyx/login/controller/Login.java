package com.zjwm.wyx.login.controller;

import com.zjwm.wyx.login.entity.UserEntity;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.utils.R;
import io.swagger.annotations.Api;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName:  Login   
 * @Description:登陆接口   
 * @author: 王俊涛
 * @date:   2019/7/28 0028 15:54
 *     
 * @Copyright: 2019 www.zjwm.com Inc. All rights reserved. 
 *
 */
@Controller
@RequestMapping("/login")
@Api(description = "登录：加密方式未知，暂停服务")
public class Login {
	
	@Resource
	private UserService userService;
	/**
	 * 
	 * @Description: 密码登陆
	 * @param: @param mobile 手机号
	 * @param: @param pwd 密码
	 * @param: @return  R
	 * @author: 王俊涛
	 * @date:   2019年6月10日 上午11:48:03      
	 * @return: R      
	 * 
	 */
	@RequestMapping("/pwd")
	public R pwd(@RequestParam String mobile, @RequestParam String pwd, HttpServletRequest request) {
        System.err.println(mobile+" "+pwd);
		// 验证手机号和密码
		int userid = userService.login(mobile, pwd);
//		返回token user信息（用户名、用户头像、userId）
		UserEntity userEntity = userService.queryObject(userid);
		//把用户id存到session里
		request.getSession().setAttribute("userId",userid);
		return R.ok().put("data", userEntity);
	}


}
