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

<form:form action="/comments/addComment" method="post" modelAtrribute="comment">
Comment Id: <form:input type="text" path="commentId"/><br>
Comment : <form:input type="text" path="comment"/><br>
<input type="submit" value="Submit">
</form:form>

<!--  
<hr>
<form action="/showComment" method="post">
Comment Id: <input type="text" name="commentId"/><br>
Comment : <input type="text" name="comment"/><br>
<input type="submit" value="submit">
</form>
-->
<!--  
<hr>
<form action="/completeComment" method="post">
Comment Id: <input type="text" name="commentId"/><br>
Comment : <input type="text" name="comment"/><br>
<input type="submit" value="submit">
</form>
</body>
-->  
</html>