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

<jsp:useBean id="userObj" class="com.atm.model.User"></jsp:useBean>
<jsp:setProperty property="pinNo" name="userObj"/>

PinNo Changed Successfully!! 

Please goto homepage.<br><br> <a href="homepage.jsp"> Homepage</a>

</body>
</html>