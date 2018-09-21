<%@page import="java.util.Iterator"%>
<%@page import="com.atm.model.User"%>
<%@page import="java.util.List"%>
<%@page import="com.atm.dao.DatabaseDaoImpl"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<%
	DatabaseDaoImpl dbObj = new DatabaseDaoImpl();
	List<User> userlist = dbObj.showAllUsers();
	Iterator itr = userlist.iterator();
	while(itr.hasNext())
	{
		User obj = (User)itr.next();
		%>
		
		Name : <%= obj.getUsername() %>
		AccountNo : <%= obj.getAccountNo() %>
		Balance : <%= obj.getBalance() %>
		Gender : <%= obj.getGender() %>
		Name : <%= obj.getAddress()%>
		Name : <%= obj.getStatus()%>
		Name : <%= obj.getPhoneNo()%>
		
		<%
	}
	
%>

</body>
</html>