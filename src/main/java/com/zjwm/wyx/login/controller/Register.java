package com.zjwm.wyx.login.controller;

import com.zjwm.wyx.login.service.UserService;
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
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @description:
 * @author: 王俊涛
 * @date: 2019/8/3 11:09
 */
@RestController
@RequestMapping("/rg")
@Api(description = "手机号注册，发送验证码")
public class Register {
    @Resource
    private StringRedisTemplate stringRedisTemplate;
    @Resource
    private UserService userService;
    @Resource
    private MessageUser messageUser;
    /**
     * 短信验证码发送
     */
    @RequestMapping("/code")
    @ApiOperation(value = "手机发送验证码")
    @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string")
    public R code(String mobile) {

        // 用户账号
        String userid = messageUser.getMessageUserId();
        // 用户密码
        String pwd = messageUser.getMessageUserPwd();

        //主IP信息  必填
        String masterIpAddress = messageUser.getMasterIpAddress();
        //备IP1  选填
        String ipAddress1 = "";
        //备IP2  选填
        String ipAddress2 = null;
        //备IP3  选填
        String ipAddress3 = null;
        //设置IP
        ConfigManager.setIpInfo(masterIpAddress, ipAddress1, ipAddress2, ipAddress3);

        //密码是否加密   true：密码加密;false：密码不加密
        ConfigManager.IS_ENCRYPT_PWD = true;
        boolean isEncryptPwd = ConfigManager.IS_ENCRYPT_PWD;
        //验证码
        String phoneCode = CountUtil.verifyCode();
        // 单条发送
        singleSend(userid, pwd, isEncryptPwd,phoneCode,mobile);
        // 验证码放redis设置储存时间五分钟
        stringRedisTemplate.opsForValue().set(mobile+"phoneCode", phoneCode, 60*60*5);
        //返回验证
        return R.ok().put("data", phoneCode);
    }

    /**
     *
     * @description  单条发送
     * @param userid  用户账号
     * @param pwd 用户密码
     * @param isEncryptPwd 密码是否加密   true：密码加密;false：密码不加密
     */
    public static void singleSend(String userid, String pwd,boolean isEncryptPwd,String phoneCode,String mobile)
    {
        // 日期格式定义
        SimpleDateFormat sdf	= new SimpleDateFormat("MMddHHmmss");
        try
        {
            // 参数类
            Message message = new Message();
            // 实例化短信处理对象
            CHttpPost cHttpPost = new CHttpPost();

            // 设置账号   将 userid转成大写,以防大小写不一致
            message.setUserid(userid.toUpperCase());

            //判断密码是否加密。
            //密码加密，则对密码进行加密
            if(isEncryptPwd)
            {
                // 设置时间戳
                String timestamp = sdf.format(Calendar.getInstance().getTime());
                message.setTimestamp(timestamp);

                // 对密码进行加密
                String encryptPwd = cHttpPost.encryptPwd(message.getUserid(),pwd, message.getTimestamp());
                // 设置加密后的密码
                message.setPwd(encryptPwd);

            }else
            {
                // 设置密码
                message.setPwd(pwd);
            }

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
            int result = -310099;
            // 发送短信
            result = cHttpPost.singleSend(message, msgId);
            // result为0:成功;非0:失败
            if(result == 0)
            {
                System.out.println("单条发送提交成功！");

                System.out.println(msgId.toString());

            }
            else
            {
                System.out.println("单条发送提交失败,错误码：" + result);
            }
        }
        catch (Exception e)
        {
            //异常处理
            e.printStackTrace();
        }
    }
    /**
     * 手机号注册
     */
    @RequestMapping("/register")
    @ApiOperation(value = "手机号注册")
    @ApiImplicitParams({
            @ApiImplicitParam(paramType = "query", name = "mobile", value = "手机号", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "code", value = "验证码", required = true, dataType = "string"),
            @ApiImplicitParam(paramType = "query", name = "pwd", value = "密码", required = true, dataType = "string")
    })
    public R register(@RequestParam String mobile, @RequestParam String code, @RequestParam String pwd) {
        // 验证输入验证码
        String phoneCode = stringRedisTemplate.opsForValue().get(mobile+"phoneCode");
        if(phoneCode !=null && phoneCode.equals(code)) {
            // 注册存储注册信息
            userService.save(mobile, pwd);
        }

        // 返回token
        return R.ok().put("data", phoneCode);
    }

}
