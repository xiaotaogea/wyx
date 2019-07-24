package com.zjwm.wyx.combo.service;

import com.zjwm.wyx.combo.entity.ComboCard;
import com.zjwm.wyx.combo.entity.ComboCardOrder;

public interface ComboService {

    /**
     * @param cardNum 账号
     * @return
     */
    ComboCard queryBycardNum(String cardNum);
    /**
     * 正在用
     * @param uid
     * @return
     */
    ComboCardOrder queryByUid(int uid);
}
