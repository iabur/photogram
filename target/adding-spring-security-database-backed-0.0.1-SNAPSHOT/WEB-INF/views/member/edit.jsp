
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

         pageEncoding="ISO-8859-1" %>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>

<html>

<head>

    <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
    <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>

    <meta charset="ISO-8859-1">

    <title>Update Member</title>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>

</head>

<body>



<h1>Add New Member</h1>



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

<form:form action="${pageContext.request.contextPath}/member/edit" modelAttribute="member">
    <table>
        <tr>
            <th>Member Name</th>
            <th>Member Email</th>
            <th>Date of Birth</th>
            <th>Role</th>
        </tr>
        <tr>

            <<form:input path="memberId" value = "${id}" hidden = "hidden"/>
            <td>
                <form:input path="memberName"/>
            </td>

            <td><form:input path="memberEmail"/></td>
            <td><form:input type="text" id="datepicker" path="dob"/></td>
            <td><form:input path="role"/></td>
        </tr>
    </table>
    <input type="submit" value="submit" name="Submit">
</form:form>


</body>

</html>