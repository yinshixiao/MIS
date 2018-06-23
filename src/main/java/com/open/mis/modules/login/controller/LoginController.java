package com.open.mis.modules.login.controller;


import java.util.Iterator;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.mis.modules.login.entity.Module;
import com.open.mis.modules.login.entity.Role;
import com.open.mis.modules.login.entity.User;
import com.open.mis.modules.login.service.LoginService;
import com.open.mis.modules.login.service.MenuService;
import com.open.mis.util.CommonResult;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	private static Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@Autowired
	private MenuService menuService;
	
	/**
	 * 用户登陆
	 * */
	@RequestMapping(value="/doLogin")
	public CommonResult login(String userCode,String password,HttpSession session) {
		log.debug("用户登陆一次，用户名："+userCode+"  密码："+password);
		User user = loginService.getUserByUserCodeAndPassword(userCode,password);
		if(null==user) {
			return new CommonResult(100,"用户名或密码错误");
		}
		List<Role> roleList = loginService.getRoleListByUserCode(userCode);
		if(roleList.isEmpty()) {
			return new CommonResult(100,"用户未分配角色");
		}
		session.setAttribute("user", user);
		session.setAttribute("roleList", roleList);
		return new CommonResult(roleList);
	}
	
	/*
	 * 用户选择角色
	 * */
	@SuppressWarnings("unchecked")
	@RequestMapping(value="/selectRole")
	public CommonResult selectRole(String roleCode,HttpSession session) {
		List<Role> roleList = (List<Role>) session.getAttribute("roleList");
		Iterator<Role> iterator= roleList.iterator();
		while(iterator.hasNext()) {
			Role role = iterator.next();
			if(roleCode.equals(role.getRoleCode())) {
				session.setAttribute("role", role);
				return new CommonResult(role);
			}
		}
		return new CommonResult(100,"角色选择异常！");
	}
	
	@RequestMapping(value="/getMenu")
	public List<Module> getMenu(HttpSession session) {
		Role role = (Role) session.getAttribute("role");
		log.debug(role.getRoleCode());
		return menuService.getMenuByRoleCode(role.getRoleCode());
	}
	
}
