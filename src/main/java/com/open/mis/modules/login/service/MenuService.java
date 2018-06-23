package com.open.mis.modules.login.service;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.open.mis.modules.login.dao.MenuDao;
import com.open.mis.modules.login.entity.Module;
import com.open.mis.modules.login.entity.Page;


@Service
public class MenuService {

	@Autowired
	private MenuDao menuDao;
	
	
	public List<Module> getMenuByRoleCode(String roleCode) {
		List<Module> modules = menuDao.getModules(roleCode);
		List<Page> pages = menuDao.getPages(roleCode);
		
		List<Integer> willRemove = new ArrayList<Integer>();
		
		
		for(int i =0;i<modules.size();i++) {
			String moduleCode = modules.get(i).getId();
			for(Page page:pages) {
				if(page.getNodeCode().equals(moduleCode)) {
					modules.get(i).addPage(page);
				}
			}
			if(modules.get(i).getChildren()==null) {
				willRemove.add(i);
			}else {
				if(modules.get(i).getChildren().isEmpty()) {
					willRemove.add(i);
				}
			}
		}
		//没有子页面只有节点的倒序移出集合
		for(int i =willRemove.size()-1;i>=0;i--) {
			modules.remove(willRemove.get(i).intValue());
		}
		return modules;
	}

}
