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

<form:form action="/comments/editComment" method="post" modelAtrribute="comment">
Comment Id: <form:input type="text" path="commentId" disabled="disabled" value="${comment.commentId}"/><br>
Comment : <form:input type="text" path="comment" value="${comment.comment}"/><br>
<input type="submit" value="Submit">
</form:form>
</body>
</html>