
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>edit team</title>

</head>

<body>



<h1>Update Team</h1>



<form:form action="${pageContext.request.contextPath }/team/edit" modelAttribute="teamDto">

    <label >Choose a Country:</label>
    <form:select path="countryId">
        <form:options items="${countries}" itemLabel="countryName"  itemValue="id"/>
    </form:select>
    <form:input path="teamId" value = "${id}" hidden = "hidden"/>
    <form:input path="teamName"/>

    <br>

    <input type="submit" name="submit" value="Add Team">

</form:form>



</body>

</html>