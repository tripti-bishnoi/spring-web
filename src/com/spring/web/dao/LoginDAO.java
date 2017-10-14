package com.spring.web.dao;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component("loginDao")
public class LoginDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	private PasswordEncoder passwordEncoder; 
	
	@Autowired
	public LoginDAO(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	@Transactional
	public boolean createAccount(Login loginDetails) {

		MapSqlParameterSource params = new MapSqlParameterSource();
		
		params.addValue("username", loginDetails.getUsername());
		params.addValue("password", passwordEncoder.encode(loginDetails.getPassword()));
		params.addValue("enabled", loginDetails.getEnabled());
		params.addValue("authority", loginDetails.getAuthority());

		jdbc.update("insert into loginDetails (username, password, enabled) values (:username, :password, :enabled)",
				params);
		return jdbc.update("insert into authorities (username, authority) values (:username, :authority)", params) == 1;

	}

	public boolean exists(String username) {
		return jdbc.queryForObject("select count(*) from loginDetails where username = :username ",
				new MapSqlParameterSource("username", username), Integer.class) == 1;
	}

	public boolean enableAccount(Login loginUpdate) {
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(loginUpdate);
		
		return jdbc.update("update loginDetails set enabled = :enabled where username = :username", params) == 1;
	}
}
