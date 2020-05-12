<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<<<<<<< HEAD
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
=======
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

>>>>>>> login-work
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<<<<<<< HEAD
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
=======
<title>Insert title here</title>
<style type="text/css">
	.error{
	  collor:red;
	  }
</style>
</head>
<body>


<!-- we can also mention the all the errors with out indicating seperatley on the top of the form -->
<!-- form:errors path= "e.*"-->
<form:form action="/employees/empForm" method="post" modelAttribute="e">

EmployeeId:<form:input path="empId" type="text" />
			<!--<spring:message code="label.empId"/>-->
			<form:errors path="empId" cssClass="error"/><br>
FirstName: <form:input path="fname" type="text" />
			<!--<spring:message code="label.fname"/>-->
			<form:errors path="fname" cssClass="error"/><br>
MiddleName: <form:input path="mname" type="text" />
			<!--<spring:message code="label.mname"/>-->
			<form:errors path="mname" cssClass="error"/><br>
LastName: <form:input type="text" path="lname" />
			<!--<spring:message code="label.lname"/>-->
			<form:errors path="lname" cssClass="error"/><br>
Age: <form:input type="text" path="age" />
	<!--<spring:message code="label.age"/>-->
	<form:errors path="age" cssClass="error"/><br>
University Name: <form:input type="text" path="uname" />
				<!--<spring:message code="label.uname"/>-->
				<form:errors path="uname" cssClass="error"/><br>
Email: <form:input type="email" path="email" />
		<!--<spring:message code="label.email"/>-->
		<form:errors path="email" cssClass="error"/><br>
Password: <form:input type="password" path="password" />
			<!--<spring:message code="label.password"/>-->
		   <form:errors path="password" cssClass="error"/><br>
>>>>>>> login-work
<input type="submit" value="submit">
</form:form>

</body>
</html>