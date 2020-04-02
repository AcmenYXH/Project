package com.carss.mapper;

import com.carss.entity.Userinfo;
import com.carss.entity.UserinfoExample;
import com.carss.entity.UserinfoWithBLOBs;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserinfoMapper {
    int countByExample(UserinfoExample example);

    int deleteByExample(UserinfoExample example);

    int deleteByPrimaryKey(Integer userid);

    int insert(UserinfoWithBLOBs record);

    int insertSelective(UserinfoWithBLOBs record);

    List<UserinfoWithBLOBs> selectByExampleWithBLOBs(UserinfoExample example);

    List<Userinfo> selectByExample(UserinfoExample example);

    UserinfoWithBLOBs selectByPrimaryKey(Integer userid);

    int updateByExampleSelective(@Param("record") UserinfoWithBLOBs record, @Param("example") UserinfoExample example);

    int updateByExampleWithBLOBs(@Param("record") UserinfoWithBLOBs record, @Param("example") UserinfoExample example);

    int updateByExample(@Param("record") Userinfo record, @Param("example") UserinfoExample example);

    int updateByPrimaryKeySelective(UserinfoWithBLOBs record);

    int updateByPrimaryKeyWithBLOBs(UserinfoWithBLOBs record);

    int updateByPrimaryKey(Userinfo record);
}