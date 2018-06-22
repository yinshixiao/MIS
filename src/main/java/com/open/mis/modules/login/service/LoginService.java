package com.open.mis.modules.login.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.open.mis.modules.login.dao.LoginDao;
import com.open.mis.modules.login.entity.User;

@Service
public class LoginService {

	@Autowired
	private LoginDao loginDao;
	
	
	public User getUserByUserCodeAndPassword(String userCode,String password) {
		return loginDao.getUserByUserCodeAndPassword(userCode,password);
	}
}
