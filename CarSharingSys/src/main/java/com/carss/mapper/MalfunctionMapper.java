package com.carss.mapper;

import com.carss.entity.Malfunction;
import com.carss.entity.MalfunctionExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MalfunctionMapper {
    int countByExample(MalfunctionExample example);

    int deleteByExample(MalfunctionExample example);

    int deleteByPrimaryKey(Integer malid);

    int insert(Malfunction record);

    int insertSelective(Malfunction record);

    List<Malfunction> selectByExample(MalfunctionExample example);

    Malfunction selectByPrimaryKey(Integer malid);

    int updateByExampleSelective(@Param("record") Malfunction record, @Param("example") MalfunctionExample example);

    int updateByExample(@Param("record") Malfunction record, @Param("example") MalfunctionExample example);

    int updateByPrimaryKeySelective(Malfunction record);

    int updateByPrimaryKey(Malfunction record);
}