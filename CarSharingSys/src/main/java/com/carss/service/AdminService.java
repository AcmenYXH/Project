package com.carss.service;

import com.carss.entity.Admininfo;
import com.carss.entity.AdmininfoExample;
import com.carss.mapper.AdmininfoMapper;

import net.sf.json.JSONArray;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: Yangxiaohui
 * @Date: 2019-09-03 21:19:48
 * @description
 */
@Service
public class AdminService {

    @Autowired
    private AdmininfoMapper admininfoMapper;
    
    private static final Logger logger = LoggerFactory.getLogger(AdminService.class);

    /**
     * 通过账号和密码匹配管理员
     * @param aname
     * @param password
     * @return
     */
    public Admininfo findByAnameAndApass(String aname, String password) {
        AdmininfoExample ae = new AdmininfoExample();
        ae.createCriteria().andAdminnameEqualTo(aname).andAdminpsdEqualTo(password);
        List<Admininfo> admins = admininfoMapper.selectByExample(ae);
        logger.info("====admins===="+JSONArray.fromObject(admins).toString());
        if(admins.size()>0) {
            return admins.get(0);
        }else {
            return null;
        }
    }
}
