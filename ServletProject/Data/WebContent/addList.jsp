<%@page import="model.MainClass"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user" class="model.User"></jsp:useBean>
<jsp:setProperty property="name" name="user"/>
<jsp:setProperty property="hobbies" name="user"/>

<%
	System.out.println(user.getName());
	
	String []list = new String[4];
	
	for(int i =0 ; i<list.length;i++)
	{
		System.out.println(%><% list[i] %><%);
	}
	
	
	
	System.out.println();
	
	MainClass mc = new MainClass();
	
	if(mc.insert(user))
	{
		out.print("Inserted");
	}
	
%>
</body>
</html>