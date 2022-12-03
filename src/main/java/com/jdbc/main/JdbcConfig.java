package com.jdbc.main;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.jdbc.dao.StudentDaoImpl;

@Configuration
public class JdbcConfig {
	
	@Bean("ds")
	public DriverManagerDataSource getConnection() {
		DriverManagerDataSource ds=new DriverManagerDataSource();
		ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
		ds.setUrl("jdbc:mysql://localhost:3306/springjdbc");
		ds.setUsername("root");
		ds.setPassword("ashutosh@4658");
		
		return ds;
	}
	@Bean("jdbcTemplate")
	public JdbcTemplate geTemplate() {
		JdbcTemplate jdbcTemplate=new JdbcTemplate();
		jdbcTemplate.setDataSource(getConnection());
		
		return jdbcTemplate;
	}
	@Bean("student")
	public StudentDaoImpl getStudentDaoImpl() {
		StudentDaoImpl studentDao=new StudentDaoImpl();
		studentDao.setJdbcTemplate(geTemplate());
		
		return studentDao;
	}

}
