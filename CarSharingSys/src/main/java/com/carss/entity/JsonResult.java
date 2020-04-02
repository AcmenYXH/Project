package com.carss.entity;

import com.github.pagehelper.PageInfo;

import java.util.List;
import java.util.Map;


/**
 * 前后端交互统一数据接口
 * @author Yangxiaohui
 */
public class JsonResult<T> {
	
	public static final int SUCCESS = 0;
	public static final int ERROR = 1;

	private int state;
	private String message = "";
	private T data;
	private List<T> datas;
	private PageInfo<T> pagedatas;
	private List<Map<String,Object>> listDatas;

	/**
	 * 有参构造函数
	 * 正常响应，返回是一个简单消息
	 * @param message
	 */
	public JsonResult(String message) {
		this.state = SUCCESS;
		this.message = message;
	}


	/**
	 * 有参构造函数
	 * 正常响应，返回对象
	 * @param data
	 */
	public JsonResult(T data) {
		this.state = SUCCESS;
		this.data = data;
	}
	
	/**
	 * 有参构造函数
	 * 正常响应，返回对象
	 * @param message
	 * @param data
	 */
	public JsonResult(String message,T data) {
		this.state = SUCCESS;
		this.message = message;
		this.data = data;
	}


	/**
	 * 有参构造函数
	 * 正常响应，返回集合
	 * @param datas
	 */
	public JsonResult(List<T> datas) {
		this.state = SUCCESS;
		this.datas = datas;
	}
//
//	/**
//	 * 有参构造函数
//	 * 正常响应，返回组合类型数据
//	 * @param listDatas
//	 */
//	public JsonResult(List<Map<String,Object>> listDatas) {
//		this.state = SUCCESS;
//		this.listDatas = listDatas;
//	}

	/**
	 * 有参构造函数
	 * 正常响应，返回分页
	 * @param pagedatas
	 */
	public JsonResult(PageInfo<T> pagedatas) {
		this.state = SUCCESS;
		this.pagedatas = pagedatas;
	}


	/**
	 * 有参构造
	 * 异常情况，返回错误消息
	 * @param state
	 * @param message
	 */
	public JsonResult(int state,String message) {
		this.state = state;
		this.message = message;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}

	public List<T> getDatas() {
		return datas;
	}

	public void setDatas(List<T> datas) {
		this.datas = datas;
	}

	public PageInfo<T> getPagedatas() {
		return pagedatas;
	}

	public void setPagedatas(PageInfo<T> pagedatas) {
		this.pagedatas = pagedatas;
	}

	public List<Map<String, Object>> getListDatas() {
		return listDatas;
	}

	public void setListDatas(List<Map<String, Object>> listDatas) {
		this.listDatas = listDatas;
	}
}
