package mapper.user;

import main.java.com.zjwm.wyx.user.entity.HbbStudent;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface HbbStudentMapper {
    int countByExample(HbbStudentExample example);

    int deleteByExample(HbbStudentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(HbbStudent record);

    int insertSelective(HbbStudent record);

    List<HbbStudent> selectByExample(HbbStudentExample example);

    HbbStudent selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") HbbStudent record, @Param("example") HbbStudentExample example);

    int updateByExample(@Param("record") HbbStudent record, @Param("example") HbbStudentExample example);

    int updateByPrimaryKeySelective(HbbStudent record);

    int updateByPrimaryKey(HbbStudent record);
}