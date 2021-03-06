package com.open.mis.modules.admin.loginSystem.userManagement.controller;

import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.open.mis.modules.admin.loginSystem.userManagement.service.UserManagementService;
import com.open.mis.util.CommonResult;


@RestController
@RequestMapping("/admin/userManagement")
public class UserManagementController {

	Logger log = Logger.getLogger(UserManagementController.class);
	
	@Autowired
	private UserManagementService userManagementService;
	
	@RequestMapping("/getUsers")
	public CommonResult getUsers(@RequestParam Map<String,Object> map) {
		log.debug(map.toString());
		return new CommonResult(userManagementService.getUsers(map));
	}
	
	
	@RequestMapping("/updateUser")
	public CommonResult updateUser(@RequestParam Map<String,Object> map) {
		log.debug(map.toString());
		return new CommonResult(userManagementService.updateUser(map));
	}
	
	@RequestMapping("/insertUser")
	public CommonResult insertUser(@RequestParam Map<String,Object> map) {
		log.debug(map.toString());
		return new CommonResult(userManagementService.insertUser(map));
	}
}
