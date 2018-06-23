package com.open.mis.modules.login.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.open.mis.modules.login.entity.Module;
import com.open.mis.modules.login.entity.Page;


public interface MenuDao {

	@Select("select node_code as id,node_text as text from module_node where role_code = #{roleCode}")
	List<Module> getModules(@Param("roleCode") String roleCode);
	
	@Select("select node_code,page_text as text,page_url as attributes from module_page where role_code = #{roleCode}")
	List<Page> getPages(@Param("roleCode") String roleCode);
	
	
}
