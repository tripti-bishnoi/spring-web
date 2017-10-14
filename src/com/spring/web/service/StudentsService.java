package com.spring.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.web.dao.Student;
import com.spring.web.dao.StudentsDAO;

@Service("studentsService")
public class StudentsService {

	@Autowired
	private StudentsDAO studentsDao;
	
	public List<Student> getAllStudents(){
		return studentsDao.getAllStudents();
	}
	
	public boolean insertStudent(Student student){
		return studentsDao.insertStudent(student);
	}
}
