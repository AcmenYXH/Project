package com.carss.controller;

import com.carss.entity.JsonResult;
import com.carss.entity.RentinfoExample;
import com.carss.entity.Userinfo;
import com.carss.entity.UserinfoExample;
import com.carss.entity.UserinfoWithBLOBs;
import com.carss.exception.WebException;
import com.carss.exception.enums.ErrorEnum;
import com.carss.service.RentinfoService;
import com.carss.service.UserinfoService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

@RestController
public class UserinfoController {

	//日志打印
	private static final Logger log = LoggerFactory.getLogger(UserinfoController.class);
	
	@Autowired
	private UserinfoService userinfoService;
	
	@Autowired
	private RentinfoService rentinfoService;

	/**
	 * 添加用户信息
	 * @param userinfo
	 * @param result
	 * @return
	 * @throws Exception
	 */
	@PostMapping("restuserinfo")
	public JsonResult addUserinfo(Userinfo user,@RequestParam("icon1") MultipartFile icon,@RequestParam("licence1") MultipartFile licence,BindingResult result) throws Exception {
		if(result.hasErrors()) {
			throw new WebException(ErrorEnum.CHECK_FAIL,result.getFieldError().getDefaultMessage());
		}
		UserinfoWithBLOBs userinfo = new UserinfoWithBLOBs();
		//使用BeanUtils工具将user对象的属性copy到userinfo对象上
		BeanUtils.copyProperties(user, userinfo);
		if(log.isInfoEnabled()) {log.info("addUserinfo===userinfo="+JSONObject.fromObject(userinfo).toString());}
		try {
			if(!icon.isEmpty()) {
				InputStream iconis = icon.getInputStream();
				byte[] iconbuffer=new byte[2048];
				int len1=0;
				ByteArrayOutputStream bos1=new ByteArrayOutputStream();
				while((len1=iconis.read(iconbuffer))!=-1){
					bos1.write(iconbuffer,0,len1);
				}
				bos1.flush();
				byte icondata[] = bos1.toByteArray();
				userinfo.setIcon(icondata);
			}
			if(!licence.isEmpty()) {
				InputStream licenceis = licence.getInputStream();
				byte[] licencebuffer=new byte[2048];
				int len2=0;
				ByteArrayOutputStream bos2=new ByteArrayOutputStream();
				while((len2=licenceis.read(licencebuffer))!=-1){
					bos2.write(licencebuffer,0,len2);
				}
				bos2.flush();
				byte licencedata[] = bos2.toByteArray();
				userinfo.setLicence(licencedata);
			}
		} catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		userinfoService.addUserinfo(userinfo);
        return new JsonResult("注册成功！");
		
	}

	/**
	 * 批量删除用户信息
	 * @param userinfos
	 * @return
	 */
	@DeleteMapping("restuserinfo")
	public JsonResult removeUserinfo(@RequestBody List<Map<String,Object>> userinfos) {
		List<Integer> userids = new ArrayList<Integer>();
		RentinfoExample rentinfoExample = new RentinfoExample();
        for(Map<String,Object> g : userinfos) {
        	Integer userid = (Integer)g.get("userid");
        	rentinfoExample.createCriteria().andUseridEqualTo(userid).andIsplayEqualTo("未支付").andReturntimeIsNull();
        	log.info("rentinfoExample="+JSONArray.fromObject(rentinfoExample.getOredCriteria()).toString());
        	//查询用户是否正在使用汽车
        	List<Map<String,Object>> rentinfoList1 = rentinfoService.findRentinfoByExample(rentinfoExample);
        	if(rentinfoList1.size() > 0) {
        		return new JsonResult(JsonResult.ERROR,"删除失败，编号:"+userid+"用户正在使用车辆！");
        	}
    		rentinfoExample.clear();
    		log.info("rentinfoExample=clear="+JSONArray.fromObject(rentinfoExample.getOredCriteria()).toString());
    		rentinfoExample.createCriteria().andUseridEqualTo(userid).andIsplayEqualTo("未支付").andRentaltimeIsNotNull();
    		//查询用户是否有未支付订单
    		List<Map<String,Object>> rentinfoList2 = rentinfoService.findRentinfoByExample(rentinfoExample);
    		rentinfoExample.clear();
    		if(rentinfoList2.size() > 0) {
    			return new JsonResult(JsonResult.ERROR,"删除失败，编号:"+userid+"用户有未支付订单！");
    		}
            userids.add(userid);
        }
		userinfoService.removeUserinfos(userids);
		return new JsonResult("删除成功");
	}

