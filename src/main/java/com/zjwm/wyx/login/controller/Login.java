package com.zjwm.wyx.login.controller;

import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.RedisService;
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
import org.springframework.web.bind.annotation.GetMapping;
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
@Api(description = "手机号登录，退出，找回密码")
public class Login {

    @Resource
    private UserService userService;
    @Resource
    private UserPointService pointService;
    @Resource
    private RedisService redisService;

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
            @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "pwd", value = "密码", required = true, dataType = "string"),
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
        boolean firstLogin = hbbUser.getLogintime() == null;
        if (firstLogin) {
            UserPoint userPoint = new UserPoint();
            userPoint.setUid(hbbUser.getId());
            userPoint.setMethod("首次登录");
            userPoint.setContent("首次登录奖励10分");
            userPoint.setFen("+10");
            userPoint.setAddTime((int) (System.currentTimeMillis() / 1000));
            userPoint.setType(0);
            pointService.insertUserPoint(userPoint);
            hbbUser.setFen("20");
            userService.update(hbbUser);
        }
        //更新最后登录时间
        hbbUser.setLogintime((int) (System.currentTimeMillis() / 1000));
        int res = userService.save(hbbUser);
        if (res == 1) {
            //		返回token user信息（用户名、用户头像、userId）
            //把用户id存到session里
            request.getSession().setAttribute("userId", hbbUser.getId());
            return R.ok().put("data", hbbUser);
        }
        return R.error("未知原因，登录失败");
    }

    @GetMapping("logout")
    @ApiOperation(value = "退出登录")
    public R logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        return R.ok();
    }

    @GetMapping("findPwd")
    @ApiOperation(value = "找回密码:手机号和邮箱，邮箱验证暂时没写")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "newPwd", value = "新密码", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "邮箱", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "code", value = "验证码", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "验证类型：1手机号，2：邮箱", required = true, dataType = "int")
    })
    public R findPwd(String mobile, String newPwd, String email, String code, Integer type) {
        if (newPwd.length() < 6) {
            return R.error("密码不能少于6位");
        }
        //密码强度
        int streng;
        if ("/^[0-9]+$/".matches(newPwd) || "/^[a-zA-Z]+$/".matches(newPwd) && newPwd.length() < 14) {
            streng = 1;
        } else if ("/^[0-9a-z]+$/".matches(newPwd) || "/^[0-9A-Z]+$/".matches(newPwd) && (newPwd.length() <= 10)) {
            streng = 2;
        } else {
            streng = 3;
        }

        HbbUser hbbUser = null;
        switch (type) {
            //手机验证
            case 1:
                if (mobile == null && code == null) {
                    return R.error("请填写完整信息");
                }
                hbbUser = userService.queryByMobile(mobile);
                if (hbbUser == null) {
                    return R.error("手机号不存在");
                }
                //发送验证码
                new Register().code(mobile);
                // 验证输入验证码
                //从redis取出验证
                String phoneCode = redisService.getValue(Register.KEY);
                if (phoneCode == null) {
                    return R.error("验证码已失效，请重新发送");
                }
                if (!phoneCode.equals(code)) {
                    return R.error("验证码不正确");
                }
                break;
            //邮箱验证
            case 2:
                if (email == null && code == null) {
                    return R.error("请填写完整信息");
                }
                hbbUser = userService.queryByEmail(email);
                if (hbbUser == null) {
                    return R.error("邮箱不存在");
                }
                break;
        }
        if (hbbUser != null) {
            hbbUser.setStreng(streng);
            hbbUser.setPassword(Md5Util.md5(Md5Util.md5("zjwam" + newPwd)));
            hbbUser.setUpdateTime((int) (System.currentTimeMillis() / 1000));
            userService.update(hbbUser);
            return R.ok();
        }
        return R.error("找回失败");
    }

    @GetMapping("updatePwd")
    @ApiOperation(value = "修改密码")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "uid", value = "用户id", required = true, dataType = "int"),
            @ApiImplicitParam(paramType = "query", name = "oldPwd", value = "老密码", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "newPwd", value = "新密码", required = true, dataType = "string"),
    })
    public R updatePwd(Integer uid,String oldPwd,String newPwd) {
        if (oldPwd==null && newPwd==null){
            return R.error("请填写完整信息");
        }
        HbbUser hbbUser = userService.queryObject(uid);
        if (!hbbUser.getPassword().equals(Md5Util.md5(Md5Util.md5("zjwam" + oldPwd)))){
            return R.error("密码不正确");
        }
        //修改密码
        hbbUser.setPassword(Md5Util.md5(Md5Util.md5("zjwam" + newPwd)));
        userService.update(hbbUser);
        return R.ok();
    }
}



