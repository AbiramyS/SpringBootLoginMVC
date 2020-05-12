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
<c:forEach var="post" items="${postBody}">
<a href= "postTitle"><c:out value="${post.postTitle}"></c:out></a>
<c:out value="${post.postId}"></c:out>
<c:out value="${post.postCreated}"></c:out>
<c:out value="${post.postBody}"></c:out>
</c:forEach>
</body>
</html>