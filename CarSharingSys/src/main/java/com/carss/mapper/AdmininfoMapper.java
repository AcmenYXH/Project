package com.carss.mapper;

import com.carss.entity.Admininfo;
import com.carss.entity.AdmininfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdmininfoMapper {
    int countByExample(AdmininfoExample example);

    int deleteByExample(AdmininfoExample example);

    int deleteByPrimaryKey(Integer adminid);

    int insert(Admininfo record);

    int insertSelective(Admininfo record);

    List<Admininfo> selectByExample(AdmininfoExample example);

    Admininfo selectByPrimaryKey(Integer adminid);

    int updateByExampleSelective(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByExample(@Param("record") Admininfo record, @Param("example") AdmininfoExample example);

    int updateByPrimaryKeySelective(Admininfo record);

    int updateByPrimaryKey(Admininfo record);
}