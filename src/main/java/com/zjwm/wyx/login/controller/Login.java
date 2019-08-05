package com.zjwm.wyx.login.controller;

import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.point.service.UserPointService;
import com.zjwm.wyx.utils.Md5Util;
import com.zjwm.wyx.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName: Login
 * @Description:登陆接口
 * @author: 王俊涛
 * @date: 2019/7/28 0028 15:54
 * @Copyright: 2019 www.zjwm.com Inc. All rights reserved.
 */
@Controller
@RequestMapping("/login")
@Api(description = "手机号登录")
public class Login {

    @Resource
    private UserService userService;
    @Resource
    private UserPointService pointService;

    /**
     * @Description: 密码登陆
     * @param: @param mobile 手机号
     * @param: @param pwd 密码
     * @param: @return  R
     * @author: 王俊涛
     * @date: 2019年6月10日 上午11:48:03
     * @return: R
     */
    @RequestMapping("/pwd")
    @ApiOperation(value = "登录验证，首次登录加积分")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query",name = "mobile",value = "手机号",required = true,dataType = "string"),
            @ApiImplicitParam(paramType = "query",name = "pwd",value = "密码",required = true,dataType = "string"),
    })
    public R pwd(@RequestParam String mobile, @RequestParam String pwd, HttpServletRequest request) {
        if (mobile == null) {
            return R.error("请输入账号");
        }
        if (pwd == null) {
            return R.error("请输入密码");
        }
        // 验证手机号和密码
        HbbUser hbbUser = userService.queryByMobile(mobile);
        if (hbbUser == null) {
            return R.error("账号不存在");
        }
        if (hbbUser.getPassword().equals(Md5Util.md5(Md5Util.md5("zjwam" + pwd)))) {
            return R.error("密码错误");
        }
        //根据最后登录时间判断是否是第一次登录，如果为null，就是第一次，加积分
        boolean firstLogin = hbbUser.getLogintime() == null ? true : false;
        if (firstLogin){
            UserPoint userPoint = new UserPoint();
            userPoint.setUid(hbbUser.getId());
            userPoint.setMethod("首次登录");
            userPoint.setContent("首次登录奖励10分");
            userPoint.setFen("+10");
            userPoint.setAddTime((int) (System.currentTimeMillis()/1000));
            userPoint.setType(0);
            pointService.insertUserPoint(userPoint);
            hbbUser.setFen("20");
            userService.updateFen(hbbUser);
        }
        //更新最后登录时间
        hbbUser.setLogintime((int) (System.currentTimeMillis()/1000));
        int res = userService.save(hbbUser);
        if (res==1){
            //		返回token user信息（用户名、用户头像、userId）
            //把用户id存到session里
            request.getSession().setAttribute("userId", hbbUser.getId());
            return R.ok().put("data", hbbUser);
        }
        return R.error("未知原因，登录失败");
    }


}
