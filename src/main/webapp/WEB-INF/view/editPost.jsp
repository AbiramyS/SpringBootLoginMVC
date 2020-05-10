<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%> 
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form action="/posts/editPost" method="POST" modelAttribute="post">

PostId:<form:input path="postId"  type="text" disabled="disabled" value="${post.postId}"/><br>
postTitle:<form:input path ="postTitle" type="text"  value="${post.postTitle}"/><br>
PostBody: <form:input path="postBody" type="text"  value="${post.postBody}"/>
<input type="submit" value="Submit">

</form:form>
</body>
</html>