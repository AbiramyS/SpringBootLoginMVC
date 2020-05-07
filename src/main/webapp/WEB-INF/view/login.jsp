<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Form</title>
</head>
<body>

<form:form action="save" method="post" modelAttribute="e">
Email: <form:input path="email"/><br>
Password: <form:input path="password"/><br>
<input type="submit" value="submit">

</form:form>

</body>
</html>