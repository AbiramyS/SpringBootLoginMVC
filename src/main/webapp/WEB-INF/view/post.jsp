<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
     <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Post</title>
</head>
<body>

<form:form action="/posts/addPost" method="POST" modelAttribute="post">

PostId:<form:input path="postId"  type="text" disabled="disabled"/><br>
postTitle:<form:input path ="postTitle" type="text"/><br>
PostBody: <form:input path="postBody" type="text"/>
<input type="submit" value="Submit"/>

</form:form>
</body>
</html>