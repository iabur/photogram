<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="ISO-8859-1">
</head>
<body>

<h1>Resister as a new user</h1>

<form:form action="${pageContext.request.contextPath }/add/user"
           modelAttribute="user" >
  UserName: <form:input path="username" /> <br>
  PassWord: <form:input path="password"/>
  <input type="submit" name="submit" value="Submit">

</form:form>

</body>
</html>