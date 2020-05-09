<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
	.error{
	  collor:red;
	  }
</style>
</head>
<body>


<form:form action="/employees/empForm" method="post" modelAttribute="e">

EmployeeId:<form:input path="empId" type="text" />
			<form:errors path="empId" cssClass="error"/><br>
FirstName: <form:input path="fname" type="text" />
			<form:errors path="fname" cssClass="error"/><br>
MiddleName: <form:input path="mname" type="text" />
			<form:errors path="mname" cssClass="error"/><br>
LastName: <form:input type="text" path="lname" />
			<form:errors path="lname" cssClass="error"/><br>
Age: <form:input type="text" path="age" />
	<form:errors path="age" cssClass="error"/><br>
University Name: <form:input type="text" path="uname" />
				<form:errors path="uname" cssClass="error"/><br>
Email: <form:input type="email" path="email" />
		<form:errors path="email" cssClass="error"/><br>
Password: <form:input type="password" path="password" />
		<form:errors path="password" cssClass="error"/><br>
<input type="submit" value="submit">
</form:form>

</body>
</html>