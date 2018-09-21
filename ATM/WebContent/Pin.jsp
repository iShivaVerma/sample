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
<%


%>
	<form action="checkPin" method="post">
	Old pin number: <input type="number" name="pin" placeholder="********"  required maxlength="4"><br>
	
	Enter New Pin Number <input type="number" name="pinNo" placeholder ="********"  required maxlength="4"> <br>
	
	Enter Pin Again <input type="number" name="newPinAgain" placeholder ="********"  required maxlength="4"> <br><br>
	
	Submit: <input type="submit" value="submit">
	</form>
</body>
</html>