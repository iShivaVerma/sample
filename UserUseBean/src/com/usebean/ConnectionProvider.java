package com.usebean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionProvider {

	static Connection con ;
	static Connection getCon()
	{
		try{
			Class.forName("oracle.jdbc.driver.OracleDriver");
		 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			
		}
		catch(ClassNotFoundException | SQLException e)
		{
			System.out.println(e.toString());
		}
		return con;
	}
}
