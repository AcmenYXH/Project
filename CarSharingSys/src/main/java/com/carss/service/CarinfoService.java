package com.carss.service;

import com.carss.entity.Carinfo;
import com.carss.entity.CarinfoExample;
import com.carss.mapper.CarinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;

/**
 * @Author: Yangxiaohui
 * @Date: 2019-09-04 16:10:34
 * @description 车辆信息表对象的服务类，主要进行增删改查
 */
@Service
public class CarinfoService {
    @Autowired
    private CarinfoMapper carinfoMapper;

    /**
     * 添加车辆
     * @param carinfo
     * @return
     */
    public boolean addCarinfo(Carinfo carinfo) {
        return carinfoMapper.insertSelective(carinfo)>0;
    }

    /**
     * 批量删除车辆
     * @param carinfos
     * @return
     */
    public boolean removeCarinfo(List<Carinfo> carinfos) {
        List<Integer> carids = new ArrayList<Integer>();
        for(Carinfo g : carinfos) {
            carids.add(g.getCarid());
        }
        CarinfoExample ce = new CarinfoExample();
        ce.createCriteria().andCaridIn(carids);
        return carinfoMapper.deleteByExample(ce)==carids.size();
    }

    /**
     * 修改车辆信息
     * @param carinfo
     * @return
     */
    public boolean editCarinfo(Carinfo carinfo) {
        return carinfoMapper.updateByPrimaryKeySelective(carinfo)>0;
    }

    /**
     * 通过车辆编号查找车辆
     * @param carid
     * @return
     */
    public Carinfo findByCarid(int carid) {
        return carinfoMapper.selectByPrimaryKey(carid);
    }

    /**
     * 查找全部车辆
     * @return
     */
    public List<Carinfo> findAll(){
        return carinfoMapper.selectByExample(null);
    }

    /**
     * 多条件组合查询车辆信息
     * @param carinfoExample
     * @return
     */
    public List<Carinfo> findByExample(CarinfoExample carinfoExample){
        return carinfoMapper.selectByExample(carinfoExample);
    }
}
