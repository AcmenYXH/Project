package com.carss.mapper;

import com.carss.entity.Depositinfo;
import com.carss.entity.DepositinfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface DepositinfoMapper {
    long countByExample(DepositinfoExample example);

    int deleteByExample(DepositinfoExample example);

    int insert(Depositinfo record);

    int insertSelective(Depositinfo record);

    List<Depositinfo> selectByExample(DepositinfoExample example);

    int updateByExampleSelective(@Param("record") Depositinfo record, @Param("example") DepositinfoExample example);

    int updateByExample(@Param("record") Depositinfo record, @Param("example") DepositinfoExample example);
}