package com.open.mis.modules.admin.loginSystem.userManagement.dao;

import java.util.List;
import java.util.Map;

public interface UserManagementDao {


	List<Map<String,Object>> getUsers(Map<String,Object> map);
	
}
