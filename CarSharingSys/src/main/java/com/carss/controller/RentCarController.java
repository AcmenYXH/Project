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

import net.sf.json.JSONObject;
import oracle.net.aso.l;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin
public class RentCarController {
	private static final Logger logger = LoggerFactory.getLogger(RentCarController.class);
	
	@Autowired
	private RentinfoService rentinfoService;
	@Autowired
	private CarinfoService carinfoService;

	/**
	 * 判断用户是否在用车，或者有订单未支付
	 * @param rentinfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@GetMapping("isreturn")
	public JsonResult isReturn(int userid,HttpServletRequest request){
		//查看当前用户是否在用车
		RentinfoExample re1 = new RentinfoExample();
		re1.createCriteria().andUseridEqualTo(userid).andIsplayEqualTo("未支付").andReturntimeIsNull();
		List<Map<String,Object>> rentinfoList1 = rentinfoService.findRentinfoByExample(re1);
		//查看当前用户是否有未支付的订单
		RentinfoExample re2 = new RentinfoExample();
		re2.createCriteria().andUseridEqualTo(userid).andIsplayEqualTo("未支付").andReturntimeIsNotNull();
		List<Map<String,Object>> rentinfoList2 = rentinfoService.findRentinfoByExample(re2);
		if(rentinfoList2.size()>0) {
			return new JsonResult("订单未支付");
		}else if(rentinfoList1.size()>0) {
			System.out.println(rentinfoList1.get(0).get("CARID"));
			Integer carid = Integer.parseInt(rentinfoList1.get(0).get("CARID").toString());
			Carinfo carinfo = carinfoService.findByCarid(carid);
			if(logger.isInfoEnabled()) {
				logger.info("RentCarController===isReturn==carinfo="+JSONObject.fromObject(carinfo).toString());
			}
			request.getSession().setAttribute("rentCar", carinfo);
			return new JsonResult<Carinfo>("用车",carinfo);
		}else {
			return new JsonResult("可以租车");
		}
	}

	/**
	 * 保存用户的位置信息
	 * @param userlng
	 * @param userlat
	 * @param request
	 * @return
	 */
	@PostMapping("savelocal")
	public JsonResult saveUserLocal(Double userlng,Double userlat,HttpServletRequest request) {
		System.out.println("userlng"+userlng);
		Map<String,Double> userLocal=new HashMap<String, Double>();
		userLocal.put("userlng", userlng);
		userLocal.put("userlat", userlat);
		request.getSession().setAttribute("userLocal", userLocal);
		return new JsonResult("保存成功");
	}

	/**
	 * 返回所有空闲状态的车辆信息（用于在租车页面展示出来）
	 * @param rentinfo
	 * @return
	 */
	@PostMapping("showCar")
	public JsonResult<Carinfo> showCarInMap(String state) {
		System.out.println("RentCarController====showCarInMap==state="+state);
		CarinfoExample carinfoExample = new CarinfoExample();
		if("空闲".equals(state)) {
			carinfoExample.createCriteria().andStatusEqualTo("空闲");
		}
		List<Carinfo> carinfoList = carinfoService.findByExample(carinfoExample);
		return new JsonResult<Carinfo>(carinfoList);

	}
	
	/**
	 * 添加用户租赁信息
	 * @param rentinfo
	 * @return
	 */
	@PostMapping("addUserRentinfo")
	public JsonResult showCarInMap(Rentinfo rentinfo,HttpServletRequest request) {
		System.out.println(rentinfo.getRentaltime());
		rentinfoService.addRentinfo(rentinfo);
		Carinfo rentCar = carinfoService.findByCarid(rentinfo.getCarid());
		request.getSession().setAttribute("rentCar", rentCar);
		return new JsonResult("添加成功");
	}
	
	/**
	 * 按汽车品牌的查询汽车的盈利金额
	 * @return
	 */
	@GetMapping("selectCarWithAmount")
	public JsonResult<Map<String,Object>> selectCarWithAmount(){
    	return new JsonResult<Map<String,Object>>(rentinfoService.selectCarWithAmount());
    }
	
	
	/**
	 * 按共享汽车品牌查询汽车的使用次数
	 * @return
	 */
	@GetMapping("selectCarWithUserNum")
	public JsonResult<Map<String,Object>> selectCarWithUserNum(){
    	return new JsonResult<Map<String,Object>>(rentinfoService.selectCarWithUserNum());
    }
	
	/**
	 * 按汽车编号的查询维修次数前20名的汽车
	 * @return
	 */
	@GetMapping("selectCarWithRN")
	public JsonResult<Map<String,Object>> selectCarWithRN(){
    	return new JsonResult<Map<String,Object>>(rentinfoService.selectCarWithRN());
    }
}
