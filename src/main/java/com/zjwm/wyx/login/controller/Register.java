package com.zjwm.wyx.login.controller;

import com.zjwm.wyx.login.entity.HbbUser;
import com.zjwm.wyx.login.service.RedisService;
import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.point.service.UserPointService;
import com.zjwm.wyx.utils.CountUtil;
import com.zjwm.wyx.utils.R;
import com.zjwm.wyx.utils.UUIDS;
import com.zjwm.wyx.utils.smsUtil.CHttpPost;
import com.zjwm.wyx.utils.smsUtil.ConfigManager;
import com.zjwm.wyx.utils.smsUtil.Message;
import com.zjwm.wyx.utils.smsUtil.MessageUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;

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
    private MessageUser messageUser;
    @Resource
    private UserPointService pointService;

    /**
     * 短信验证码发送
     */
    @GetMapping("/code")
    @ApiOperation(value = "手机发送验证码")
    @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string")
    public R code(String mobile) {

        // 用户账号
        String userid = messageUser.getMessageUserId();
        // 用户密码
        String pwd = messageUser.getMessageUserPwd();

        //主IP信息  必填
        String masterIpAddress = messageUser.getMasterIpAddress();
        //设置IP
        ConfigManager.setIpInfo(masterIpAddress, "", null, null);

        //密码是否加密   true：密码加密;false：密码不加密
//        ConfigManager.IS_ENCRYPT_PWD = true;
//        boolean isEncryptPwd = true;
        //验证码
        String phoneCode = CountUtil.verifyCode();
        // 单条发送
        singleSend(userid, pwd, phoneCode, mobile);
        // 验证码放redis设置储存时间五分钟
        redisService.setKey(mobile + "phoneCode", phoneCode);
        //返回验证
        return R.ok().put("data", phoneCode);
    }

    /**
     * @param userid 用户账号
     * @param pwd    用户密码
     * @description 单条发送
     */
    private static void singleSend(String userid, String pwd, String phoneCode, String mobile) {
        // 日期格式定义
        SimpleDateFormat sdf = new SimpleDateFormat("MMddHHmmss");
        try {
            // 参数类
            Message message = new Message();
            // 实例化短信处理对象
            CHttpPost cHttpPost = new CHttpPost();

            // 设置账号   将 userid转成大写,以防大小写不一致
            message.setUserid(userid.toUpperCase());

            //密码加密，则对密码进行加密

            // 设置时间戳
            String timestamp = sdf.format(Calendar.getInstance().getTime());
            message.setTimestamp(timestamp);

            // 对密码进行加密
            String encryptPwd = cHttpPost.encryptPwd(message.getUserid(), pwd, message.getTimestamp());
            // 设置加密后的密码
            message.setPwd(encryptPwd);


            // 设置手机号码 此处只能设置一个手机号码
            message.setMobile(mobile);
            // 设置内容
            message.setContent("您的验证码是" + phoneCode + "，在10分钟内输入有效。如非本人操作请忽略此短信。");
            // 设置扩展号
            message.setExno("11");
            // 用户自定义流水编号
            message.setCustid(UUIDS.getDateUUID());
            // 自定义扩展数据
            message.setExdata("abcdef");
            //业务类型
            message.setSvrtype("SMS001");

            // 返回的平台流水编号等信息
            StringBuffer msgId = new StringBuffer();
            // 返回值
            // 发送短信
            int result = cHttpPost.singleSend(message, msgId);
            // result为0:成功;非0:失败
            if (result == 0) {
                System.out.println("单条发送提交成功！");

                System.out.println(msgId.toString());

            } else {
                System.out.println("单条发送提交失败,错误码：" + result);
            }
        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
        }
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
        if (mobile == null) {
            return R.error("手机号不能为空");
        }
        if (password == null) {
            return R.error("密码不能为空");
        }
        if (code == null) {
            return R.error("验证码不能为空");
        }
//        if (!"/^1[3-9][0-9]\\d{8}$/".matches(mobile)){
//            return R.error("手机号格式不正确");
//        }

        // 验证输入验证码

        String phoneCode = redisService.getValue(mobile + "phoneCode");
        System.out.println(phoneCode);
        if (phoneCode != null && !phoneCode.equals(code)) {
            return R.error("验证码不正确");
        }
        HbbUser user = userService.queryByMobile(mobile);
        if (user != null) {
            return R.error("用户已存在");
        }
        HbbUser user1 = userService.queryByEmail(email);
        if (user1 != null) {
            return R.error("邮箱已存在");
        }

        if (password.length() < 6) {
            return R.error("密码不能少于6位");
        }
        //密码强度
        int streng;
        if ("/^[0-9]+$/".matches(password) || "/^[a-zA-Z]+$/".matches(password) && password.length() < 14) {
            streng = 1;
        } else if ("/^[0-9a-z]+$/".matches(password)) {
            streng = 2;
        } else if ("/^[0-9A-Z]+$/".matches(password) && (password.length() <= 10)) {
            streng = 2;
        } else {
            streng = 3;
        }
        HbbUser hbbUser = new HbbUser();
        hbbUser.setMobile(mobile);
        hbbUser.setWxUnionid(null);
        hbbUser.setUsername(null);
        hbbUser.setTruename(null);
        hbbUser.setNick(nick);
        hbbUser.setEmail(email);
        hbbUser.setStreng(streng);
        hbbUser.setPassword(password);
        hbbUser.setType(type);
        hbbUser.setPic(null);
        hbbUser.setFen("10");
        hbbUser.setMethod("页面注册");
        hbbUser.setCreateTime((int) (System.currentTimeMillis() / 1000));
        hbbUser.setUpdateTime((int) (System.currentTimeMillis() / 1000));
        userService.save(hbbUser);

        //加积分
        UserPoint userPoint = new UserPoint();

        userPoint.setUid(hbbUser.getId());
        userPoint.setMethod("注册奖励");
        userPoint.setType(0);
        userPoint.setContent("注册成功");
        userPoint.setFen("+10");
        userPoint.setAddTime((int) (System.currentTimeMillis() / 1000));
        pointService.insertUserPoint(userPoint);

        // 返回token
        return R.ok().put("data", phoneCode);
    }

}
