package com.zjwm.wyx.login.controller;

import com.zjwm.wyx.login.entity.UserEntity;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.utils.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

/**
 * 
 * @ClassName:  Login   
 * @Description:登陆接口   
 * @author: Administrator
 * @date:   2019年6月10日 上午11:46:50   
 *     
 * @Copyright: 2019 www.zjwm.com Inc. All rights reserved. 
 *
 */
@Controller
@RequestMapping("/login")
public class Login {
	
	@Autowired
	private UserService userService;
	/**
	 * 
	 * @Title: pwd   
	 * @Description: 密码登陆   
	 * @param: @param mobile
	 * @param: @param pwd
	 * @param: @return  
	 * @author: Administrator 
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
