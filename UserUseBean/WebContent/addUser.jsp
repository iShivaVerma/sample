<%@page import="com.usebean.DAOOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<jsp:useBean id="user22" class="com.usebean.User"></jsp:useBean>
<jsp:setProperty property="*" name="user22"/>

<%
DAOOperations dbDao = new DAOOperations();
/*if(dbDao.isInserted(user22))
{
System.out.print("inserted in addUser");	
}
else
	System.out.print("not inserted in addUser");*/
	
	if(dbDao.isValid(user22.getName(), user22.getPassword()))
	{
		System.out.print("Valid in addUser");
	}
	else 
		System.out.print("inValid");
%>
</body>
</html>