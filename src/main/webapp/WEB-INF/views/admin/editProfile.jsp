<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Indie+Flower|Overpass+Mono" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div id="wrapper">
    <div class="main-content_signup">
        <div class="header">
            <img src="https://i.imgur.com/zqpwkLQ.png" />
        </div>
        <div class="l-part">
            <h5>Edit your profile</h5>
            <form:form action="${pageContext.request.contextPath}/editProfile" modelAttribute="userDto" enctype="multipart/form-data">
                <form:input path="Email" type="text" placeholder="Email" class="input-1" />
                <form:input path="FullName" type="text" placeholder="Full Name" class="input-1" />
                <form:input path="phone" type="text" placeholder="Phone no" class="input-1" />
                <form:input path="occupation" type="text" placeholder="Occupation" class="input-1" />
                <form:input path="nationality" type="text" placeholder="Nationality" class="input-1" />
                <form:input path="id" value = "${userId}" hidden = "hidden"/>
                <div class="overlap-text">
                    <span style="color: gray">Profile Picture</span>
                    <input placeholder="photo" type="file" name="file" value="photo" class="input-1">
                </div>
                <div class="input-1">
                    <label for="about"></label>
                    <form:textarea path="about" class="form-control" rows="5" id="about" placeholder = "about yourself" cssStyle="width: 220px"/>
                </div>
                <input type="submit" value="Submit" class="btn" />
            </form:form>
        </div>
    </div>
    <div class="sub-content">

    </div>
</div>
</body>
</html>
