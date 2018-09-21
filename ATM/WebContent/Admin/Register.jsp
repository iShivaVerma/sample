<%@page import="com.atm.dao.DatabaseDaoImpl"%>
<%@page import="com.atm.dao.DAOOperations"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="addUser.jsp" method="post" required><br>
<center>User Name: <input type="text" name="username" required></center><br>
<%
DatabaseDaoImpl daoObj = new DatabaseDaoImpl();
String numberUser = daoObj.accountNumberGenerate();
int pinNumber = daoObj.pinGenerate();
%>
<center>Account Number: <input type="text" name="accountNo" value="<%= daoObj.accountNumberGenerate() %>" readonly required></center><br>
<center>Gender:<input type="text" name="gender" required></center><br>

  <center>Pin: <input type="number" name="pinNo" value="<%= pinNumber %>" readonly required></center> <br>
  <center>Address:  <input type="text" name="address" required></center> <br>
   <center>Phone number: <input type="number" name="phoneNo" required maxlength="10"></center><br>
  <center>Balance: <input ty"WebContent/Admin/css/style4.css"pe="number" name="balance" required></center> <br>
   <center>Status:  <input type="text" name="status" required></center><br><br>
   <center>Submit:<input type="submit" name="submit" value="submit" required></center><br>
</form>
</body>
</html>