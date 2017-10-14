package com.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.dao.Login;
import com.spring.web.dao.LoginDAO;
import com.spring.web.service.LoginService;

@Controller
public class LoginController {

	@Autowired
	private LoginService loginService;

	@RequestMapping("/login")
	public String login() {
		return "login";
	}

	@RequestMapping("/loggedOut")
	public String logout() {
		return "loggedOut";
	}

	@RequestMapping("/newAccount")
	public String showNewAccount(Model model) {
		model.addAttribute("loginDetails", new Login());
		return "newAccount";
	}

	@RequestMapping(value = "/createAccount", method = RequestMethod.POST)
	public String createAccount(Model model, @Valid @ModelAttribute("loginDetails") Login loginDetails,
			BindingResult result) {
		if (result.hasErrors())
			return "newAccount";

		if (loginService.exists(loginDetails.getUsername())) {
			result.rejectValue("username", "DuplicateKey.login.username");
			return "newAccount";
		}

		// try {
		// loginService.createAccount(loginDetails);
		// } catch (DuplicateKeyException e) {
		// result.rejectValue("username", "DuplicateKey.login.username", "This
		// username already exists!!");
		// return "newAccount";
		// }
		loginService.createAccount(loginDetails);

		return "accountCreated";
	}

	@RequestMapping("/adminStuff")
	public String updateAccount(Model model) {
		model.addAttribute("loginUpdate", new Login());
		return "adminStuff";
	}

	@RequestMapping(value = "/userEnabled", method = RequestMethod.POST)
	public String doAdminStuff(Login loginUpdate) {
		loginService.enableAccount(loginUpdate);
		return "accountCreated";
	}
	
	@RequestMapping("/denied")
	public String denied() {
		return "denied";
	}
}
