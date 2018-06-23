package com.open.mis.util;

public class CommonResult {

	private Object data;
	
	private String msg;
	
	private int state;

	/*
	 * 三个构造方法
	 * */
	
	public CommonResult() {
		this.msg = "操作成功";
		this.state = 200;
	}
	
	
	public CommonResult(Object data) {
		this.data = data;
		this.msg = "操作成功";
		this.state = 200;
	}
	
	public CommonResult(int state,String msg) {
		this.msg = msg;
		this.state = state;
	}

	
	
	
	
	
	
	
	
	
	public Object getData() {
		return data;
	}


	public void setData(Object data) {
		this.data = data;
	}


	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}
	
	
}
