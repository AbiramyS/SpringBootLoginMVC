<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="empForm" method="post" modelAttribute="e">

EmployeeId: <form:input path="empId" type="text" /><br>
FirstName: <form:input path="fname" type="text" /><br>
MiddleName: <form:input path="mname" type="text" /><br>
LastName: <form:input type="text" path="lname" /><br>
Age: <form:input type="text" path="age" /><br>
University Name: <form:input type="text" path="uname" /><br>
Email: <form:input type="email" path="email" /><br>
Password: <form:input type="password" path="password" /><br>
<input type="submit" value="submit">



</form:form>

</body>
</html>