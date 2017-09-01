/**
 * 
 */
package com.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.core.namedparam.SqlParameterSourceUtils;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author Tripti Ashish Upadhyay
 *
 */
@Component("usersDao")
public class UsersDAO {

	private NamedParameterJdbcTemplate jdbc;
	
	@Autowired
	public void setDataSource(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}
	
	public List<User> getAllUsers(){
		
		return jdbc.query("select * from users", new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				
				return user;
			}
			
		});
	}
	
	public List<User> getUsers(){
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("id", 876);
		params.addValue("name", "Gotya");
		
		return jdbc.query("select * from users where id = :id or username = :name", params, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				
				return user;
			}
			
		});
	}
	
	public User getUser(int id){
		MapSqlParameterSource params = new MapSqlParameterSource(); 
		params.addValue("id", id);
		
		return jdbc.queryForObject("select * from users where id = :id", params, new RowMapper<User>() {

			public User mapRow(ResultSet rs, int rowNum) throws SQLException {
				User user = new User();
				
				user.setId(rs.getInt("id"));
				user.setUsername(rs.getString("username"));
				
				return user;
			}
			
		});
	}
	
	public boolean delete(int id){
		MapSqlParameterSource params = new MapSqlParameterSource("id", id);
		return jdbc.update("delete from users where id = :id", params) == 1;
	}
	
	public boolean insert(User user){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update("insert into users (username) values (:username)", params) == 1;
	}
	
	@Transactional()
	public int[] insertBatch(List<User> users){
		SqlParameterSource[] batchArgs = SqlParameterSourceUtils.createBatch(users.toArray());
		return jdbc.batchUpdate("insert into users (id, username) values (:id, :username)", batchArgs);
	}
	
	public boolean update(User user){
		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(user);
		return jdbc.update("update users set username = :username where id = :id", params) == 1;
	}
	
}
