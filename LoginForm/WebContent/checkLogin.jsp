<%@page import="com.login.UserExceptionLogin"%>
<%@page import="com.login.DAOperation"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" errorPage="Error.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<% 
String username = request.getParameter("username");
String password = request.getParameter("password");

DAOperation dbDao = new DAOperation();
if(dbDao.isValid(username,password))
{
	System.out.print("valid");
	session.setAttribute("username", username);
	response.sendRedirect("Welcome.jsp");	
}
else
{
	System.out.print("invalid");
	throw new UserExceptionLogin();
}
%>
</body>
</html>