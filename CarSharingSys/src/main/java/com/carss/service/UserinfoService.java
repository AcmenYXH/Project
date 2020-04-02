package com.carss.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.FileCopyUtils;

import com.carss.entity.Userinfo;
import com.carss.entity.UserinfoExample;
import com.carss.entity.UserinfoWithBLOBs;
import com.carss.mapper.UserinfoMapper;

import oracle.sql.BLOB;

/**
 * @Author: Yangxiaohui
 * @Date: 2019-09-04 16:10:34
 * @description 用户信息表对象的服务类，主要进行增删改查
 */
@Service
public class UserinfoService {
    @Autowired
    private UserinfoMapper userinfoMapper;

    /**
     * 添加用户
     * @param userinfo
     * @return
     */
    public boolean addUserinfo(UserinfoWithBLOBs userinfo) {
        return userinfoMapper.insertSelective(userinfo)>0;
    }

    /**
     * 批量删除用户
     * @param userinfos
     * @return
     */
    public boolean removeUserinfos(List<Integer> userids) {
        
        UserinfoExample ce = new UserinfoExample();
        ce.createCriteria().andUseridIn(userids);
        return userinfoMapper.deleteByExample(ce)==userids.size();
    }

    /**
     * 修改用户信息
     * @param userinfo
     * @return
     */
    public boolean editUserinfo(UserinfoWithBLOBs userinfo) {
        return userinfoMapper.updateByPrimaryKeySelective(userinfo)>0;
    }

    /**
     * 通过用户编号查找用户
     * @param userid
     * @return
     */
    public UserinfoWithBLOBs findUserinfoByUserid(int userid) {
        return userinfoMapper.selectByPrimaryKey(userid);
    }

    /**
     * 查找全部用户
     * @return
     */
    public List<UserinfoWithBLOBs> findAllUserinfo(){
        List<Userinfo> userinfos = userinfoMapper.selectByExample(null);
        List<UserinfoWithBLOBs> userinfoWithBLOBsList = new ArrayList<UserinfoWithBLOBs>();
        for (Userinfo u : userinfos){
            userinfoWithBLOBsList.add(userinfoMapper.selectByPrimaryKey(u.getUserid()));
        }
        return userinfoWithBLOBsList;
    }

    /**
     * 多条件组合查询用户信息
     * @param userinfoExample
     * @return
     */
    public List<UserinfoWithBLOBs> findUserinfoByExample(UserinfoExample userinfoExample){
//        List<Userinfo> userinfos = userinfoMapper.selectByExample(userinfoExample);
//        List<UserinfoWithBLOBs> userinfoWithBLOBsList = new ArrayList<UserinfoWithBLOBs>();
//        for (Userinfo u : userinfos){
//            userinfoWithBLOBsList.add(userinfoMapper.selectByPrimaryKey(u.getUserid()));
//        }
        return userinfoMapper.selectByExampleWithBLOBs(userinfoExample);
    }
}
