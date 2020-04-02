package com.carss.controller;

import com.carss.entity.Rentinfo;
import com.carss.entity.RentinfoExample;
import com.carss.entity.Carinfo;
import com.carss.entity.CarinfoExample;
import com.carss.entity.JsonResult;
import com.carss.exception.WebException;
import com.carss.exception.enums.ErrorEnum;
import com.carss.service.CarinfoService;
import com.carss.service.RentinfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ReturnCarController {

	@Autowired
	private RentinfoService rentinfoService;
	@Autowired
	private CarinfoService carinfoService;

	/**
	 * 获取用户的租赁信息
	 * @param userid
	 * @param request
	 * @return
	 */
	@GetMapping("getuserrentinfo")
	public JsonResult<Map<String,Object>> getUserRentinfo(int userid){
		RentinfoExample re = new RentinfoExample();
		re.createCriteria().andUseridEqualTo(userid).andIsplayEqualTo("未支付");
		List<Map<String,Object>> rentinfoList = rentinfoService.findRentinfoByExample(re);
		
		if(rentinfoList.size() == 0|| rentinfoList == null) {
			Map<String,Object> rentinfo = new HashMap<String,Object>();
			rentinfo.put("result", "false");
			return new JsonResult<>(rentinfo);
		}else {
			Map<String,Object> rentinfo = rentinfoList.get(0);
			rentinfo.put("result", "true");
			return new JsonResult<Map<String,Object>>(rentinfo);
		}
	}

	@PutMapping("edituserrentinfo")
	public JsonResult editUserRentinfo(Rentinfo rentinfo){
		rentinfoService.editRentinfo(rentinfo);
		Carinfo carinfo = new Carinfo();
		carinfo.setCarid(rentinfo.getCarid());
		carinfo.setStatus("空闲");
		carinfoService.editCarinfo(carinfo);
		return new JsonResult("成功完善");
	}
	
}
