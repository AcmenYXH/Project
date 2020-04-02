package com.carss.mapper;

import com.carss.entity.Carinfo;
import com.carss.entity.CarinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarinfoMapper {
    int countByExample(CarinfoExample example);

    int deleteByExample(CarinfoExample example);

    int deleteByPrimaryKey(Integer carid);

    int insert(Carinfo record);

    int insertSelective(Carinfo record);

    List<Carinfo> selectByExample(CarinfoExample example);

    Carinfo selectByPrimaryKey(Integer carid);

    int updateByExampleSelective(@Param("record") Carinfo record, @Param("example") CarinfoExample example);

    int updateByExample(@Param("record") Carinfo record, @Param("example") CarinfoExample example);

    int updateByPrimaryKeySelective(Carinfo record);

    int updateByPrimaryKey(Carinfo record);
}