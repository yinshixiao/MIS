package com.open.mis.modules.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.open.mis.modules.login.entity.Role;
import com.open.mis.modules.login.entity.User;

public interface LoginDao {
	
	
	
	@Select("select  *  from sys_user where user_code = #{userCode} and password = #{password} ")
	User getUserByUserCodeAndPassword(@Param("userCode") String userCode,@Param("password") String password);
	
	
	
	@Select(  " select user_link_role.role_code,role_name "
			+ " from user_link_role"
			+ " left join sys_role on  sys_role.role_code = user_link_role.role_code"
			+ " where user_code = #{userCode} ")
	List<Role> getRoleListByUserCode(@Param("userCode") String userCode);
	
	
	
}
