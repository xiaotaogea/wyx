package com.zjwm.wyx.point.dao;

import com.zjwm.wyx.point.entity.UserPoint;
import com.zjwm.wyx.utils.BaseDao;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;


/**
 * 用户积分
 * 
 * @author czx
 * @email object_czx@163.com
 * @date 2017-10-23 21:23:54
 */
@Mapper
public interface UserPointMapper extends BaseDao<UserPoint> {

	List<UserPoint> queryByUid(@Param("uid") int uid);
	List<UserPoint> queryPointList(@Param("uid") int uid,@Param("fen") String fen);

}
