<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Showing all members</title>

</head>

<body>


    <table>
        <tr>
        <th>Team Name</th>
        <th>Member Name</th>
        <th>Date of Birth</th>
        <th>Age</th>
    </tr>
        <c:forEach items="${members}"  var="member">
            <tr>
                <td>${member.team.teamName}</td>
                <td>${member.memberName}</td>
                <td>${member.dob}</td>
                <td>${member.memberAge}</td>
                <td><a href="${pageContext.request.contextPath}/member/edit?id=${member.id}">Update</a></td>
                <td><a href="${pageContext.request.contextPath}/member/delete?id=${member.id}">Delete</a></td>
            </tr>
        </c:forEach>

    </table>

</body>

</html>