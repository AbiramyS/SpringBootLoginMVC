<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Post</title>
</head>
<body>

<a href="post">Add New Post</a> 
<a href="logout">Logout</a> 

<table border="2" width="50%">
<tr>
	<th>Post Id</th>
	<th>Post Date</th>
	<th>Post Title</th>
	<th>Post Body</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach var="post" items="${postList}"> 
<tr>
<!-- spring uses internally Reflection Api if the method or variables in the private we can access it outside the class -->
<td><c:out value="${post.postId}"></c:out></td><!-- using expression language to get the values -->
<td><c:out value="${post.postCreated}"></c:out></td>
<td><c:out value="${post.postTitle}"></c:out></td>
<td><c:out value="${post.postBody}"></c:out></td>
<td><a href="editPost?id=${post.postId}">Edit</a></td>  
<td><a href="deletePost?id=${post.postId}">Delete</a></td>  
</tr>
</c:forEach>
</table>
<br> 

</table>

</body>
</html>