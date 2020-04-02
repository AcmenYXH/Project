package com.carss.exception;

import com.carss.exception.enums.ErrorEnum;

/**
 * 自定义异常用于处理系统所有逻辑异常的情况
 * @author Yangxiaohui
 */
public class WebException extends RuntimeException{

	private Integer code;

	public Integer getCode() {
		return code;
	}

	public void setCode(Integer code) {
		this.code = code;
	}

	public WebException(Integer code) {
		this.code = code;
	}
	
	public WebException(Integer code,String message) {
		super(message);
		this.code = code;
	}
	
	public WebException(ErrorEnum errorEnum) {
		super(errorEnum.getMessage());
		this.code = errorEnum.getCode();
	}
	
	public WebException(ErrorEnum errorEnum,String message) {
		super(message);
		this.code = errorEnum.getCode();
	}
	
	
}
