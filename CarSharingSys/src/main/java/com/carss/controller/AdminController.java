package com.carss.controller;

import com.carss.entity.*;
import com.carss.service.AdminService;
import com.carss.service.UserinfoService;


import com.carss.utils.IVerifyCodeGen;
import com.carss.utils.SimpleCharVerifyCodeGenImpl;
import net.sf.json.JSONObject;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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
    @Autowired
    private RedisTemplate redisTemplate;

    private static final Logger logger = LoggerFactory.getLogger(AdminController.class);
    /**
     * 验证码失效时间3分钟
     */
    private final int timeout = 3*60;


    /**
     * 登录操作，判断登录的是用户还是管理员；
     * 登录是管理员则跳转到共享汽车后台管理系统，是用户的话则跳转到共享汽车用户首页；
     *
     * @param account
     * @param password
     * @param request
     * @return
     */
    @PostMapping("tologin")
    @ResponseBody
    public JsonResult login(String account, String password,String verifyCode, HttpServletRequest request) {
        //验证码
        String captchaCode = "";
        logger.info("account:{},password:{},verifycode:{}",account,password,verifyCode);
        //获取验证码的key
        //String captchaKey = request.getSession().getAttribute("captchaKey").toString();
        String captchaKey = redisTemplate.opsForValue().get("captchaKey").toString();
        logger.info("======captchaKey:{}", captchaKey);

        if(!StringUtils.isEmpty(captchaKey)){
            if (redisTemplate.hasKey(captchaKey)){
                captchaCode = redisTemplate.opsForValue().get(captchaKey).toString();
                captchaCode = captchaCode.toLowerCase();
                if (captchaCode.equals(verifyCode.toLowerCase())){
                    return checkLogin(account,password,request);
                }else{
                    logger.info("======验证结果:验证码校验错误");
                    return new JsonResult(JsonResult.ERROR,"验证码错误");
                }
            }else{
                logger.info("======验证结果:验证码校验错误");
                return new JsonResult(JsonResult.ERROR,"验证码已过期");
            }
        }else{
            logger.info("======验证结果:请重新获取验证码");
            return new JsonResult(JsonResult.ERROR,"请重新获取验证码");
        }


    }

    public JsonResult checkLogin(String account, String password, HttpServletRequest request){
        Admininfo admin = adminService.findByAnameAndApass(account, password);
        logger.info("====admin===="+JSONObject.fromObject(admin).toString());
        if(admin!=null) {
            request.getSession().setAttribute("currentUserName", admin.getAdminname());
            return new JsonResult("showCarinfo");
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
                return new JsonResult("homepage");
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
                    return new JsonResult("homepage");
                } else {
//                    request.setAttribute("msg", "您输入的用户名密码有误，请重新登录");
                    return new JsonResult(JsonResult.ERROR,"用户名或密码错误！");
                }
            }
        }
    }

    /**
     * 安全退出
     *
     * @param request
     * @return
     */
    @RequestMapping("logout")
    public String logout(HttpServletRequest request) {
        request.getSession().invalidate();
        request.setAttribute("msg", "您已安全退出本系统！欢迎再次使用");
        return "login";
    }

    /**
     * 获取验证码
     *
     * @param request
     * @param response
     */
    @GetMapping("/verifyCode")
    public void verifyCode(HttpServletRequest request, HttpServletResponse response) {
        IVerifyCodeGen iVerifyCodeGen = new SimpleCharVerifyCodeGenImpl();
        try {
            //设置长宽
            VerifyCode verifyCode = iVerifyCodeGen.generate(80, 28);
            String code = verifyCode.getCode();
            String captchaKey = ((Long) System.currentTimeMillis()).toString();

            redisTemplate.opsForValue().set(captchaKey, code, timeout, TimeUnit.SECONDS);
            redisTemplate.opsForValue().set("captchaKey", captchaKey, timeout,TimeUnit.SECONDS);
            logger.info(code);
            //将VerifyCode绑定session
            request.getSession().setAttribute("captchaKey", captchaKey);
            logger.info("======captchaKey:{},code:{}", captchaKey,code);
            //设置响应头
            response.setHeader("Pragma", "no-cache");
            //设置响应头
            response.setHeader("Cache-Control", "no-cache");
            //在代理服务器端防止缓冲
            response.setDateHeader("Expires", 0);
            //设置响应内容类型
            response.setContentType("image/jpeg");
            response.getOutputStream().write(verifyCode.getImgBytes());
            response.getOutputStream().flush();
        } catch (IOException e) {
            logger.info("{}",e.getStackTrace());
        }
    }
}
