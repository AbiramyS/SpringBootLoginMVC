<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>    
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1>Employee List</h1>

<table border="2" width="70%" cellpadding="2">
<tr>
	<th>Employee Id</th>
	<th>FirstName</th>
	<th>MiddleName</th>
	<th>LastName</th>
	<th>Age</th>
	<th>UniversityName</th>
	<th>Edit</th>
	<th>Delete</th>

</tr>
<c:forEach var="e" items="${list}"> 
<tr>
<!-- spring uses internally Reflection Api if the method or variables in the private we can access it outside the class -->
<td><c:out value="${e.empId}"></c:out></td><!-- using expression language to get the values -->
<td><c:out value="${e.fname}"></c:out></td>
<td><c:out value="${e.mname}"></c:out></td>
<td><c:out value="${e.lname}"></c:out></td>
<td><c:out value="${e.age}"></c:out></td>
<td><c:out value="${e.uname}"></c:out></td>
<td><a href="editemp/${e.empId}">Edit</a></td>  
<td><a href="deleteemp/${e.empId}">Delete</a></td>  
</tr>
</c:forEach>
</table>
<br> 
   <a href="empform">Add New Employee</a>  
</body>
</html>