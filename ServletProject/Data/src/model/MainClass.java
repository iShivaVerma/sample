package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class MainClass {

	Connection con;
	PreparedStatement ps;
	
	public boolean insert(User user) throws SQLException
	{
		con = ConnectionProvider.getCon();
		ps = con.prepareStatement("insert into likes values(?,?,?,?,?)");
		ps.setString(1, user.getName());
		ps.setString(2, user.getHobbies()[0]);
		ps.setString(3, user.getHobbies()[1]);
		ps.setString(4, user.getHobbies()[2]);
		ps.setString(5, user.getHobbies()[3]);
		
		int result = ps.executeUpdate();
		
		if(result!=0)
		{
			return true;
		}
		else return false;
	}
	
}
