<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/posts/addPost" method="POST">

PostId:<input type="text" name="postId"/><br>
postTitle:<input type="text" name ="postTitle"/><br>
PostBody: <input type="text" name="postBody"/>
<input type="submit" value="submit">

</form>
</body>
</html>