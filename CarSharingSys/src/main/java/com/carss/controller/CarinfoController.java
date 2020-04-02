package com.carss.controller;

import java.util.List;

import javax.validation.Valid;

import com.carss.entity.Carinfo;
import com.carss.entity.CarinfoExample;
import com.carss.entity.JsonResult;
import com.carss.exception.WebException;
import com.carss.exception.enums.ErrorEnum;
import com.carss.service.CarinfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

@RestController
public class CarinfoController {
	//日志打印
	private static final Logger log = LoggerFactory.getLogger(CarinfoController.class);

	@Autowired
	private CarinfoService carinfoService;

	/**
	 * 添加车辆信息
	 * @param carinfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@PostMapping("restcarinfo")
	public JsonResult addCarinfo(@Valid @RequestBody Carinfo carinfo, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new WebException(ErrorEnum.CHECK_FAIL,result.getFieldError().getDefaultMessage());
		}
		carinfoService.addCarinfo(carinfo);
		return new JsonResult("添加成功");
	}

	/**
	 * 批量删除车辆信息
	 * @param carinfos
	 * @return
	 */
	@DeleteMapping("restcarinfo")
	public JsonResult removeCarinfo(@RequestBody List<Carinfo> carinfos) {
		log.info("carinfos"+JSONArray.fromObject(carinfos).toString());
		for(Carinfo carinfo:carinfos) {
			log.info("carinfos==status="+carinfo.getStatus());
			if("维修中".equals(carinfo.getStatus())) {
				return new JsonResult(JsonResult.ERROR,"删除失败，车辆在维修中！");
			}else if("正在使用".equals(carinfo.getStatus())) {
				return new JsonResult(JsonResult.ERROR,"删除失败，车辆正在使用！");
			}
		}
		carinfoService.removeCarinfo(carinfos);
		return new JsonResult("删除成功");
	}

	/**
	 * 修改车辆信息
	 * @param carinfo
	 * @return
	 */
	@PutMapping("restcarinfo")
	public JsonResult editCarinfo(@RequestBody Carinfo carinfo) {
		log.info("carinfos"+JSONObject.fromObject(carinfo).toString());
		if("维修中".equals(carinfo.getStatus())) {
			return new JsonResult(JsonResult.ERROR,"修改失败，车辆在维修中！");
		}else if("正在使用".equals(carinfo.getStatus())) {
			return new JsonResult(JsonResult.ERROR,"修改失败，车辆正在使用！");
		}
		carinfoService.editCarinfo(carinfo);
		return new JsonResult("修改成功");

	}

	/**
	 * 通过车辆编号获取车辆信息
	 * @param carid
	 * @return
	 */
	@GetMapping("{carid}/restcarinfo")
	public JsonResult<Carinfo> getCarinfo(@PathVariable(value="carid") int carid) {
		System.out.println("carid:"+carid);
		return new JsonResult<Carinfo>(carinfoService.findByCarid(carid));

	}

	/**
	 * 多组合查询车辆信息，返回分页信息
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @param brand
	 * @param minAmount
	 * @param maxAmount
	 * @return
	 */
	@GetMapping("restcarinfo")
	public JsonResult<Carinfo> showPage(int pageSize,int pageNum,String sort,
			String order,String brand,Double minAmount,Double maxAmount){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		CarinfoExample ge = new CarinfoExample();
//		System.out.println(minAmount+"  "+maxAmount);
		if(log.isDebugEnabled()) {
			log.debug(minAmount+"  "+maxAmount);
		}
		ge.createCriteria()
				.andBrandLike("%"+brand+"%")
				.andUnitpriceBetween(minAmount,maxAmount);
		return new JsonResult<Carinfo>(new PageInfo<Carinfo>(carinfoService.findByExample(ge)));
	}
	
	/**
	 * 查询所有车辆的信息
	 * @return
	 */
	@GetMapping("allCarinfo")
	public JsonResult<Carinfo> allCarinfo(){
		CarinfoExample ge = new CarinfoExample();
		return new JsonResult<Carinfo>(carinfoService.findByExample(ge));
	}
}
