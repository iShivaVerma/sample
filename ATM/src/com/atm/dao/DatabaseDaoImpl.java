package com.atm.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.AnnotationConfiguration;
import org.hibernate.cfg.Configuration;

import com.atm.model.Admin;
import com.atm.model.User;
import com.atm.utility.ConnectionProvider;
import com.atm.utility.SessionCreation;

public class DatabaseDaoImpl implements DatabaseDao {

	Session session;
	Connection con;
	PreparedStatement ps;
	ResultSet rs;
	
	public DatabaseDaoImpl() {
		Configuration cfg = new AnnotationConfiguration();
		SessionFactory factory = cfg.configure().buildSessionFactory();
		session = factory.openSession();
	}

	public User verifyCardNumber(String cardNumber) {
		
		System.out.println("verifyOpen");
		Transaction t = session.beginTransaction();
		User users = (User) session.get(User.class, cardNumber);
		t.commit();
		
		System.out.println(users);
		System.out.println("user retrieve");
		return users;
	}// end verifyCardNumber

	public List<User> verifyPinAndCardNumber(String cardNumber, int pinNumber) {
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("FROM Users WHERE accountNo=? AND pinNo=?");
		query.setString(0, cardNumber);
		query.setInteger(1, pinNumber);

		List<User> userList = query.list();
		t.commit();

		return userList;
	}// end verifyPinAndCardNumber

	public List<Admin> loginAdmin(Admin admin) {
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("FROM Admin WHERE adminid=? AND password=?");
		query.setString(0, admin.getAdminid().toUpperCase());
		query.setString(1, admin.getPassword());

		List<Admin> adminList = query.list();

		return adminList;
	}// end loginAdmin

	public void totalUserCount() {
		Transaction t = session.beginTransaction();
		Query query = session.createQuery("SELECT count(*) FROM Users");
	}// end totalUserCount

	public void userInsert(User user) {
		Session session = SessionCreation.getSession();
		Transaction t = session.beginTransaction();

		session.save(user);
		t.commit();

	}

	public int pinGenerate() {
		int number = (int) (Math.random() * 10000);
		System.out.println(number);

		return number;
	}

	public String accountNumberGenerate() {
		int sum = 0;

		int arr1[] = new int[16];

		int arr[] = new int[16];

		for (int i = 0; i < arr.length; i++) {

			arr[i] = (int) (Math.random() * 10);
		}

		for (int i = 0; i < arr.length; i++) {

			arr1[i] = arr[i];
		}

		System.out.println("old array");
		System.out.println();
		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();

		for (int i = 0; i < arr1.length; i++) {

			if (i % 2 == 0) {
				arr1[i] = arr1[i] * 2;

			}
		}

		System.out.println();
		System.out.print("double number at even places");

		for (int i : arr1) {
			System.out.print(i + ",");
		}
		System.out.println("Double numbers");
		System.out.println();
		for (int i = arr1.length - 1; i >= 0; i--) {

			if (i % 2 == 0) {
				if (arr1[i] >= 10) {
					arr1[i] = returnNumber(arr1[i]);
				}
			}
		}

		String number = "";
		for (int a : arr) {
			number = number+a;
		}
		
		System.out.println();
		System.out.println("after return");

		for (int i = 0; i < arr1.length; i++) {

			System.out.print(arr1[i] + " ");

			sum = sum + arr1[i];
		}

		int count = 0;

		System.out.println("number after summing");
		System.out.println(sum);

		if (sum % 10 == 0) {
			System.out.print("account number valid");
			System.out.println();
			count = 1;
			// return number;
		}

		if (count == 1) {
			return number;
		}

		else {
			DAOOperations obj = new DAOOperations();
			obj.accountNumberGenerate();

		}

		return number;
	}

	public int returnNumber(int num) {

		int remainder = 0;
		int sum = 0;

		while (true) {

			remainder = num % 10;

			sum = sum + remainder;
			return sum;
		}

	}

