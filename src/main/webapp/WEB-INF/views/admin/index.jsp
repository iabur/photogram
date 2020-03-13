<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Instagram Photos Feed With Bootstrap</title>
    <link rel="stylesheet" href="style.css" type="text/css" />
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.4.1/css/all.css" integrity="sha384-5sAR7xN1Nv6T6+dT2mhtzEpVJvfS3NScPQTrOxhwjIuvcA67KV2R5Jz6kr4abQsz" crossorigin="anonymous">

</head>
<body>
<nav class="navbar navbar-light sticky-top bg-light">
    <a class="navbar-brand" href="#"><i class="fab fa-instagram"></i> Instagram</a>
    <ul class="nav ">

        <li class="nav-item dropdown">
            <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false"><i class="fas fa-cogs"></i></a>
            <div class="dropdown-menu dropdown-menu-right">
                <a class="dropdown-item" href="${pageContext.request.contextPath}/profile">profile</a>
                <div class="dropdown-divider"></div>
                <a class="dropdown-item" href="${pageContext.request.contextPath}/logout">Log Out</a>
            </div>
        </li>

    </ul>
</nav>


<div style="margin: auto;
  width: 50%;
  border: 3px solid green;
  padding: 10px;">
<form:form action="${pageContext.request.contextPath}/createPost" modelAttribute="addPost" enctype="multipart/form-data">
    <form:input placeholder = "Create a new post"  path="caption" cssStyle="height: 100px; width: 100%;" />
    <input type="file" name="files" class="form-control" style="width: 100%;">
    <input type="submit" name="submit" value="submit">
