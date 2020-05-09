<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Log In</title>
</head>
<body>
<form:form action="/employees/login" method="post" modelAttribute="loginModel">
Email: <form:input type="email" path="email" /><br>
Password: <form:input type="password" path="password" /><br>
<input type="submit" value="submit">
</form:form>
</body>
</html>