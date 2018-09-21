package com.atm.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



@Entity
@Table(name="Users")
public class User {

	String username;
	@Id
	String accountNo;
	int pinNo;
	String gender;
	String address;
	long phoneNo;
	String status;
	double balance;
	@Override
	public String toString() {
		return "User [username=" + username + ", accountNo=" + accountNo + ", pinNo=" + pinNo + ", gender=" + gender
				+ ", address=" + address + ", phoneNo=" + phoneNo + ", status=" + status + ", balance=" + balance + "]";
	}
	public User(String username, String accountNo, int pinNo, String gender, String address, long phoneNo,
			String status, double balance) {
		super();
		this.username = username;
		this.accountNo = accountNo;
		this.pinNo = pinNo;
		this.gender = gender;
		this.address = address;
		this.phoneNo = phoneNo;
		this.status = status;
		this.balance = balance;
	}
	public User() {
		super();
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public int getPinNo() {
		return pinNo;
	}
	public void setPinNo(int pinNo) {
		this.pinNo = pinNo;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public long getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
}

