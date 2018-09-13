package com.open.mis.modules.admin.loginSystem.roleManagement.controller;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.open.mis.modules.admin.loginSystem.roleManagement.dao.RoleManagementDao;
import com.open.mis.util.CommonResult;


@RestController
@RequestMapping("/admin/roleManagement")
public class RoleManagementController {

	Logger log = Logger.getLogger(RoleManagementController.class);
	
	@Autowired
	private RoleManagementDao roleManagementDao;
	
	@RequestMapping("/getRoles")
	public List<Map<String, Object>> getRoles() {
		return roleManagementDao.getRoles();
	}
	
	
	@RequestMapping("/updateRole")
	public CommonResult updateRole(@RequestParam Map<String,Object> map) {
		log.debug(map.toString());
		return new CommonResult(roleManagementDao.updateRole(map));
	}
	
	@RequestMapping("/insertRole")
	public CommonResult insertRole(@RequestParam Map<String,Object> map) {
		log.debug(map.toString());
		return new CommonResult(roleManagementDao.insertRole(map));
	}
	
	@RequestMapping("/getMenusByRoleCode")
	public Object getMenusByRoleCode(@RequestParam(name="role_code") String roleCode) {
		LinkedList<Object> list = new LinkedList<Object>(); 
		HashMap<String,String> map =new  HashMap<String,String>();
		map.put("text", "root");
		map.put("attributes", "/demo/book/abc");
		list.add(map);
		return list;
	}
	
}
