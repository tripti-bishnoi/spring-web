package com.spring.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.stereotype.Service;

import com.spring.web.dao.Login;
import com.spring.web.dao.LoginDAO;

@Service("loginService")
public class LoginService {

	@Autowired
	private LoginDAO loginDao;
	
	public void createAccount(Login loginDetails){
		loginDao.createAccount(loginDetails);
	}

	public boolean exists(String username) {
		return loginDao.exists(username);
	}
	
	@Secured("hasAuthority('admin')")
	public boolean enableAccount(Login loginUpdate){
		return loginDao.enableAccount(loginUpdate);
	}
}
