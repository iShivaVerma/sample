package com.shiva.spring;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class StudentDB {

	static DataSource dataSource;
	static Connection connection;
	@Override
	public String toString() {
		return "StudentDB [dataSource=" + dataSource + ", connection=" + connection + "]";
	}
	public StudentDB(DataSource dataSource, Connection connection) {
		super();
		this.dataSource = dataSource;
		this.connection = connection;
	}
	
	public StudentDB() {
	
	}
	
	public DataSource getDataSource() {
		return dataSource;
	}
	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}
	public Connection getConnection() {
		return connection;
	}
	public void setConnection(Connection connection) {
		this.connection = connection;
	}
	
	public static Connection getCon() throws SQLException
	{
		ApplicationContext applicationContext = new ClassPathXmlApplicationContext("spring-conf.xml");
		dataSource = (DataSource) applicationContext.getBean("dataSource");
		
		connection = dataSource.getConnection();
		
		System.out.println("Connection created");
		return connection;
	}
	
}
