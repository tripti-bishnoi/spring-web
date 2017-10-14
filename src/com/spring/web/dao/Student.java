package com.spring.web.dao;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class Student {

	private Integer id;
	@NotBlank(message="Value is required.")
	private String firstname;
	@NotBlank(message="Value is required.")
	private String lastname;
	@NotNull(message="Value is required.")
	private Integer age;
	@NotBlank(message="Value is required.")
	@Email(message="Please provide proper Email Id.")
	private String email;
	@NotNull(message="Value is required.")
	private Integer standard;
	private String text;
	
	public Student() {
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Integer getStandard() {
		return standard;
	}
	public void setStandard(Integer standard) {
		this.standard = standard;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
}
