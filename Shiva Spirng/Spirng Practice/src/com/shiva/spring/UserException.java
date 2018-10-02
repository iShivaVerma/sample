package com.shiva.spring;

public class UserException extends Exception{

	
	@Override
	public String toString() {
		
		String message ="Exception occurs due to Deletion of not exist date";
		return "UserException [Exception is: "  + message +"]";
	}

	
}
