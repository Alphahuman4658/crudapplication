package com.jdbc.dao;

import java.util.List;

import com.jdbc.entities.Student;

public interface StudentDao {
	
	public int insertData(Student student);
	
	public int updateData(Student student);
	
	public int deleteData(Student student);
	
	public Student fetchDataUsingId(int id);
	
	public List<Student> showAllData();

}
