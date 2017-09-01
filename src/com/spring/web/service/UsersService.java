package com.spring.web.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.User;
import com.spring.web.dao.UsersDAO;

@Service("usersService")
public class UsersService {

	private UsersDAO usersDao;
	
	@Autowired
	public void setUsersDao(UsersDAO usersDao) {
		this.usersDao = usersDao;
	}

	public List<User> getCurrent(){
		return usersDao.getAllUsers();
	}

	public void createUser(User user) {
		usersDao.insert(user);
	}

	public void throwException() {
		usersDao.getUser(111); //using and id which doesn't exist in database
	}
}
