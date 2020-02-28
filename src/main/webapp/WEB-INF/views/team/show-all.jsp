<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Showing all Teams</title>

</head>

<body>

<table>

    <tr>

        <th>Country Name</th>
        <th>Team Name</th>


    </tr>


    <c:forEach items="${teams}"  var="team">
        <tr>
            <td>${team.country.countryName}</td>
            <td>${team.teamName}</td>
            <td><a href="${pageContext.request.contextPath}/team/edit?id=${team.id}">Update</a></td>
            <td><a href="${pageContext.request.contextPath}/team/delete?id=${team.id}">Delete</a></td>
        </tr>
    </c:forEach>

</table>

</body>

</html>