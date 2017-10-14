package com.spring.web.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

@Component("studentsDao")
public class StudentsDAO {

	private NamedParameterJdbcTemplate jdbc;

	@Autowired
	public void setJdbc(DataSource jdbc) {
		this.jdbc = new NamedParameterJdbcTemplate(jdbc);
	}

	public List<Student> getAllStudents(){
		return jdbc.query("select * from students", new RowMapper<Student>() {

			@Override
			public Student mapRow(ResultSet rs, int rowNum) throws SQLException {
				Student student = new Student();

				student.setId(rs.getInt("id"));
				student.setFirstname(rs.getString("firstname"));
				student.setLastname(rs.getString("lastname"));
				student.setAge(rs.getInt("age"));
				student.setEmail(rs.getString("email"));
				student.setStandard(rs.getInt("standard"));
				student.setText(rs.getString("text"));

				return student;
			}

		});
	}

	public boolean insertStudent(Student student){

		BeanPropertySqlParameterSource params = new BeanPropertySqlParameterSource(student);

		return jdbc.update("insert into students (firstname, lastname, age, email, standard, text) values (:firstname, :lastname, :age, :email, :standard, :text)"
				, params) == 1;
	}

}
