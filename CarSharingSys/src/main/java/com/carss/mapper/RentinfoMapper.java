package com.carss.mapper;

import com.carss.entity.Rentinfo;
import com.carss.entity.RentinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;


public interface RentinfoMapper {
    long countByExample(RentinfoExample example);

    int deleteByExample(RentinfoExample example);

    int deleteByPrimaryKey(Integer rentid);

    int insert(Rentinfo record);

    int insertSelective(Rentinfo record);

    List<Rentinfo> selectByExample(RentinfoExample example);

    Rentinfo selectByPrimaryKey(Integer rentid);

    int updateByExampleSelective(@Param("record") Rentinfo record, @Param("example") RentinfoExample example);

    int updateByExample(@Param("record") Rentinfo record, @Param("example") RentinfoExample example);

    int updateByPrimaryKeySelective(Rentinfo record);

    int updateByPrimaryKey(Rentinfo record);
}