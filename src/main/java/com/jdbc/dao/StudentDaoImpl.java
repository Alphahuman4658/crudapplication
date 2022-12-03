package com.jdbc.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.jdbc.core.JdbcTemplate;

import com.jdbc.entities.Student;

public class StudentDaoImpl implements StudentDao,InitializingBean,DisposableBean {

	JdbcTemplate jdbcTemplate;

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public String toString() {
		return "StudentDaoImpl [jdbcTemplate=" + jdbcTemplate + "]";
	}
	public void destroy() throws Exception {
		System.out.println();
		System.out.println("Program Terminated :"+new Date().toString());
		System.out.println();				
	}

	public void afterPropertiesSet() throws Exception {
		System.out.println();
		System.out.println("Program Started :"+new Date().toString());
		System.out.println();		
	}

	public int insertData(Student student) {
		String query="insert into student(id,name,phone,city) values(?,?,?,?)";
		int r = this.jdbcTemplate.update(query, student.getId(),student.getName(),student.getPhone(),student.getCity());
		return r;
	}

	public int updateData(Student student) {
		String query="update student set name=?,phone=?,city=? where id=?";
		int result = this.jdbcTemplate.update(query, student.getName(),student.getPhone(),student.getCity(),student.getId());
		return result;
	}

	public int deleteData(Student student) {
		String query="delete from student where id=?";
		int result = this.jdbcTemplate.update(query, student.getId());
		return result;
	}

	public Student fetchDataUsingId(int id) {
		String query="select * from student where id=?";
		Student result = this.jdbcTemplate.queryForObject(query, new RowMapperImpl(), id);
		return result;
	}

	public List<Student> showAllData() {
		String query="select * from student";
		List<Student> student = this.jdbcTemplate.query(query, new RowMapperImpl());
		return student;
	}


	
}
