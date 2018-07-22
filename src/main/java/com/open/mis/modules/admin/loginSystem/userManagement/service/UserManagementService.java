package com.open.mis.modules.admin.loginSystem.userManagement.service;

import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import com.open.mis.modules.admin.loginSystem.userManagement.dao.UserManagementDao;
import com.open.mis.util.CommonResult;

@Service
public class UserManagementService {

	@Autowired
	private UserManagementDao userManagementDao;
	
	public HashMap<String, Object> getUsers(Map<String,Object> map) {
		/*分页以后写到拦截器当中*/
		Integer start = (Integer.valueOf((String) map.get("page"))-1)*Integer.valueOf((String) map.get("rows"));
		Integer end = start+Integer.valueOf((String) map.get("rows"));
		map.put("start", start);
		map.put("end", end);
		
		HashMap<String,Object> result = new HashMap<String,Object>();
		result.put("rows", userManagementDao.getUsers(map));
		map.put("isTotal", "yes");
		result.put("total",userManagementDao.getUsers(map).get(0).get("TOTAL"));
		return result;
	}
	
	public Integer editUser(@RequestParam Map<String,Object> map) {
		return userManagementDao.editUser(map);
	}
	
	public Integer addUser(@RequestParam Map<String,Object> map) {
		return userManagementDao.addUser(map);
	}
}
