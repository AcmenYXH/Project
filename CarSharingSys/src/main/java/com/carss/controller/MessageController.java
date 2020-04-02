package com.carss.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.carss.entity.JsonResult;
import com.carss.utils.SendTelMsgUtils;


@RestController
public class MessageController {
	
	@PostMapping("send")
	public JsonResult<String> send(String phone,HttpServletRequest request){
//		System.out.println(phone);
//		String radom=SendTelMsgUtils.randNum;
//		String result=SendTelMsgUtils.sendMsgTo(phone);
//		System.out.println("radom:"+radom+"---result"+result);
		String radom = "686868";
		return new JsonResult<>(radom);
	}
}
