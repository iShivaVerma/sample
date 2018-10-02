package model;
import java.util.ArrayList;
import java.util.Arrays;

public class User {

	String name;
	String []hobbies = new String[3];
	
	@Override
	public String toString() {
		return "User [name=" + name + ", hobbies=" + Arrays.toString(hobbies) + "]";
	}
	public User(String name, String[] hobbies) {
		super();
		this.name = name;
		this.hobbies = hobbies;
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
	public String[] getHobbies() {
		return hobbies;
	}
	public void setHobbies(String[] hobbies) {
		this.hobbies = hobbies;
	}
	
}
