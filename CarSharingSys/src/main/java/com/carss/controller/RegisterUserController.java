package com.carss.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carss.entity.JsonResult;
import com.carss.entity.Userinfo;
import com.carss.entity.UserinfoExample;
import com.carss.entity.UserinfoWithBLOBs;
import com.carss.service.UserinfoService;

@RestController
public class RegisterUserController {
	 @Autowired
	 private UserinfoService userinfoService;
	 
	 /**
	  * 验证用户的账号唯一性
	  * @param useraccount
	  * @return
	  */
	 @GetMapping("checkaccount")
	 public JsonResult<Boolean> uniqueUserAccount(String useraccount) {
		//判断用户名是否存在
		UserinfoExample ge = new UserinfoExample();
		ge.createCriteria().andUseraccountEqualTo(useraccount);
		List<UserinfoWithBLOBs> users = userinfoService.findUserinfoByExample(ge);
		if(users.size() != 0) {
			return new JsonResult<Boolean>(false);
		}
		return new JsonResult<Boolean>(true);
	 }
	 
	 /**
	  * 检验注册的手机是否已经注册过
	  * @param phone
	  * @return
	  */
	 @GetMapping("checkphone")
	 public JsonResult<Boolean> uniquePhone(String phone){
		 System.out.println("手机"+phone);
		UserinfoExample ge = new UserinfoExample();
		ge.createCriteria().andPhoneEqualTo(phone);
		List<UserinfoWithBLOBs> users = userinfoService.findUserinfoByExample(ge);
		System.out.println("大小："+users.size());
		if(users.size() != 0) {
			return new JsonResult<Boolean>(false);
		}
		return new JsonResult<Boolean>(true);
	 }
}
