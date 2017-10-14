package com.spring.web.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.dao.User;
import com.spring.web.service.UsersService;

@Controller
public class UsersController {
	@Autowired
	private UsersService usersService;
	
	@RequestMapping("/showUsers")
	public String showUsers(Model model){
		
//		usersService.throwException();
		
		List<User> users = usersService.getCurrent();
		model.addAttribute("users", users);
		return "showUsers";
	}
	
	@RequestMapping("/createUsers")
	public String createUsers(Model model){
		model.addAttribute("user", new User());
		return "createUsers";
	}
	
	@RequestMapping(value="/doCreate", method=RequestMethod.POST)
	public String doCreate(Model model,@Valid User user, BindingResult result){
		
		if(result.hasErrors()){
			return "createUsers";
		}
		
		usersService.createUser(user);
		
		return "userCreated";
	}
	
//	@ExceptionHandler(DataAccessException.class)
//	public String handleDatabaseException(DataAccessException ex){
//		System.out.println("Exception: " + ex.getMessage());
//		return "error";
//	}
}
