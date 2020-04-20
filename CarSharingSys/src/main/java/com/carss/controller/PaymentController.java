package com.carss.controller;


import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carss.entity.JsonResult;
import com.carss.entity.Rentinfo;
import com.carss.entity.UserinfoWithBLOBs;
import com.carss.service.RentinfoService;
import com.carss.service.UserinfoService;

@RestController
public class PaymentController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private RentinfoService rentinfoService;


	/**
	 * 押金管理
	 * @param userid
	 * @param isdeposit
	 * @param request
	 * @return
	 */
	@PutMapping("editdeposit")
	public JsonResult editDeposit(int userid,String isdeposit,HttpServletRequest request) {
		UserinfoWithBLOBs userinfo = new UserinfoWithBLOBs();
		userinfo.setUserid(userid);
		userinfo.setIsdeposit(isdeposit);
		userinfoService.editUserinfo(userinfo);
		return new JsonResult("修改成功");

	}
	
	/**
	 * 模拟支付租金
	 * @param rentinfo
	 * @return
	 */
	@PutMapping("payrent")
	public JsonResult<String> PayRent(Rentinfo rentinfo) {
		rentinfoService.editRentinfo(rentinfo);
		return new JsonResult<>("修改成功");
	}
	
}
