<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form action="/addComment" method="post">
Comment Id: <input type="text" name="commentId"/><br>
Comment : <input type="text" name="comment"/><br>
<input type="submit" value="submit">
</form>
<br>

<hr>
<form action="/showComment" method="post">
Comment Id: <input type="text" name="commentId"/><br>
Comment : <input type="text" name="comment"/><br>
<input type="submit" value="submit">
</form>

<hr>
<form action="/completeComment" method="post">
Comment Id: <input type="text" name="commentId"/><br>
Comment : <input type="text" name="comment"/><br>
<input type="submit" value="submit">
</form>
</body>
</html>