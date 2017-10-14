package com.spring.web.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.spring.web.dao.Student;
import com.spring.web.service.StudentsService;

@Controller
public class StudentController {

	@Autowired
	private StudentsService studentsService;
	
	@RequestMapping("/showAllStudents")
	public String showAllStudents(Model model){
		
		model.addAttribute("students", studentsService.getAllStudents());
		
		return "showAllStudents";
	}
	
	@RequestMapping("/insertStudent")
	public String insertStudent(Model model){
		model.addAttribute("student", new Student());
		
		return "insertStudent";
	}
	
	@RequestMapping(value="/studentSuccess", method=RequestMethod.POST)
	public String insertStudentSuccess(Model model,@Valid Student student, BindingResult result){
		
		if(result.hasErrors())
			return "insertStudent";
		
		studentsService.insertStudent(student);
		
		return "studentCreated";
	}
}
