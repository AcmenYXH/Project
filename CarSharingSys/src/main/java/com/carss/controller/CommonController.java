package com.carss.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CommonController {

	@RequestMapping("/*")
	public String doForward(HttpServletRequest request) {
		String url = request.getServletPath();
		System.out.println(url);
		String path = url.substring(0,url.indexOf("."));
		return path;
	}
}
