package com.atm.utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionProvider {

	static Connection con = null;

	public static Connection getConnection() {

		try {
			/* Initialize and load the JDBC-ODBC Bridge driver */
			Class.forName("oracle.jdbc.driver.OracleDriver");
			/* Establish a connection with a data source */
			 con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr");
			return con;
		} catch (ClassNotFoundException | SQLException e) {
			System.out.println(e.toString());
		}
		/* returns connection object */
		return con;
	}

}
