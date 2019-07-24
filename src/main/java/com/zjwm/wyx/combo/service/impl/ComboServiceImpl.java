package com.zjwm.wyx.combo.service.impl;

import com.zjwm.wyx.combo.dao.ComboMapper;
import com.zjwm.wyx.combo.entity.ComboCard;
import com.zjwm.wyx.combo.entity.ComboCardOrder;
import com.zjwm.wyx.combo.service.ComboService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("comboService")
public class ComboServiceImpl implements ComboService {
    @Autowired
    private ComboMapper comboMapper;


    @Override
    public ComboCard queryBycardNum(String cardNum) {
        return comboMapper.queryBycardNum(cardNum);
    }

    @Override
    public ComboCardOrder queryByUid(int uid) {
        return comboMapper.queryByUid(uid);
    }
}
