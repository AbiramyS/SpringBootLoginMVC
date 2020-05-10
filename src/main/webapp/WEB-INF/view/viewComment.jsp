<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Comment</title>
</head>
<body>
<a href="comment">Add New Comment</a> 
<a href="logout">Logout</a> 

<table border="2" width="50%">
<tr>
	<th>Comment Id</th>
	<th>Comment Date</th>
	<th>Comment</th>
	<th>Edit</th>
	<th>Delete</th>
</tr>
<c:forEach var="comment" items="${commentList}"> 
<tr>
<!-- spring uses internally Reflection Api if the method or variables in the private we can access it outside the class -->
<td><c:out value="${comment.commentId}"></c:out></td><!-- using expression language to get the values -->
<td><c:out value="${comment.commentDate}"></c:out></td>
<td><c:out value="${comment.comment}"></c:out></td>
<td><a href="editComment?id=${comment.commentId}">Edit</a></td>  
<td><a href="deleteComment?id=${comment.commentId}">Delete</a></td>  
</tr>
</c:forEach>
</table>
<br> 
   
</table>

</body>
</html>