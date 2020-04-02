package com.carss.aspect;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;


@Aspect
@Component
public class HttpAspect {

	private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
	
	@Pointcut("execution(public * com.carss.controller.*.*(..))")
	public void log() {}
	
	@Before("log()")
	public void logBefore(JoinPoint point) {
		ServletRequestAttributes attributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
		HttpServletRequest request = attributes.getRequest();
		//url
		logger.info("url={}",request.getRequestURI());
		//method
		logger.info("method={}",request.getMethod());
		//Ip
		logger.info("IP={}",request.getRemoteAddr());
		//类与方法
		logger.info("class_method={}",point.getSignature().getDeclaringTypeName()
				+"."+point.getSignature().getName());
		//参数
		logger.info("args={}",point.getArgs());
	}
	
	@AfterReturning(pointcut = "log()",returning = "obj")
	public void logAfterReturning(Object obj) {
		logger.info("response={}",obj);
	}
}
