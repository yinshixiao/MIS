package com.open.mis.modules.login.entity;

/**
 * 菜单中的页面
 * */
public class Page {

	private Integer pageId ;
	
	private String nodeCode; 
	
	
	private String text;
	
	private String attributes;

	public Integer getPageId() {
		return pageId;
	}

	public void setPageId(Integer pageId) {
		this.pageId = pageId;
	}

	


	public String getNodeCode() {
		return nodeCode;
	}

	public void setNodeCode(String nodeCode) {
		this.nodeCode = nodeCode;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getAttributes() {
		return attributes;
	}

	public void setAttributes(String attributes) {
		this.attributes = attributes;
	}

	
	
	
}
