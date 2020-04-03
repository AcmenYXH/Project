package com.carss.controller;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	private static final Logger logger = LoggerFactory.getLogger(AdminController.class);

	@RequestMapping("/*")
	public String doForward(HttpServletRequest request) {
		String url = request.getServletPath();
		logger.info("====CommonController====url:{}",url);
		if(url.indexOf(".") != -1){
			String path = url.substring(0,url.indexOf("."));
			return path;
		}else {
			return url;
		}
	}
}
