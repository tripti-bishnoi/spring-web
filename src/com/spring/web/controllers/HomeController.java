package com.spring.web.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {

//	@RequestMapping("/")
//	public String showHome(HttpSession session){
//		session.setAttribute("name", "Gotya");
//		return "home";
//	}
	
//	@RequestMapping("/")
//	public ModelAndView showHome(){
//		ModelAndView mv = new ModelAndView("home");
//		Map<String,Object> model = mv.getModel();
//		model.put("name", "<b>Gotya</b>");
//		return mv;
//	}
	
//	@RequestMapping("/")
//	public String showHome(Model model){
//		model.addAttribute("name", "Gotya");
//		return "home";
//	}
	
	@RequestMapping(value = "/test", method=RequestMethod.GET)
	public String showTest(Model model,@RequestParam("id") String id){
		System.out.println("ID is: " + id);
		return "home";
	}
	
	@RequestMapping("/")
	public String showHome(){
		return "home";
	}
}
