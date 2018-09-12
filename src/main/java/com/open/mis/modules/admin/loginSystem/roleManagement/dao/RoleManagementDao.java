package com.open.mis.modules.admin.loginSystem.roleManagement.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Select;

public interface RoleManagementDao {
	
	@Select(" select * from sys_role")
	List<Map<String,Object>> getRoles();
	
	Integer updateRole(Map<String,Object> map);
	
	Integer insertRole(Map<String,Object> map);
}
