package com.carss.controller;


import javax.servlet.http.HttpServletRequest;

import com.carss.entity.*;
import com.carss.exception.WebException;
import com.carss.exception.enums.ErrorEnum;
import com.carss.service.DepositinfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carss.service.RentinfoService;
import com.carss.service.UserinfoService;

import java.util.Date;

@RestController
public class PaymentController {
	@Autowired
	private UserinfoService userinfoService;
	@Autowired
	private RentinfoService rentinfoService;
	@Autowired
	private DepositinfoService depositinfoService;


	/**
	 * 押金管理
	 * @param userid
	 * @param depositStatus
	 * @param request
	 * @return
	 */
	@PutMapping("editdeposit")
	public JsonResult editDeposit(int userid,String depositStatus,HttpServletRequest request) {
		if (depositStatus != null && !depositStatus.isEmpty()){
			UserinfoWithBLOBs userinfo = new UserinfoWithBLOBs();
			userinfo.setUserid(userid);
			if ( !"001".equals(depositStatus)){
				userinfo.setIsdeposit("未缴纳");
			}else{
				userinfo.setIsdeposit("已缴纳");
			}
			userinfoService.editUserinfo(userinfo);
			//修改押金信息
			Depositinfo depositinfo = new Depositinfo();
			depositinfo.setUserid(userid);
			depositinfo.setChangeTime(new Date());
			depositinfo.setDepositStatus(depositStatus);
			DepositinfoExample depositinfoExample = new DepositinfoExample();
			depositinfoExample.createCriteria().andUseridEqualTo(userid);
			depositinfoService.editDepositinfo(depositinfo,depositinfoExample);
			return new JsonResult("修改成功");
		}else {
			return new JsonResult(JsonResult.ERROR, "参数depositStatus不可为空");
		}


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
