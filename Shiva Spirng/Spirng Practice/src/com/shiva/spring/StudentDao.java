package com.shiva.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;



public class StudentDao {

	Connection connection;
	PreparedStatement ps;
	
	public void addStudent() {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id: ");
		int id = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter name: ");
		String name = (sc.nextLine());
		
		System.out.println("Enter rollNo: ");
		int rollNo = Integer.parseInt(sc.nextLine());
		
		System.out.println("Enter stream Course: ");
		String streamCourse = sc.nextLine();
		
		
		try {
			connection = StudentDB.getCon();
			ps = connection.prepareStatement("insert into studentnew values (?,?,?,?)");
			ps.setInt(1, id);
			ps.setString(2, name);
			ps.setInt(3, rollNo);
			ps.setString(4, streamCourse);
			
			int result = ps.executeUpdate();
			if(result != 0)
			{
				System.out.println("Inserted");
			}
			else
				System.out.println("Not inserted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void displayStudent() {
	
		
		try {
			connection = StudentDB.getCon();
			ps = connection.prepareStatement("Select * from studentnew");
			
			ResultSet rs = ps.executeQuery();
			
				while(rs.next())
				{
					System.out.println("ID: "+rs.getInt(1));
					System.out.println("Name: "+rs.getString(2));
					System.out.println("RollNo: "+rs.getInt(3));
					System.out.println("Stream Course: "+rs.getString(4));
					System.out.println("-------------------------------------");
					System.out.println();
				}
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}

	public void deleteStudent(int id) throws UserException {
		
		
		try {
			connection = StudentDB.getCon();
			ps = connection.prepareStatement("delete from studentnew where id =?");
			ps.setInt(1, id);
			
			int result = ps.executeUpdate();
			if(result != 0)
			{
				System.out.println("Deleted");
			}
			else
				throw new UserException();
			
			
		} catch (SQLException e) {
			System.out.println("Read above");
			
		}
		
		
	}

	public void updateStudent(int id) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter id you want to update to: ");
		int id2 = Integer.parseInt(sc.nextLine());
		
		try {
			connection = StudentDB.getCon();
			ps = connection.prepareStatement("update studentnew set id=? where id=?");
			ps.setInt(1, id2);
			ps.setInt(2, id);
			
			int result = ps.executeUpdate();
			if(result != 0)
			{
				System.out.println("Updated");
			}
			else
				System.out.println("Not Updated");
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	public Student getId(int id) {
	
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
		Student student = (Student) applicationContext.getBean("student");
		
		try {
			connection = StudentDB.getCon();
			
			ps = connection.prepareStatement("Select * from studentnew Where id=? ");
			ps.setInt(1, id);
			
			ResultSet rs = ps.executeQuery();
			while(rs.next())
			{
				student.id= id;
				student.name= rs.getString(2);
				student.rollNo= rs.getInt(3);
				student.streamCourse =rs.getString(4);
				
			return student;
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

	
}
