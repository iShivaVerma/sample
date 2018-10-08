package com.usebean;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DAOOperations {

	Connection connection;
	PreparedStatement preparedStatement;
	ResultSet resultSet;
	
	public boolean isValid(String username, String password)
	{
		
		try {
			connection = ConnectionProvider.getCon();
			preparedStatement = connection.prepareStatement("select * from newUser where name=? and password=?");
			preparedStatement.setString(1, username);
			preparedStatement.setString(2, password);
			
			int result = preparedStatement.executeUpdate();
			if(result!=0)
			{
				System.out.println("valid");
				return true;
			}
			else
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
		
	}
	public boolean isInserted(User user)
	{
		connection = ConnectionProvider.getCon();
		
		try {
			preparedStatement = connection.prepareStatement("insert into newUser values(?,?,?,?)");
			preparedStatement.setString(1, user.getName());
			preparedStatement.setInt(2, user.getAge());
			preparedStatement.setString(3, user.getPassword());
			preparedStatement.setString(4, user.getPhoneNumber());
			int result = preparedStatement.executeUpdate();
			System.out.println(result);
			if(result!=0)
			{
				System.out.println("valid");
				return true;
			}
			
			return false;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return false;
	
		
	}
}
