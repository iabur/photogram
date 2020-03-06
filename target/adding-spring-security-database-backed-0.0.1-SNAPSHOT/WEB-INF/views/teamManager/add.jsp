
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<head>

    <meta charset="ISO-8859-1">

    <title>Add New manager</title>


</head>

<body>



<h1>Add New Manager</h1>



<%--
<form:form action="${pageContext.request.contextPath }/team/add" modelAttribute="team">

    <label >Choose a Country:</label>
    <form:select path="countryId">
        <form:options items="${countries}" itemLabel="countryName"  itemValue="id"/>
    </form:select>
    &lt;%&ndash;<select id="Country">
    <c:forEach items="${countries}" var="country">
        <option value="${country.id}">${country.countryName}</option>
    </c:forEach>
    </select>&ndash;%&gt;
    <form:input path="teamName"/>

    <br>

    <input type="submit" name="submit" value="Add Team">

</form:form>
--%>

<form:form action="${pageContext.request.contextPath}/teamManager/add" modelAttribute="member">
<table>
    <tr>
        <th>Teams</th>
        <th>Manager Name</th>
        <th>Member Email</th>
    </tr>
    <tr>
        <td>
    <form:select path="teamId">
        <form:options items="${teams}" itemLabel="teamName"  itemValue="id"/>
    </form:select>
</td>
    <td>
    <form:input path="memberName"/>
    </td>

    <td><form:input path="memberEmail"/></td>

    </tr>
</table>
    <input type="submit" value="submit" name="Submit">
</form:form>


</body>

</html>