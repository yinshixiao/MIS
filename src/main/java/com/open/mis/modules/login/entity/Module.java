package com.open.mis.modules.login.entity;

import java.util.LinkedList;
import java.util.List;


/**
 * 菜单中的文件夹
 * */
public class Module {
	

	private String id;
	
	private String text;
	
	private List<Page> children;

	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getText() {
		return text;
	}



	public void setText(String text) {
		this.text = text;
	}

	

	public List<Page> getChildren() {
		return children;
	}



	public void setChildren(List<Page> children) {
		this.children = children;
	}



	public void addPage(Page page) {
		if(this.children == null) {
			this.children = new LinkedList<Page>();
		}
		this.children.add(page);
	}
	
	
	
	
}
