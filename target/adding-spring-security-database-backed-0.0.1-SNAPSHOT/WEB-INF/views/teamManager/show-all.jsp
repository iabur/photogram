<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Showing all manager</title>

</head>

<body>


    <table>
        <tr>
        <th>Team Name</th>
        <th>Manager Name</th>
        <th>Manager Email</th>
    </tr>
        <c:forEach items="${managers}"  var="manager">
            <tr>
                <td>${manager.team.teamName}</td>
                <td>${manager.managerName}</td>
                <td>${manager.managerEmail}</td>
                <td><a href="${pageContext.request.contextPath}/teamManager/edit?managerId=${manager.id}">Update</a></td>
                <td><a href="${pageContext.request.contextPath}/teamManager/delete?id=${manager.id}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>

</body>

</html>