</form:form>
</div>
<div class="container-fluid ">
    <!-- Nav pills -->
    <ul class="nav nav-pills justify-content-center mt-4" role="tablist">
        <li class="nav-item">
            <a class="nav-link" data-toggle="pill" href="#home"><i class="fa fa-square" aria-hidden="true"></i></a>
        </li>
        <li class="nav-item">
            <a class="nav-link" data-toggle="pill" href="#menu2"><i class="fa fa-th" aria-hidden="true"></i></a>
        </li>
    </ul>

    <!-- Tab panes -->
    <div class="tab-content">
        <div id="home" class="container-fluid tab-pane active "><br>
            <div class="row justify-content-center">
                <div class="">


 <c:forEach items="${allPost}" var="post">
                    <div class="card mx-auto custom-card" id="prova">
                        <div class="row post-header col-12 py-2 px-3">
                            <div class="col-6 float-left "><h4>${post.caption}</h4></div>
                            <div class="col-6 float-right text-right post-number"><h4>${post.postTime}</h4></div>
                        </div>



                        <img class="card-img" src="${pageContext.request.contextPath}${post.image}" alt="Card image cap">

                        <br>
                        <br>
                        <div class="row post-header px-3 pb-3">
                            <form:form action="${pageContext.request.contextPath}/addLike" modelAttribute="like">

                            <div style="color: red" class="col-1 float-left text-left"><i class="far fa-heart"></i></i></div>
                            </form:form>
                            <div class="col-10 float-left text-left">
                                    <%--Add a new comment--%>

                               <%-- <div class="search">
                                    <input id="comment_${post.id}" placeholder="Write a comment" type="text">
                                    <button onclick="addComment(${post.id},${currentUser.id})"><i class="fa fa-sms"></i>
                                    </button>
                                </div>--%>
                                            <%--add a comment using form--%>

                                        <form:form action="${pageContext.request.contextPath}/createComment" modelAttribute="newComment" cssStyle="width: 500px">
                                            <form:textarea path="commentText" placeholder = "add a comment" cssStyle="width: 300px"/>
                                            <form:input path="userId" value = "${currentUser.id}" hidden = "hidden"/>
                                            <form:input path="postId" value = "${post.id}" hidden = "hidden" />
                                            <input type="submit" value="post">
                                        </form:form>
                                        <%--end of adding comment using form--%>

                                    <%--end of add comment section--%>

                            </div>
                            <div class="col-1 float-right text-right"><i class="fa fa-ellipsis-v" aria-hidden="true"></i></div>
                            <%--showing all comment--%>
                                <%--show comment list--%>
                            <br><br>
                            <div class="text-left" id="comments_${post.id}">
                                <c:forEach items="${post.comments}" var="comment">
                                    <div class="media m-0">
                                        <div class="d-flex mr-3" style="width: 50px">
                                            <a  href=""><img class="img-fluid rounded-circle"
                                                            src="${pageContext.request.contextPath }${comment.user.photo}"
                                                            alt="User" ></a>
                                        </div>
                                        <div class="media-body">
                                            <small><span><i
                                                    class="icon ion-md-time"></i> ${comment.user.fullName}</span>
                                            </small>
                                            <p class="m-0">${comment.comment}</p>

                                        </div>
                                    </div>
                                </c:forEach>
                            </div>
                            <%--End of showing comments--%>

                        </div>
                    </div>
 </c:forEach>


                </div>
            </div>
        </div>

        <div id="menu2" class="container-fluid tab-pane fade"><br>
            <div class="row ">
                <div class="col-md-4 col-sm-6 px-1 my-1 ">
                    <img src="https://assets.breatheco.de/apis/img/images.php?blob&tags=bobdylan" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1 ">
                    <img src="https://assets.breatheco.de/apis/img/funny/kids.jpg" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1 ">
                    <img src="https://assets.breatheco.de/apis/img/happy/bucket.jpeg" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1 ">
                    <img src="https://assets.breatheco.de/apis/img/funny/rigoberto.jpg" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1">
                    <img src="https://assets.breatheco.de/apis/img/meme/borat.success.jpg" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1">
                    <img src="https://assets.breatheco.de/apis/img/meme/baby.success.jpg" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1">
                    <img src="https://assets.breatheco.de/apis/img/funny/scared-baby.jpg" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1">
                    <img src="https://assets.breatheco.de/apis/img/happy/happy-dog2.jpg" alt="Card image cap" width="100%" height="350px">
                </div>
                <div class="col-md-4 col-sm-6 px-1 my-1">
                    <img src="https://assets.breatheco.de/apis/img/happy/happy-dog.jpg" alt="Card image cap" width="100%" height="350px">
                </div>

            </div>
        </div>
    </div>
</div>
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
</body>
<script>


    function addComment(postId, userId) {

        var commentText = $('#comment_' + postId).val();
        var url = "${pageContext.request.contextPath}/api/v1/post/addcomment";

        debugger
        $.ajax({
            method: "POST",
            url: url,
            data: {postId: postId, userId: userId, commentText: commentText}
        }).done(function (response) {

            $('#comment_' + postId).val('');

            $('#comments_' + postId).append(" </hr> <div >\n" +
                "                <div class=\"media m-0\">\n" +
                "                 <div class=\"d-flex mr-3\">\n" +
                "                    <a href=\"\"><img class=\"img-fluid rounded-circle\"\n" +
                "                          src=\"${pageContext.request.contextPath }${user.avatar}\"\n" +
                "                     alt=\"User\"></a>\n" +
                "                </div>\n" +
                "\n" +
                "                <div class=\"media-body\">\n" +
                "                  <p class=\"m-0\">" + commentText + "</p>\n" +
                "                     <small><span><i class=\"icon ion-md-pin\"></i>${user.fullName}</span></small>\n" +
                "            </div>\n" +
                "            </div>\n" +
                "            </div>");

// end of ammend


            var totalCommentStr = document.getElementById("comment_count_"+postId).innerHTML;
            var totalComment = parseInt(totalCommentStr);
            totalComment++;
            document.getElementById("comment_count_"+postId).innerHTML = totalComment;


        }).fail(function () {

        });
    }

</script>

</html>
