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
    
  
        <h1>Edit Employee</h1>  
       <form:form method="POST" action="/editsave">    
        <table >    
        <tr>  
        <td></td>    
         <td><form:hidden  path="id" /></td>  
         </tr>   
         <tr>    
          <td>FirstName : </td>   
          <td><form:input path="fname"  /></td>  
         </tr>    
         <tr>    
          <td>MiddleName :</td>    
          <td><form:input path="mname" /></td>  
         </tr>   
         <tr>    
          <td>LastName :</td>    
          <td><form:input path="lname" /></td>  
         </tr>  
          <tr>    
          <td>Age :</td>    
          <td><form:input path="age" /></td>  
         </tr>  
          <tr>    
          <td>University Name :</td>    
          <td><form:input path="uname" /></td>  
         </tr>     
         <tr>    
          <td> </td>    
          <td><input type="submit" value="Edit Save" /></td>    
         </tr>    
        </table>    
       </form:form> 
</body>
</html>