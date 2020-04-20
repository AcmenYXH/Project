package com.carss.controller;

import com.carss.entity.Rentinfo;
import com.carss.entity.RentinfoExample;
import com.carss.entity.RentinfoUpper;
import com.carss.entity.JsonResult;
import com.carss.exception.WebException;
import com.carss.exception.enums.ErrorEnum;
import com.carss.service.RentinfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

@RestController
public class RentinfoController {

	@Autowired
	private RentinfoService rentinfoService;

	/**
	 * 添加租赁信息
	 * @param rentinfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@PostMapping("restrentinfo")
	public JsonResult addRentinfo(@Valid @RequestBody Rentinfo rentinfo, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new WebException(ErrorEnum.CHECK_FAIL,result.getFieldError().getDefaultMessage());
		}
		rentinfoService.addRentinfo(rentinfo);
		return new JsonResult("添加成功");
	}

	/**
	 * 批量删除租赁信息
	 * @param rentinfoUppers
	 * @return
	 */
	@DeleteMapping("restrentinfo")
	public JsonResult removeRentinfo(@RequestBody List<Map<String,Object>> rentinfoUppers) {
		List<Integer> rentids = new ArrayList<Integer>();
		for(Map<String,Object> r : rentinfoUppers) {
			rentids.add((Integer)r.get("RENTID"));
		}
		rentinfoService.removeRentinfo(rentids);
		return new JsonResult("删除成功");
	}

	/**
	 * 修改租赁信息
	 * @param rentinfo
	 * @return
	 */
	@PutMapping("restrentinfo")
	public JsonResult editRentinfo(@RequestBody Rentinfo rentinfo) {
		rentinfoService.editRentinfo(rentinfo);
		return new JsonResult("修改成功");
	}

	/**
	 * 通过租赁编号获取租赁信息
	 * @param rentid
	 * @return
	 */
	@GetMapping("{rentid}/restrentinfo")
	public JsonResult<Map<String,Object>> getRentinfo(@PathVariable int rentid) {
		return new JsonResult<Map<String,Object>>(rentinfoService.findRentinfoByRentid(rentid));

	}

	/**
	 * 多组合查询租赁信息，返回分页信息
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @param rentid
	 * @param carid
	 * @return
	 */
	@GetMapping("restrentinfo")
	public JsonResult<Map<String,Object>> showPage(int pageSize,int pageNum,String sort,
			String order,Integer rentid,Integer carid){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		Rentinfo rentinfo = new Rentinfo();
//		if(rentid != null && carid != null){
//			rentinfo.setUserid(rentid);
//			rentinfo.setCarid(carid);
//		}else if(rentid != null){
//			rentinfo.setUserid(rentid);
//		}else if(carid != null){
//			rentinfo.setCarid(carid);
//		}
		rentinfo.setRentid(rentid);
		rentinfo.setCarid(carid);
		return new JsonResult<Map<String,Object>>(new PageInfo<Map<String,Object>>(rentinfoService.findRentinfoByRentinfo(rentinfo)));
	}
	
	/**
	 * 组合查询用户租赁信息，返回分页信息
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @param rentid
	 * @param carid
	 * @return
	 */
	@GetMapping("userrentinfo")
	public JsonResult<Map<String,Object>> showUserRentPage(int pageSize,int pageNum,String sort,
			String order,Integer userid,String tradeno,Integer carid){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		Rentinfo rentinfo = new Rentinfo();
		if(userid != null){
			rentinfo.setUserid(userid);
		}
		if(tradeno != null){
			rentinfo.setTradeNo(tradeno);
		}
		if(carid != null){
			rentinfo.setCarid(carid);
		}
		return new JsonResult<Map<String,Object>>(new PageInfo<Map<String,Object>>(rentinfoService.findRentinfoByRentinfo(rentinfo)));
	}
	
	/**
	 * 查询车辆的月销售额
	 * @return
	 */
	@GetMapping("selectMonthlyProfits")
	public JsonResult<Map<String,Object>> selectMonthlyProfits() {
		Calendar date = Calendar.getInstance();
        String year = String.valueOf(date.get(Calendar.YEAR));
		return new JsonResult<Map<String,Object>>(rentinfoService.selectMonthlyProfits("2019"));
	}
}
