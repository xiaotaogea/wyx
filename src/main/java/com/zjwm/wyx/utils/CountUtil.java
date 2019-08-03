/**
 * @Copyright: 2016-2019，中教网盟科技有限公司
 * @FileName: CountUtil
 * @Author: 王俊涛
 * @Date：2019/7/31 0031 10:04
 * @History: <author>     <time>      <version>       <desc>
 */
package com.zjwm.wyx.utils;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.util.Random;

/**
 * @version 2018.3
 * @Description: 计算和
 */
public class CountUtil {

    public static Object total(String str) {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("js");
        Object result = null;
        try {
            result = engine.eval(str);
        } catch (ScriptException e) {
            e.printStackTrace();
        }
        return result;
    }

    /**
     * 验证码:数字、大写字母、小写字母拆分来随机
     *
     * @return
     */
    public static String verifyCode() {
        Random random = new Random();
        String str = "";
        for (int i = 0; i < 6; i++) {
            int key = random.nextInt(3);
            switch (key) {
                case 0:
                    int code1 = random.nextInt(10);
                    str += code1;
                    break;
                case 1:
                    char code2 = (char) (random.nextInt(26) + 65);
                    str += code2;
                    break;
                case 2:
                    char code3 = (char) (random.nextInt(26) + 97);
                    str += code3;
                    break;
            }
        }
        return str;
    }


}
