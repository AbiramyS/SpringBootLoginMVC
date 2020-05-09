<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<a href="logout">Logout</a><br>
<a href="login">Logout</a><br>

<table border="2" width="50%" cellpadding="2">

<tr>
	<th> Post Id </th>
	<th> Post Date </th>
	<th> Post Title </th>
	<th> Post Body </th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<tr>
<c:forEach var="post" items="${postList}">
<td><c:out value="${post.postId}"></c:out></td>
<td><c:out value="${post.postCreated}"></c:out></td>
<td><c:out value="${post.postTitle}"></c:out></td>
<td><c:out value="${post.postBody}"></c:out></td>
<td><a href="postEdit/${post.postId}">Edit</a></td>  
<td><a href="postDelete/${post.postId}">Delete</a></td>
</c:forEach>
</tr>
</table>

</body>
</html>