package com.carss.service;

import com.carss.entity.Rentinfo;
import com.carss.entity.RentinfoExample;
import com.carss.mapper.RentinfoMapper;
import com.carss.mapper.RentinfoRelationMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @Author: Yangxiaohui
 * @Date: 2019-09-04 16:10:34
 * @description 租赁信息表对象的服务类，主要进行增删改查
 */
@Service
public class RentinfoService {
    @Autowired
    private RentinfoMapper rentinfoMapper;
    @Autowired
    private RentinfoRelationMapper rentinfoRelationMapper;

    /**
     * 添加租赁
     * @param rentinfo
     * @return
     */
    public boolean addRentinfo(Rentinfo rentinfo) {
        return rentinfoMapper.insertSelective(rentinfo)>0;
    }

    /**
     * 批量删除租赁
     * @param rentinfos
     * @return
     */
    public boolean removeRentinfo(List<Integer> rentids) {
        RentinfoExample re = new RentinfoExample();
        re.createCriteria().andRentidIn(rentids);
        return rentinfoMapper.deleteByExample(re)==rentids.size();
    }

    /**
     * 修改车辆信息
     * @param rentinfo
     * @return
     */
    public boolean editRentinfo(Rentinfo rentinfo) {
        return rentinfoMapper.updateByPrimaryKeySelective(rentinfo)>0;
    }

    /**
     * 通过租赁编号查找租赁
     * @param rentid
     * @return
     */
    public List<Map<String,Object>> findRentinfoByRentid(int rentid) {
        return rentinfoRelationMapper.selectDetailByRentid(rentid);
    }

    /**
     * 查找全部租赁
     * @return
     */
    public List<Map<String,Object>> findAllRentinfo(){
        return rentinfoRelationMapper.selectAllRentinfo();
    }

    /**
     * 多条件组合查询租赁信息
     * @param reninfo
     * @return
     */
    public List<Map<String,Object>> findRentinfoByRentinfo(Rentinfo reninfo){
        return rentinfoRelationMapper.selectDetailByRentinfo(reninfo);
    }
    
    public List<Map<String,Object>> findRentinfoByExample(RentinfoExample rentinfoExample){
      List<Rentinfo> rentinfos = rentinfoMapper.selectByExample(rentinfoExample);
      List<Map<String,Object>> rentinfoList = new ArrayList<Map<String, Object>>();
      for(Rentinfo r : rentinfos){
          rentinfoList.add(rentinfoRelationMapper.selectDetailByRentid(r.getRentid()).get(0));
      }
      return rentinfoList;
  }
    
    /**
     * 按汽车品牌的查询汽车的盈利金额
     * @return
     */
    public List<Map<String,Object>> selectCarWithAmount(){
    	return rentinfoRelationMapper.selectCarWithAmount();
    }
    
    /**
     * 按共享汽车品牌查询汽车的使用次数
     * @return
     */
    public List<Map<String,Object>> selectCarWithUserNum(){
    	return rentinfoRelationMapper.selectCarWithUserNum();
    }
    
    /**
     * 按汽车编号的查询维修次数前20名的汽车
     * @return
     */
    public List<Map<String,Object>> selectCarWithRN(){
    	return rentinfoRelationMapper.selectCarWithRN();
    }
    
    public List<Map<String,Object>> selectMonthlyProfits(String year){
    	return rentinfoRelationMapper.selectMonthlyProfits(year);
    }
}
