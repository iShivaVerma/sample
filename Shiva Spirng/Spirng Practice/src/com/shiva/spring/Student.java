package com.shiva.spring;

public class Student {

	int id;
	String name;
	int rollNo;
	String streamCourse;

	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", rollNo=" + rollNo + ", streamCourse=" + streamCourse + "]";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getRollNo() {
		return rollNo;
	}

	public void setRollNo(int rollNo) {
		this.rollNo = rollNo;
	}

	public String getStreamCourse() {
		return streamCourse;
	}

	public void setStreamCourse(String streamCourse) {
		this.streamCourse = streamCourse;
	}

	public Student(int id, String name, int rollNo, String streamCourse) {
		super();
		this.id = id;
		this.name = name;
		this.rollNo = rollNo;
		this.streamCourse = streamCourse;
	}

	public Student() {
		super();
	}

}
