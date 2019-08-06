package com.zjwm.wyx.login.controller;

import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.RedisService;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.point.service.UserPointService;
import com.zjwm.wyx.utils.Md5Util;
import com.zjwm.wyx.utils.R;
import com.zjwm.wyx.utils.smsUtil.SendSmsUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.regex.Pattern;

/**
 * @description: 手机号注册，发送验证码
 * @author: 王俊涛
 * @date: 2019/8/3 11:09
 */
@RestController
@RequestMapping("/rg")
@Api(description = "手机号注册，发送验证码")
public class Register {
    @Resource
    private RedisService redisService;
    @Resource
    private UserService userService;

    @Resource
    private UserPointService pointService;


    /**
     * 短信验证码发送
     */
    @GetMapping("/code")
    @ApiOperation(value = "手机发送验证码")
    @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string")
    public R code(String mobile) {
        String phoneCode = SendSmsUtil.getCode(mobile);
        // 放redis设置储存时间五分钟
        redisService.setKey(SendSmsUtil.KEY, phoneCode);
        //返回验证
        return R.ok().put("data", phoneCode);
    }


    /**
     * 手机号注册
     */
    @GetMapping("/register")
    @ApiOperation(value = "手机号注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "nick", value = "昵称", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "password", value = "密码", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "email", value = "邮箱", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "code", value = "验证码", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "type", value = "注册类型：0学生，1教师，2企业", required = true, dataType = "int")
    })
    public R register(String nick, String mobile, String password, String email, String code, Integer type) {


        if (mobile == null)
            return R.error("手机号不能为空");

        if (password == null)
            return R.error("密码不能为空");

        if (code == null)
            return R.error("验证码不能为空");

        if (!Pattern.compile("^((13[0-9])|(14[5,7,9])|(15([0-3]|[5-9]))|(166)|(17[0,1,3,5,6,7,8])|(18[0-9])|(19[8|9]))\\d{8}$").matcher(mobile).matches())
            return R.error("手机号格式不正确");

        HbbUser mobileUser = userService.queryByMobile(mobile);
        if (mobileUser != null)
            return R.error("用户已存在");

        HbbUser emailUser = userService.queryByEmail(email);
        if (emailUser != null)
            return R.error("邮箱已存在");


        if (password.length() < 6)
            return R.error("密码不能少于6位");

        // 验证输入验证码
        //从redis取出验证
        String phoneCode = redisService.getValue(SendSmsUtil.KEY);
        if (phoneCode == null)
            return R.error("验证码已失效，请重新发送");

        if (!phoneCode.equals(code))
            return R.error("验证码不正确");


        /*
          密码强度判断
          1：差 ，小于8位全是数字或者字母
          2：中，小于8位且包含小写字母或者大写字母
          3：强，大于14位，或者大于8位包含大写跟小写字母
         */
        int streng;
        if (Pattern.compile("^[0-9]+$").matcher(password).matches() || Pattern.compile("^[a-zA-Z]+$").matcher(password).matches() && password.length() < 8) {
            streng = 1;
        } else if (Pattern.compile("^[0-9a-z]+$").matcher(password).matches() || Pattern.compile("^[0-9A-Z]+$").matcher(password).matches() && (password.length() <= 8)) {
            streng = 2;
        } else {
            streng = 3;
        }
        HbbUser hbbUser = new HbbUser();
        hbbUser.setMobile(mobile);
        hbbUser.setWxUnionid("");
        hbbUser.setUsername("");
        hbbUser.setTruename("");
        hbbUser.setNick(nick);
        hbbUser.setEmail(email);
        hbbUser.setStreng(streng);
        hbbUser.setPassword(Md5Util.md5(Md5Util.md5("zjwam" + password)));
        hbbUser.setType(type);
        hbbUser.setPic("");
        hbbUser.setFen("10");
        hbbUser.setMethod("页面注册");
        hbbUser.setCreateTime((int) (System.currentTimeMillis() / 1000));
        hbbUser.setUpdateTime((int) (System.currentTimeMillis() / 1000));
        int res1 = userService.save(hbbUser);

        //加积分
        UserPoint userPoint = new UserPoint();

        userPoint.setUid(hbbUser.getId());
        userPoint.setMethod("注册奖励");
        userPoint.setType(0);
        userPoint.setContent("注册成功");
        userPoint.setFen("+10");
        userPoint.setAddTime((int) (System.currentTimeMillis() / 1000));
        int res2 = pointService.insertUserPoint(userPoint);

        if (res1 + res2 == 2)
            return R.ok().put("data", hbbUser);

        return R.error("未知原因，注册失败");

    }

}
