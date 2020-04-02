package com.carss.controller;

import com.carss.entity.Admininfo;
import com.carss.entity.UserinfoExample;
import com.carss.entity.UserinfoWithBLOBs;
import com.carss.service.AdminService;
import com.carss.service.UserinfoService;


import net.sf.json.JSONObject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

import java.util.Arrays;
import java.util.List;

/**
 * @Author: Yangxiaohui
 * @Date: 2019-09-03 22:35:02
 * @description
 */
@Controller
public class AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private UserinfoService userService;
    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    

    /**
     * 登录操作，判断登录的是用户还是管理员；
     * 登录是管理员则跳转到共享汽车后台管理系统，是用户的话则跳转到共享汽车用户首页；
     * @param account
     * @param password
     * @param request
     * @return
     */
    @RequestMapping("tologin")
    public String login(String account, String password, HttpServletRequest request) {
        Admininfo admin = adminService.findByAnameAndApass(account, password);
        logger.info("====admin===="+JSONObject.fromObject(admin).toString());
        logger.info("====admin is null===="+JSONObject.fromObject(admin).isEmpty());
        logger.info("====admin is NullObject===="+JSONObject.fromObject(admin).isNullObject());
        if(admin!=null) {
            request.getSession().setAttribute("currentUserName", admin.getAdminname());
            return "showCarinfo";
        }else{
        	logger.info("====finduser====");
            UserinfoExample ue = new UserinfoExample();
            ue.createCriteria().andUseraccountEqualTo(account).andPasswordEqualTo(password);
            List<UserinfoWithBLOBs> users = userService.findUserinfoByExample(ue);
            if (users.size() == 1) {
            	logger.info("====users===={}"+JSONObject.fromObject(users.get(0)).toString());
                request.getSession().setAttribute("currentUserName",users.get(0).getUseraccount());
                request.getSession().setAttribute("currentUser",users.get(0));
                String iconString =  Arrays.toString(users.get(0).getIcon());
                request.getSession().setAttribute("iconString",iconString);
                String licenceString =  Arrays.toString(users.get(0).getLicence());
                request.getSession().setAttribute("licenceString",licenceString);
                return "homepage";
            } else {
            	ue.clear();
            	ue.createCriteria().andPhoneEqualTo(account).andPasswordEqualTo(password);
            	List<UserinfoWithBLOBs> userList = userService.findUserinfoByExample(ue);
            	if(userList.size() > 0) {
            		logger.info("====users===={}"+JSONObject.fromObject(userList.get(0)).toString());
                    request.getSession().setAttribute("currentUserName",userList.get(0).getUseraccount());
                    request.getSession().setAttribute("currentUser",userList.get(0));
                    String iconString =  Arrays.toString(userList.get(0).getIcon());
                    request.getSession().setAttribute("iconString",iconString);
                    String licenceString =  Arrays.toString(userList.get(0).getLicence());
                    request.getSession().setAttribute("licenceString",licenceString);
                    return "homepage";
            	} else {
            		request.setAttribute("msg", "您输入的用户名密码有误，请重新登录");
                    return "login";
            	}
            }
        }
    }

    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        request.setAttribute("msg", "您已安全退出本系统！欢迎再次使用");
        return "login";
    }
}
