package com.carss.controller;

import com.carss.entity.Malfunction;
import com.carss.entity.MalfunctionExample;
import com.carss.entity.JsonResult;
import com.carss.exception.WebException;
import com.carss.exception.enums.ErrorEnum;
import com.carss.service.MalfunctionService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class MalfunctionController {

	@Autowired
	private MalfunctionService malfunctionService;

	/**
	 * 添加车辆故障信息
	 * @param malfunction
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@PostMapping("restmalfunction")
	public JsonResult addMalfunction(@Valid @RequestBody Malfunction malfunction, BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new WebException(ErrorEnum.CHECK_FAIL,result.getFieldError().getDefaultMessage());
		}
		malfunctionService.addMalfunction(malfunction);
		return new JsonResult("添加成功");
	}

	/**
	 * 批量删除车辆故障信息
	 * @param malfunctions
	 * @return
	 */
	@DeleteMapping("restmalfunction")
	public JsonResult removeMalfunction(@RequestBody List<Malfunction> malfunctions) {
		malfunctionService.removeMalfunction(malfunctions);
		return new JsonResult("删除成功");
	}

	/**
	 * 修改车辆故障信息
	 * @param malfunction
	 * @return
	 */
	@PutMapping("restmalfunction")
	public JsonResult editMalfunction(@RequestBody Malfunction malfunction) {
		System.out.println(malfunction);
		malfunctionService.editMalfunction(malfunction);
		return new JsonResult("修改成功");

	}

	/**
	 * 通过车辆故障编号获取车辆故障信息
	 * @param malid
	 * @return
	 */
	@GetMapping("{malid}/restmalfunction")
	public JsonResult<Malfunction> getMalfunction(@PathVariable int malid) {
		return new JsonResult<Malfunction>(malfunctionService.findMalfunctionByMalid(malid));

	}

	/**
	 * 多组合查询车辆故障信息，返回分页信息
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @param userid
	 * @param carid
	 * @param repairstatus
	 * @return
	 */
	@GetMapping("restmalfunction")
	public JsonResult<Malfunction> showPage(int pageSize,int pageNum,String sort,
			String order,Integer carid,String repairstatus){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		MalfunctionExample ge = new MalfunctionExample();
		if(carid != null){
			ge.createCriteria()
					.andCaridEqualTo(carid)
					.andRepairstatusLike("%"+repairstatus+"%");
		}else {
			ge.createCriteria()
				.andRepairstatusLike("%"+repairstatus+"%");
		}
		return new JsonResult<Malfunction>(new PageInfo<Malfunction>(malfunctionService.findMalfunctionByExample(ge)));
	}
}
