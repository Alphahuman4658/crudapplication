package com.jdbc.main;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import com.jdbc.dao.StudentDaoImpl;
import com.jdbc.entities.Student;

public class App {

	public static void main(String[] args) {
		
		System.out.println("*****************CRUD APPLICATION*****************");
		System.out.println("                (using Spring JDBC)"               );
		System.out.println();
		
		AbstractApplicationContext context=new AnnotationConfigApplicationContext(JdbcConfig.class);
		
		context.registerShutdownHook();
		
		StudentDaoImpl studentDao = context.getBean("student",StudentDaoImpl.class);
		
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		
		try {
			
			while(true) {
				System.out.println("Enter 1 --> Insert Data");
				System.out.println("Enter 2 --> Update Data");
				System.out.println("Enter 3 --> Delete Data");
				System.out.println("Enter 4 --> Search Data Using ID");
				System.out.println("Enter 5 --> Display All Data");
				System.out.println("Enter 6 --> EXIT Application");
				System.out.println();
				System.out.print("Opertaion : ");
				int i=Integer.parseInt(br.readLine());
				System.out.println("_______________________________");
				
				Student student=new Student();
				
				if(i==1)
				{
					System.out.println();
					System.out.print("Enter Student ID    :");
					int j=Integer.parseInt(br.readLine());
					
					System.out.print("Enter Student Name  :");
					String name=br.readLine();
					
					System.out.print("Enter Student Phone :");
					String phone=br.readLine();
					
					System.out.print("Enter Student City  :");
					String city=br.readLine();
					
					student.setId(j);
					student.setName(name);
					student.setPhone(phone);
					student.setCity(city);
					
					int result = studentDao.insertData(student);
					System.out.println();
					System.out.println(result+" Data added to database");
					System.out.println("_______________________________");
					
					
				}else if(i==2)
				{
					System.out.println();
					System.out.print("Enter Student ID    : ");
					int j=Integer.parseInt(br.readLine());
					
					System.out.print("Enter New Student Name  : ");
					String name=br.readLine();
					
					System.out.print("Enter New Student Phone : ");
					String phone=br.readLine();
					
					System.out.print("Enter New Student City  : ");
					String city=br.readLine();
					
					student.setId(j);
					student.setName(name);
					student.setPhone(phone);
					student.setCity(city);
					
					int result = studentDao.updateData(student);
					System.out.println();
					System.out.println(result+" Data Updated to database");
					System.out.println("_______________________________");
					
					
				}else if(i==3)
				{
					System.out.println();
					System.out.print("Enter Student ID    :");
					int j=Integer.parseInt(br.readLine());
					
					student.setId(j);
					
					int result = studentDao.deleteData(student);
					System.out.println();
					System.out.println(result+" Data Deleted to database");
					System.out.println("_______________________________");
					
					
				}else if(i==4)
				{
					System.out.println();
					System.out.print("Enter Student ID    :");
					int j=Integer.parseInt(br.readLine());
					
					Student result = studentDao.fetchDataUsingId(j);
					
					System.out.println();
					System.out.println("ID -> "+result.getId());
					System.out.println("Name  : "+result.getName());
					System.out.println("Phone : "+result.getPhone());
					System.out.println("City  : "+result.getCity());
					System.out.println("_______________________________");
					
					
				}else if(i==5)
				{
					List<Student> result = studentDao.showAllData();
					
					for(Student s:result) {
						
						System.out.println();
						System.out.println(s);
						System.out.println();
						System.out.println("_______________________________");
					}
					
					
				}else if(i==6)
				{
					
					break;
					
				}
				
				
			}
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
