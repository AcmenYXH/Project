package com.carss.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;


@Component
public class SessionInterceptor implements HandlerInterceptor {

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception {
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		HttpSession session = request.getSession();
		String path = request.getServletPath();
		System.out.println("path:"+path);
		if(session.getAttribute("currentUserName")!=null||path.indexOf("login")!=-1||path.indexOf("homepage")!=-1
				||path.indexOf("userregister")!=-1||path.indexOf("weather")!=-1||path.indexOf("send")!=-1
				||path.indexOf("checkaccount")!=-1||path.indexOf("checkphone")!=-1||path.indexOf("restuserinfo")!=-1
				||path.indexOf("aboutus")!=-1||path.indexOf("forget_password")!=-1||path.indexOf("forgetPassword")!=-1
				||path.indexOf("verifyCode")!=-1) {
			return true;
		}else {
			request.setAttribute("msg", "请重新登录！");
			request.getRequestDispatcher("login.html").forward(request, response);
			return false;
		}
		
	}

}
