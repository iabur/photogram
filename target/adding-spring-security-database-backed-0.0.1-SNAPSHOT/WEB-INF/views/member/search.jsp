<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Spring By Practical Examples</title>
    <link rel="stylesheet"
          href="/css/bootstrap.min.css"/>
</head>
<body>

<html>
<head>
    <title>Title</title>
</head>
<body>
<div class="form-group">
    <input type="text" class="form-control member-query"
           placeholder="Member Name">
</div>
<div
        class="btn btn-primary member-query-submit btn-lg btn-block">SEARCH</div>

<br>
<table class="table">
    <thead>
    <tr>
        <th scope="col">Name</th>
        <th scope="col">Email</th>
        <th scope="col">Age</th>
        <th scope="col">Team</th>
    </tr>
    </thead>
    <tbody class="search-result">

    </tbody>
</table>
<script src="/js/jquery.js"></script>
<script src="/js/bootstrap.min.js"></script>
</body>
</html>
<script>
    $(document).ready(function(){
        $(".member-query-submit").click(function(){
            var queryString = $(".member-query").val();
            //  /api/v1/course/search | /course/search
            $.get("/api/v1/member/search?query="+queryString, function( data ) {
                var searchResContainer = $(".search-result");
                searchResContainer.html("");
                //data = JSON.parse(data);
                if (data.length > 0) {
                    debugger;
                    $.each(data, function( index, value ) {
                        var tblRow = "<tr>\n" +
                            "        <td class='member-name'>"+ value.memberName +"</td>\n" +
                            "        <td class='member-email'>"+ value.memberEmail +"</td>\n" +
                            "        <td class='member-age'>"+ value.memberAge+"</td>\n" +
                            "        <td class='member-team'>"+ value.team.teamName+"</td>\n" +
                            "    </tr>";
                        searchResContainer.append(tblRow);
                    });
                } else {
                    searchResContainer.html("<th >Nothing found!</th>");
                }
            });
        });
    });
</script>