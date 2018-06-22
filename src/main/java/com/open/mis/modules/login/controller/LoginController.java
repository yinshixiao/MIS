package com.open.mis.modules.login.controller;


import javax.servlet.http.HttpSession;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.open.mis.modules.login.entity.User;
import com.open.mis.modules.login.service.LoginService;
import com.open.mis.util.CommonResult;

@RestController
@RequestMapping(value="/login")
public class LoginController {
	private static Logger log = Logger.getLogger(LoginController.class);
	
	@Autowired
	private LoginService loginService;
	
	@RequestMapping(value="/doLogin")
	public CommonResult login(String userCode,String password,HttpSession session) {
		log.debug("用户登陆一次，用户名："+userCode+"  密码："+password);
		User user = loginService.getUserByUserCodeAndPassword(userCode,password);
		if(null==user) {
			return new CommonResult(100,"用户名或密码错误");
		}
		
		session.setAttribute("user", user);
		return new CommonResult();
	}
	
	
}
