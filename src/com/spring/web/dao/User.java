/**
 * 
 */
package com.spring.web.dao;

import javax.validation.constraints.Size;

import com.spring.web.validators.CustomSize;

/**
 * @author Tripti Ashish Upadhyay
 *
 */
public class User {

	private int id;
	
//	@Size(min=5, max=50, message="Name must be between 5 and 50")
	@CustomSize(min=2)
	private String username;
	
	/**
	 * 
	 */
	public User() {
	}
	/**
	 * @param username
	 */
	public User(String username) {
		this.username = username;
	}
	/**
	 * @param id
	 * @param username
	 */
	public User(int id, String username) {
		this.id = id;
		this.username = username;
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}
}
