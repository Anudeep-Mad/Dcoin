<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Transactions</title>
</head>
<body>
<form:form action="upload" method="post" modelAttribute="transactions">
<table>
	<tr>
		<td>From	: </td>
		<td><form:input type="text" path="from_name"/><br></br></td>
	</tr>
	<tr>
		<td>To   :</td>
		<td> <form:input type="text" path="to_name"/><br></br></td>
	</tr>
	<tr>
		<td>Amount   :</td>
		<td> <form:input type="text" path="amount"/><br></td>
	</tr>
	<tr>
		<td>   :</td>
		<td> <input type = "submit" value = "Submit"/><br></td>
	</tr>
	
</table>
</form:form>
<form:form action="view" >
	<input type="submit" value = "View Transactions"/>
</form:form>
</body>
</html>