<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Add New Country</title>
</head>
<body>
<table>
    <tr>
        <th>ID</th>
        <th>Country Name</th>
    </tr>
    <c:forEach items="${countries }" var="country">
        <tr>
            <th>${ country.id }</th>
            <th><img src="${pageContext.request.contextPath}${country.logo}" alt=""></th>
            <td><a href="${pageContext.request.contextPath}/country/edit?id=${country.id}">Update</a></td>
            <td><a href="${pageContext.request.contextPath}/country/delete?id=${country.id}">Delete</a></td>
        </tr>
    </c:forEach>
</table>
</body>
</html>