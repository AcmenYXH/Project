package com.carss.service;

import com.carss.entity.Depositinfo;
import com.carss.entity.DepositinfoExample;
import com.carss.mapper.DepositinfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: yangxh8
 * @Date: 2020-04-24 16:07:19
 * @Description:
 */
@Service
public class DepositinfoService {
    @Autowired
    private DepositinfoMapper depositinfoMapper;

    /**
     * 选择性插入押金信息
     * @param depositinfo
     * @return
     */
    public boolean addDepositinfo(Depositinfo depositinfo){
        return depositinfoMapper.insertSelective(depositinfo)>0;
    }

    /**
     * 多条件删除押金信息
     * @param depositinfoExample
     * @return
     */
    public boolean removeDepositinfo(DepositinfoExample depositinfoExample){
        return depositinfoMapper.deleteByExample(depositinfoExample)>0;
    }

    /**
     * 多条件修改押金信息
     * @param depositinfo
     * @param depositinfoExample
     * @return
     */
    public boolean editDepositinfo(Depositinfo depositinfo,DepositinfoExample depositinfoExample){
        return depositinfoMapper.updateByExampleSelective(depositinfo,depositinfoExample)>0;
    }

    /**
     * 多条件查询押金信息
     * @param depositinfoExample
     * @return
     */
    public List<Depositinfo> getDepositinfo(DepositinfoExample depositinfoExample){
        return depositinfoMapper.selectByExample(depositinfoExample);
    }
}
