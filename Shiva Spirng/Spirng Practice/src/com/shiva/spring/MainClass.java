package com.shiva.spring;

import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) throws UserException {
		
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
		StudentDao studentDao = (StudentDao) applicationContext.getBean("studentDao");
		Student student = (Student) applicationContext.getBean("student");
		Scanner sc = new Scanner(System.in);
		
		studentDao.getId(2);
		while(true)
		{
			System.out.println("1. Add student to the database: \n2.Display Students: \n3.Delete student: \n4.Update student by id: \n0.Exit");
			int choice = Integer.parseInt(sc.nextLine());
			
			switch(choice)
			{
			case 1: studentDao.addStudent();
				break;
			case 2: studentDao.displayStudent();
				break;
			case 3: System.out.println("Enter id to delete the student: ");
			int id = Integer.parseInt(sc.nextLine());
				studentDao.deleteStudent(id);
				break;
			case 4: System.out.println("Enter id to update the student: ");
			int id2 = Integer.parseInt(sc.nextLine());
				studentDao.updateStudent(id2);
				break;
			case 0: System.exit(0);
				break;
			default: System.out.println("Wrng choice");
				
			}
			
		}
	}
}
