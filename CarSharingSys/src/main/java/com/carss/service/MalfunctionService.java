package com.carss.service;

import com.carss.entity.Carinfo;
import com.carss.entity.Malfunction;
import com.carss.entity.MalfunctionExample;
import com.carss.mapper.CarinfoMapper;
import com.carss.mapper.MalfunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author: Yangxiaohui
 * @Date: 2019-09-04 16:10:34
 * @description 车辆故障信息表对象的服务类，主要进行增删改查
 */
@Service
public class MalfunctionService {
    @Autowired
    private MalfunctionMapper malfunctionMapper;
    @Autowired
    private CarinfoMapper carinfoMapper;

    /**
     * 添加车辆故障信息
     * @param malfunction
     * @return
     */
    public boolean addMalfunction(Malfunction malfunction) {
        return malfunctionMapper.insertSelective(malfunction)>0;
    }

    /**
     * 批量删除车辆故障信息
     * @param malfunctions
     * @return
     */
    public boolean removeMalfunction(List<Malfunction> malfunctions) {
        List<Integer> malids = new ArrayList<Integer>();
        for(Malfunction g : malfunctions) {
            malids.add(g.getMalid());
        }
        MalfunctionExample me = new MalfunctionExample();
        me.createCriteria().andMalidIn(malids);
        return malfunctionMapper.deleteByExample(me)==malids.size();
    }

    /**
     * 修改车辆故障信息信息
     * @param malfunction
     * @return
     */
    public boolean editMalfunction(Malfunction malfunction) {
    	//修改汽车的维修次数
    	Carinfo carinfo = carinfoMapper.selectByPrimaryKey(malfunction.getCarid());
    	carinfo.setRepairnum(carinfo.getRepairnum()+1);
    	carinfoMapper.updateByPrimaryKeySelective(carinfo);
    	malfunction.setProcesstime(new Date());
        return malfunctionMapper.updateByPrimaryKeySelective(malfunction)>0;
    }

    /**
     * 通过车辆故障信息编号查找车辆故障信息
     * @param malid
     * @return
     */
    public Malfunction findMalfunctionByMalid(int malid) {
        return malfunctionMapper.selectByPrimaryKey(malid);
    }

    /**
     * 查找全部车辆故障信息
     * @return
     */
    public List<Malfunction> findAllMalfunction(){
        return malfunctionMapper.selectByExample(null);
    }

    /**
     * 多条件组合查询车辆故障信息信息
     * @param malfunctionExample
     * @return
     */
    public List<Malfunction> findMalfunctionByExample(MalfunctionExample malfunctionExample){
        return malfunctionMapper.selectByExample(malfunctionExample);
    }
}
