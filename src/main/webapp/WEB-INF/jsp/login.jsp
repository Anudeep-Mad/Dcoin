<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Sign Up To DCOIN</title>
  
</head>
<body>
<form:form action="loginuser" method="post" modelAttribute="login">
<table>
	<tr>
		<td>UserName	: </td>
		<td><form:input type="text" name ="username" path="username" />
		<br></br></td>
	</tr>
	<tr>
		<td>Password :</td>
		<td> <form:input type="password" name="password" path="password"/><br></td>
	</tr>
	<tr>
		<td>   :</td>
		<td> <input type = "submit" value = "Log In"/><br></td>
	</tr>
</table>
</form:form>
</body>
</html>