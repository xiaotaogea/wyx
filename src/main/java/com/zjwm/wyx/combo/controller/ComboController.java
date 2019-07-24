package com.zjwm.wyx.combo.controller;

import com.zjwm.wyx.combo.entity.ComboCard;
import com.zjwm.wyx.combo.entity.ComboCardOrder;
import com.zjwm.wyx.combo.service.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 学习卡
 *
 * @author Administrator
 */

@RestController
@RequestMapping("/combo")
public class ComboController {

    @Autowired
    private ComboService comboService;

    /**
     * 卡片信息
     * @param cardNum
     * @param cardPwd
     * @return
     */
    @RequestMapping("info")
    public Map<String,String> getInfo(int uid,String cardNum, String cardPwd){
        Map<String,String> map = new HashMap<>();
        // 1.接收卡片账号密码，并判断是否正确
        ComboCard comboCard = comboService.queryBycardNum(cardNum);
        if (comboCard==null){
            map.put("data","卡号不存在");
            return map;
        }
       if (!comboCard.getCardPwd().equals(cardPwd)){
           map.put("data","密码不正确");
           return map;
       }
        if (comboCard.getStatus()==1){
            map.put("data","这张学习卡已经被激活过了，请不要重复激活");
            return map;
        }
        // 2.验证登录账号是否有正在使用的学习卡
        ComboCardOrder comboCardOrder = comboService.queryByUid(uid);
        if (comboCardOrder!=null){
            map.put("data","您的学习卡未到期");
            return map;
        }

        return map;
    }



}