	public List<User> showAllUsers() throws SQLException {
		
		List<User> userlist = new ArrayList<>();
		User user; 
		 con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("select username , accountno , gender, address, phoneno, balance, status from users");
		
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			user = new User();
			user.setUsername(rs.getString(1));
			user.setAccountNo(rs.getString(2));
			user.setGender(rs.getString(3));
			user.setAddress(rs.getString(4));
			user.setPhoneNo(rs.getInt(5));
			user.setBalance(rs.getDouble(6));
			user.setStatus(rs.getString(7));
			
			userlist.add(user);
		}
		return userlist;
		
		
	}
	public int getPinNo(String accountNo) throws SQLException
	{
		int password =0;
		
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("select pinno from users where accountNo=? ");
		ps.setString(1, accountNo);
		
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			password =rs.getInt(1);
		}
		return password;
		
	}
	
	public int changePin(int pin, String cardNumber) throws SQLException
	{
		con= ConnectionProvider.getConnection();
		ps = con.prepareStatement("update users set pinno =? where accountNo =?");
		ps.setInt(1, pin);
		ps.setString(2, cardNumber);
		
		int isUpdated=ps.executeUpdate();
		
		//String status = "Password Changed Successfully";
		return isUpdated;
		
	}
	
	public boolean isPinValid(int pin , String cardNumber) throws SQLException
	{
		boolean status =false;
		
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("select * from users where accountno=? and pinno=?");
		ps.setString(1, cardNumber);
		ps.setInt(2, pin);
		rs = ps.executeQuery();
		System.out.println(pin+"-------"+cardNumber);
		while(rs.next())
		{
			status = true;
			return status;
		}
		
		
		return false;
		
	}
	
	public boolean changePassword(String cardnumber , long phoneNumber) throws SQLException
	{
		boolean status = false;
		
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("update users set phoneNo=? where accountno=? ");
		ps.setLong(1, phoneNumber);
		ps.setString(2, cardnumber);
		
		rs = ps.executeQuery();
		
		while(rs.next())
		{
			status= true;
			
			return status;
		}
		
		return false;
		
	}

	public int  getOtp()
	{
		int otp = (int) (Math.random()*10000);
		
		return otp;	
	}
	
	public boolean updatePinTable(String cardNumber , int otp) throws SQLException
	{
		boolean status = false;
		
		LocalDateTime currentTime = LocalDateTime.now();
		LocalDate date = currentTime.toLocalDate();
		Date date1 = Date.valueOf(date);
		
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("insert into pin values(?,?,?)");
		ps.setString(1, cardNumber);
		ps.setInt(2, otp);
		ps.setDate(3, date1);
		
		rs = ps.executeQuery();
		System.out.println("Query Executed");
		while(rs.next())
		{
			status= true;
			System.out.println("status is true");
			return status;
		}
		return false;
		
	}
	public int printOtp (String cardNumber, Date date) throws SQLException
	{
		//boolean status = false;
		System.out.println("Print Otp method");
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("select pinno from pin where accountNo =? and dates =?");
		ps.setString(1, cardNumber);
		ps.setDate(2, date);
		rs = ps.executeQuery();
		int otp = 0;
		System.out.println("Query executed");
		while(rs.next())
		{
			System.out.println("query get");
			System.out.println(rs.getInt(1));
			otp= rs.getInt(1);
		}
		
		return otp;
		
	}

	public boolean checkOtp(String cardNumber, int otp) throws SQLException {
		
		boolean status = false;
		System.out.println("called checkOtp");
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("select * from pin where accountNo =? and pinno =?");
		ps.setString(1, cardNumber);
		ps.setInt(2, otp);
		rs = ps.executeQuery();
		
		System.out.println("Executed in checkOtp");
		while(rs.next())
		{
			status = true;
			System.out.println("returning true: in checkotp");
			return status;
		}
		return status;
		
	}

	public boolean changePhoneNumber(String cardNumber, long number) throws SQLException {
		
boolean status = false;
		
		con = ConnectionProvider.getConnection();
		ps = con.prepareStatement("update users set phoneNo=? where accountno=? ");
		ps.setLong(1, number);
		ps.setString(2, cardNumber);
		
		rs = ps.executeQuery();
		System.out.println("executed");
		while(rs.next())
		{
			status= true;
			System.out.println("true");
			return status;
		}
		
		return false;
		
	}

}// end class
