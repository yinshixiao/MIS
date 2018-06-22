package com.open.mis.modules.login.dao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.open.mis.modules.login.entity.User;

public interface LoginDao {
	
	
	
	@Select("select  *  from sys_user where user_code = #{userCode} and password = #{password} ")
	User getUserByUserCodeAndPassword(@Param("userCode") String userCode,@Param("password") String password);
}
