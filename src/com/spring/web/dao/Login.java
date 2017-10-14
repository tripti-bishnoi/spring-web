package com.spring.web.dao;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class Login {

	@NotBlank
	@Size(min=5, max=15)
//	@Pattern(regexp = "^\\w{5,}$")
	private String username;
	
	@NotBlank
//	@Pattern(regexp = "^\\S$")
	@Size(min=8,max=15)
	private String password;
	
	private Integer enabled = 0;
	private String authority;
	
	public Login() {
	}
	
	public Login(String username, String password, Integer enabled, String authority) {
		this.username = username;
		this.password = password;
		this.enabled = enabled;
		this.authority = authority;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Integer getEnabled() {
		return enabled;
	}

	public void setEnabled(Integer enabled) {
		this.enabled = enabled;
	}

	public String getAuthority() {
		return authority;
	}

	public void setAuthority(String authority) {
		this.authority = authority;
	}
	
}
