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

}
