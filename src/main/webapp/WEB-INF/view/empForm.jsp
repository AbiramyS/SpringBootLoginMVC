<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Registration Form</title>
</head>
<body>
<h1>Registration Form</h1>
<form:form action="save" method="post" modelAttribute="e">
EmployeeId: <form:input path= "empId"/><br>
FirstName: <form:input path="fname"/><br>
MiddleName: <form:input path="mname"/>><br>
LastName: <form:input path="lname"/><br>
Age: <form:input path="age"/><br>
University Name:<form:input path="uname"/><br>
Email: <form:input path="email"/><br>
Password: <form:input path="password"/><br>
<input type="submit" value="submit">
</form:form>

</body>
</html>