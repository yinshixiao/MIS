package com.open.mis.util;

public class CommonResult {

	private Object date;
	
	private String msg;
	
	private int state;

	/*
	 * 三个构造方法
	 * */
	
	public CommonResult() {
		this.msg = "操作成功";
		this.state = 200;
	}
	
	
	public CommonResult(Object date) {
		this.date = date;
		this.msg = "操作成功";
		this.state = 200;
	}
	
	public CommonResult(int state,String msg) {
		this.msg = msg;
		this.state = state;
	}

	
	
	
	
	
	
	
	
	public Object getDate() {
		return date;
	}

	public void setDate(Object date) {
		this.date = date;
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
