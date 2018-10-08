package com.usebean;

public class User {

	String name;
	int age;
	String password;
	String phoneNumber;
	@Override
	public String toString() {
		return "User [name=" + name + ", age=" + age + ", password=" + password + ", phoneNumber=" + phoneNumber + "]";
	}
	public User(String name, int age, String password, String phoneNumber) {
		super();
		this.name = name;
		this.age = age;
		this.password = password;
		this.phoneNumber = phoneNumber;
	}
	public User() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
}
