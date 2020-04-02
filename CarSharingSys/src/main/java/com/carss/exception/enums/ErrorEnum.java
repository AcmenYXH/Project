package com.carss.exception.enums;


/**
 * 定一个异常枚举类
 * @author Yangxiaohui
 */

public enum ErrorEnum {
	
	CHECK_FAIL(100),
	ADD_FAIL(101,"添加失败"),
	REMOVE_FAIL(102,"删除失败"),
	EDIT_FAIL(103,"修改失败"),
	FIND_NULL(104,"查无此数据");
	
	
	
	private Integer code;
	private String message;
	
	private ErrorEnum(Integer code) {
		this.code = code;
	}
	private ErrorEnum(Integer code, String message) {
		this.code = code;
		this.message = message;
	}

	public Integer getCode() {
		return code;
	}
	public void setCode(Integer code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	

}