	/**
	 * 修改用户信息
	 * @param userinfo
	 * @return
	 */
	@PutMapping("restuserinfo")
	public JsonResult editUserinfo(Userinfo user,@RequestParam("icon1") MultipartFile icon,@RequestParam("licence1") MultipartFile licence,HttpServletRequest request) {
		UserinfoWithBLOBs userinfo = new UserinfoWithBLOBs();
		log.info("licence=========="+licence.isEmpty());
		//使用BeanUtils工具将user对象的属性copy到userinfo对象上
		BeanUtils.copyProperties(user, userinfo);
		log.info("userinfo=========="+JSONObject.fromObject(userinfo).toString());
		RentinfoExample rentinfoExample = new RentinfoExample();
    	//查询用户是否正在使用汽车
		rentinfoExample.createCriteria().andUseridEqualTo(user.getUserid()).andIsplayEqualTo("未支付").andReturntimeIsNull();
    	List<Map<String,Object>> rentinfoList1 = rentinfoService.findRentinfoByExample(rentinfoExample);
    	if(rentinfoList1.size() > 0) {
    		return new JsonResult(JsonResult.ERROR,"修改失败，编号:"+user.getUserid()+"用户正在使用系统！");
    	}
		rentinfoExample.clear();
		//查询用户是否有未支付订单
		rentinfoExample.createCriteria().andUseridEqualTo(user.getUserid()).andIsplayEqualTo("未支付").andRentaltimeIsNotNull();
		List<Map<String,Object>> rentinfoList2 = rentinfoService.findRentinfoByExample(rentinfoExample);
		if(rentinfoList2.size() > 0) {
			return new JsonResult(JsonResult.ERROR,"修改失败，编号:"+user.getUserid()+"用户有未支付订单！");
		}
		try {
			if(!licence.isEmpty()) {
				InputStream licenceis = licence.getInputStream();
				byte[] licencebuffer=new byte[2048];
				int len2=0;
				ByteArrayOutputStream bos2=new ByteArrayOutputStream();
				while((len2=licenceis.read(licencebuffer))!=-1){
					bos2.write(licencebuffer,0,len2);
				}
				bos2.flush();
				byte licencedata[] = bos2.toByteArray();
				userinfo.setLicence(licencedata);
			}
			if(!icon.isEmpty()) {
				InputStream iconis = icon.getInputStream();
				byte[] iconbuffer=new byte[2048];
				int len1=0;
				ByteArrayOutputStream bos1=new ByteArrayOutputStream();
				while((len1=iconis.read(iconbuffer))!=-1){
					bos1.write(iconbuffer,0,len1);
				}
				bos1.flush();
				byte icondata[] = bos1.toByteArray();
				userinfo.setIcon(icondata);
			}
		} catch (Exception e) {
	        // TODO Auto-generated catch block
	        e.printStackTrace();
	    }
		request.getSession().setAttribute("currentUserName",userinfo.getUseraccount());
		request.getSession().setAttribute("currentUser",userinfo);
		String iconString =  Arrays.toString(userinfo.getIcon());
		String licenceString =  Arrays.toString(userinfo.getLicence());
		request.getSession().setAttribute("iconString",iconString);
		request.getSession().setAttribute("licenceString",licenceString);
		userinfoService.editUserinfo(userinfo);
		return new JsonResult("修改成功");

	}

	/**
	 * 通过用户编号获取用户信息
	 * @param userid
	 * @return
	 */
	@GetMapping("{userid}/restuserinfo")
	public JsonResult<UserinfoWithBLOBs> getUserinfo(@PathVariable int userid) {
		return new JsonResult<UserinfoWithBLOBs>(userinfoService.findUserinfoByUserid(userid));

	}

	/**
	 * 多组合查询用户信息，返回分页信息
	 * @param pageSize
	 * @param pageNum
	 * @param sort
	 * @param order
	 * @param useraccount
	 * @param idcard
	 * @param credit
	 * @return
	 */
	@GetMapping("restuserinfo")
	public JsonResult<UserinfoWithBLOBs> showPage(int pageSize,int pageNum,String sort,
			String order,String useraccount,String idcard){
		PageHelper.startPage(pageNum,pageSize,sort+" "+order);
		UserinfoExample ge = new UserinfoExample();
		ge.createCriteria()
				.andUseraccountLike("%"+useraccount+"%")
				.andIdcardLike("%"+idcard+"%");
		return new JsonResult<UserinfoWithBLOBs>(new PageInfo<UserinfoWithBLOBs>(userinfoService.findUserinfoByExample(ge)));
	}
	
	@GetMapping("findAll")
	public JsonResult<UserinfoWithBLOBs> showPage(){
		
		return new JsonResult<UserinfoWithBLOBs>(new PageInfo<UserinfoWithBLOBs>(userinfoService.findUserinfoByExample(null)));
	}
	
	@PostMapping("forgetPassword")
	public JsonResult forgetPassword(String userphone,String password){
		UserinfoExample userinfoExample = new UserinfoExample();
		userinfoExample.createCriteria().andPhoneEqualTo(userphone);
		List<UserinfoWithBLOBs> userList = userinfoService.findUserinfoByExample(userinfoExample);
		if(userList.size() >0 ) {
			UserinfoWithBLOBs userinfo = userList.get(0);
			userinfo.setPassword(password);
			userinfoService.editUserinfo(userinfo);
			return new JsonResult("修改成功");
		}else {
			return new JsonResult("该手机号未注册账号！");
		}
	}
}
