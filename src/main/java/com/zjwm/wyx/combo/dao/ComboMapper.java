package com.zjwm.wyx.combo.dao;

import com.zjwm.wyx.combo.entity.ComboCard;
import com.zjwm.wyx.combo.entity.ComboCardOrder;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ComboMapper {

    /**
     *
     * @param cardNum   账号
     * @return
     */
    ComboCard queryBycardNum(@Param("cardNum") String cardNum);

    /**
     * 正在用
     * @param uid
     * @return
     */
    ComboCardOrder queryByUid(@Param("uid")int uid);
}
