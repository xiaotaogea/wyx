package com.zjwm.wyx.utils.smsUtil;

import com.zjwm.wyx.login.service.RedisService;
import com.zjwm.wyx.utils.CountUtil;
import com.zjwm.wyx.utils.UUIDS;

import javax.annotation.Resource;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @description: 发送短信工具类
 * @author: 王俊涛
 * @date: 2019/8/6 10:09
 */
public class SendSmsUtil {




    //把当前时间设置成key
    public static String KEY = UUIDS.getDateTime();

    /**
     *
     * @param mobile 手机号
     * @return 验证码
     */
    public static String getCode(String mobile) {

        // 用户账号
        String userid = MessageUser.messageUserId;
        // 用户密码
        String pwd = MessageUser.messageUserPwd;

        //主IP信息  必填
        String masterIpAddress = MessageUser.masterIpAddress;
        //设置IP
        ConfigManager.setIpInfo(masterIpAddress, "", null, null);

        //密码是否加密   true：密码加密;false：密码不加密
//        ConfigManager.IS_ENCRYPT_PWD = true;
//        boolean isEncryptPwd = true;
        //验证码
        String phoneCode = CountUtil.verifyCode();

        // 单条发送
        if (singleSend(userid, pwd, phoneCode, mobile)){
            //返回验证码
            return phoneCode;
        }
        return null;
    }

    /**
     * @param userid 用户账号
     * @param pwd    用户密码
     * @description 单条发送
     */
    private static boolean singleSend(String userid, String pwd, String phoneCode, String mobile) {
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

                return true;
            } else {
                System.out.println("单条发送提交失败,错误码：" + result);
            }
        } catch (Exception e) {
            //异常处理
            e.printStackTrace();
        }
        return false;
    }
}
