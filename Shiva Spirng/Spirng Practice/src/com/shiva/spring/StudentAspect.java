package com.shiva.spring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.aopalliance.intercept.Joinpoint;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Aspect
public class StudentAspect {

	Connection connection;
	PreparedStatement ps ;
	
	@After("execution(public void addStudent())")
	public void allStudentDisplayAfter()
	{
		System.out.println("Displayed by After aspect");
	}
	

	@Before("execution(public void addStudent())")
	public void allStudentDisplayBefore()
	{
		new StudentDao().displayStudent();
	}
	
	@Before("execution(public void displayStudent())")
	public void display()
	{
		System.out.println("from Aspect. \n");
		new StudentDao().displayStudent();
		System.out.println("Bye bye Aspect. \n");
	}
	
	@AfterThrowing(pointcut="execution(public void deleteStudent(..))",throwing="ex")
	public void displayException(UserException ex)
	{	
		System.out.println("aspect execute after throwing "+ex);	
	}
	
	@AfterReturning(pointcut="execution(public Student getId(..))",returning="result")
	public void log2(JoinPoint jp,Object result) {
		Object arr[]=jp.getArgs();
		for(Object object:arr)
		{
			System.out.println(object);
		}
		System.out.println("aspect execute after returning "+result);
	}
	
}
