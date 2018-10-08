package com.login;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOperation {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	public boolean isValid(String username, String password) throws UserExceptionLogin
	{
		boolean status = false;
		connection = ConnectionProvider.getCon();
		try {
			preparedStatement = connection.prepareStatement("select * from Hospitallogin where hospital_username =? and hospital_password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			int result = preparedStatement.executeUpdate();
			
			if(result!=0)
			{
			 status = true;
			 return status;
			}
			
			else
				return status;
		}
		catch (SQLException e) {
			
		}
		
		
		return false;
		
	}
}
