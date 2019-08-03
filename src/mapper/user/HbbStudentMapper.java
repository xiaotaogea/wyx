package mapper.user;

import java.util.List;
import main.java.com.zjwm.wyx.user.entity.HbbStudent;
import main.java.com.zjwm.wyx.user.entity.HbbStudentExample;
import org.apache.ibatis.annotations.Param;

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