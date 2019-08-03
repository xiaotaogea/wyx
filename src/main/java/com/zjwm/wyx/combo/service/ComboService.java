package com.zjwm.wyx.combo.service;

import com.zjwm.wyx.combo.entity.ComboCard;
import com.zjwm.wyx.combo.entity.ComboCardOrder;

public interface ComboService {

    /**
     * @param cardNum 账号
     * @return 卡信息
     */
    ComboCard queryBycardNum(String cardNum);
    /**
     * 正在用
     * @param uid
     * @return 正在用的学习卡
     */
    ComboCardOrder queryByUid(int uid);
}
