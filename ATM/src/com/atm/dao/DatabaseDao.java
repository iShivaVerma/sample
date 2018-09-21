package com.atm.dao;

import java.sql.SQLException;
import java.util.List;

import com.atm.model.User;

public interface DatabaseDao {

	public User verifyCardNumber(String cardNumber);
	public List<User> verifyPinAndCardNumber(String cardNumber, int pinNumber);
	public void userInsert(User user);
	public int pinGenerate();
	public String accountNumberGenerate();
	public List<User> showAllUsers() throws SQLException;
}
