
<html>
<head>
    <link href="https://fonts.googleapis.com/css?family=Indie+Flower|Overpass+Mono" rel="stylesheet">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/css/login.css">
</head>
<body>
<div id="wrapper_login">
    <div class="main-content">
        <div class="header">
            <img src="https://i.imgur.com/zqpwkLQ.png" />
        </div>
        <div class="l-part">
            <form action="${pageContext.request.contextPath}/login-processing" method="post">
            <input type="text" placeholder="Username" class="input-1" name="username" />
            <div class="overlap-text">
                <input type="password" placeholder="Password" class="input-2" name="password" />
            </div>
            <input type="submit" value="Log in" class="btn" />
            <form/>
        </div>
    </div>
    <div class="sub-content">
        <div class="s-part">
            Don't have an account?<a href="${pageContext.request.contextPath}/add/user">Sign up</a>
        </div>
    </div>
</div>
</body>
</html>
