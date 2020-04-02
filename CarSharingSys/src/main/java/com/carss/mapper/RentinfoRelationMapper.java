package com.carss.mapper;

import java.util.List;
import java.util.Map;

import com.carss.entity.Rentinfo;

public interface RentinfoRelationMapper {
	
	/**
	 * 查找所有的租赁详情信息
	 * @return
	 */
    List<Map<String,Object>> selectAllRentinfo();

    /**
     * 通过rentid查找指定的租赁详情信息
     * @param rentid
     * @return
     */
    List<Map<String,Object>> selectDetailByRentid(int rentid);
    
    /**
     * 通过rentinfo查找指定的租赁详情信息
     * @param reninfo
     * @return
     */
    List<Map<String,Object>> selectDetailByRentinfo(Rentinfo reninfo);

    /**
     * 通过userid查找指定的租赁详情信息
     * @param userid
     * @return
     */
    List<Map<String,Object>> selectDetailByUserid(int userid);

    /**
     * 通过carid查找指定的租赁详情信息
     * @param carid
     * @return
     */
    List<Map<String,Object>> selectDetailByCarid(int carid);
    
    /**
     * 按汽车品牌的查询汽车的盈利金额
     * @return
     */
    List<Map<String,Object>> selectCarWithAmount();
    
    /**
     * 按共享汽车品牌查询汽车的使用次数
     * @return
     */
    List<Map<String,Object>> selectCarWithUserNum();
    
    /**
     * 按汽车编号的查询维修次数前20名的汽车
     * @return
     */
    List<Map<String,Object>> selectCarWithRN();
    
    /**
     * 查询车辆的月销售额
     * @return
     */
    List<Map<String,Object>> selectMonthlyProfits(String year);
    
}