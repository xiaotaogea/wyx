package com.zjwm.wyx.login.controller;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import com.zjwm.wyx.login.service.UserService;
import com.zjwm.wyx.utils.R;
import com.zjwm.wyx.utils.UUIDS;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.connection.jedis.JedisUtils;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.montnets.mwgate.common.GlobalParams;
import com.montnets.mwgate.common.Message;
import com.montnets.mwgate.smsutil.ConfigManager;
import com.montnets.mwgate.smsutil.SmsSendConn;

/**
 * @version 1.0
 * @author Administrator
 * 
 */
@Controller
@PropertySource("classpath:sendmessage.properties")
@RequestMapping("/rg")
public class Register {


	@Autowired
	@Qualifier("stringRedisTemplate")
	private RedisTemplate<String,String> rt;
	@Autowired
	@Qualifier("userService")
	private UserService userService;
	
	@Value("${message.userid}")
	private String userId;
	
	@Value("${message.pwd}")
	private String pwd;
	
	@Value("${message.ipAddress}")
	private String ipAddress;
	
	@Value("${message.path}")
	private String path;
	/**
	 *
	 * 短信验证码发送
	 */
	@RequestMapping("/code")
	public R code(@RequestParam String mobile) {
		// 短信平台-发送验证码
		
		// 用户账号
		String userid = userId;

		// 创建全局参数
		GlobalParams globalParams = new GlobalParams();
		// 设置请求路径
		globalParams.setRequestPath(path);
		// 设置是否需要日志 1:需要日志;0:不需要日志
		globalParams.setNeedLog(1);
		// 设置全局参数
		ConfigManager.setGlobalParams(globalParams);

		// 设置用户账号信息
		setAccountInfo();

		// 是否保持长连接
		boolean isKeepAlive = true;
		// 实例化短信处理对象
		SmsSendConn smsSendConn = new SmsSendConn(isKeepAlive);
		//验证码
		String phoneCode = verifyCode();
		// 单条发送
		singleSend(smsSendConn, userid,mobile,phoneCode);
		
		// 验证码放redis设置储存时间五分钟
//        ValueOperations forValue = rt.opsForValue();
//        forValue.set("phoneCode", phoneCode);
//        rt.expire(phoneCode, 60*1000*5, TimeUnit.MILLISECONDS);
		//返回验证
		return R.ok().put("data", phoneCode);
	}

	/**
	 * @description 设置用户账号信息
	 */
	public void setAccountInfo() {
		// 设置用户账号信息

		// 用户账号
		String userid = userId;
		// 密码
		String password = pwd;
		// 发送优先级
		int priority = 1;
		// 主IP信息
		String ipAddress1 = ipAddress;

		// 备用IP1信息
		String ipAddress2 = "";
		// 备用IP2信息
		String ipAddress3 = null;
		// 备用IP3信息
		String ipAddress4 = null;
		// 返回值
		int result = -310007;
		try {
			// 设置用户账号信息
			result = ConfigManager.setAccountInfo(userid, password, priority, ipAddress1, ipAddress2, ipAddress3,
					ipAddress4);
			// 判断返回结果，0设置成功，否则失败
			if (result == 0) {
				System.out.println("设置用户账号信息成功！");
			} else {
				System.out.println("设置用户账号信息失败，错误码：" + result);
			}
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
	}

	/**
	 * 
	 * @description 单条发送
	 * @param smsSendConn 短信处理对象,在这个方法中调用发送短信功能
	 * @param userid      用户账号
	 */
	public void singleSend(SmsSendConn smsSendConn, String userid,String mobile,String phoneCode) {
		try {
			// 参数类
			Message message = new Message();
			// 设置用户账号 指定用户账号发送，需要填写用户账号，不指定用户账号发送，无需填写用户账号
			message.setUserid(userid);
			// 设置手机号码 此处只能设置一个手机号码
			message.setMobile(mobile);
			// 设置内容
			message.setContent("您的验证码是:"+ phoneCode+",在2分钟内有效。如非本人操作请忽略本短信。");
			// 设置扩展号
			message.setExno("11");
			// 用户自定义流水编号
			message.setCustid(UUIDS.getDateTime());
			// 自定义扩展数据
			message.setExdata("abcdef");
			// 业务类型
			message.setSvrtype("SMS001");

			// 返回的流水号
			StringBuffer returnValue = new StringBuffer();
			// 返回值
			int result = -310099;
			// 发送短信
			result = smsSendConn.singleSend(message, returnValue);
			// result为0:成功
			if (result == 0) {
				System.out.println("单条发送提交成功！");
				System.out.println(returnValue.toString());
			}
			// result为非0：失败
			else {
				System.out.println("单条发送提交失败,错误码：" + result);
			}
		} catch (Exception e) {
			// 异常处理
			e.printStackTrace();
		}
	}
	/**
	 * 验证码:数字、大写字母、小写字母拆分来随机
	 * @return
	 */
	public String verifyCode() {
        Random random = new Random();
        String str = "";
       for (int i = 0; i < 6; i++){
           int key = random.nextInt(3);
           switch (key){
               case 0:
                   int code1 = random.nextInt(10);
                   str += code1;
                   break;
               case 1:
                   char code2 = (char)(random.nextInt(26)+65);
                   str += code2;
                   break;
               case 2:
                   char code3 = (char)(random.nextInt(26)+97);
                   str += code3;
                   break;
           }
       }
       return str;
   }


	/**
	 * 手机号注册
	 */
	@RequestMapping("/register")
	public R register(@RequestParam String mobile, @RequestParam String code, @RequestParam String pwd) {
		// 验证输入验证码
        ValueOperations<String, String> forValue = rt.opsForValue();
		String phoneCode = forValue.get("phoneCode");
		if(phoneCode.equals(code)) {
			// 注册存储注册信息
			userService.save(mobile, pwd);
		}
		
		// 返回token
		return R.ok().put("data", phoneCode);
	}

	/**
	 * 修改手机号
	 */
//	@RequestMapping("/newmobile")
//	public R newmobile(@RequestParam String mobile, @RequestParam String code, @RequestParam String newmobile) {
//		// 验证输入验证码
//		UserEntity userEntity = userService.queryByMobile(mobile);
//		if(userEntity!=null) {
//			code(mobile);
//		}
//		String phoneCode = JedisUtils.get("phoneCode");
//		if(phoneCode.equals(code)) {
//			// 注册存储注册信息
//			userEntity.setMobile(newmobile);
//			userService.update(userEntity);
//		}
//		// 返回token
//		return R.ok().put("data", userEntity);
//	}

}
