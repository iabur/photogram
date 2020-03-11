<!-- GLOBAL HEADER -->
<jsp:include page="common/header.jsp"/>


<!-- COURSE COVER IMAGE -->
<img src="${pageContext.request.contextPath }/images/course_cover.jpg"
     height="500px" class="w-100"/>


<!-- MAIN CONTENT OF THE PAGE -->
<div class="container">

    <div class="row">

        <!-- HOMEWORK COLUMN-->
        <div class="col">
            <h3 class="p-3">Homework</h3>

            <div class="row">
                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <h4 class="card-title pb-3">Countries</h4>
                            <p class="card-text">
                                <a class="btn btn-success btn-lg btn-block"
                                   href="${pageContext.request.contextPath }/country/add"
                                   role="button">ADD</a> <a
                                    class="btn btn-primary btn-lg btn-block"
                                    href="${pageContext.request.contextPath }/country/show-all" role="button">SHOW
                                ALL</a>
                            </p>
                        </div>
                    </div>
                </div>





            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <h4 class="card-title pb-3">Team</h4>
                            <p class="card-text">
                                <a class="btn btn-success btn-lg btn-block"
                                   href="${pageContext.request.contextPath }/team/add"
                                   role="button">ADD</a> <a
                                    class="btn btn-primary btn-lg btn-block"
                                    href="${pageContext.request.contextPath }/team/show-all" role="button">SHOW
                                ALL</a>
                            </p>
                        </div>
                    </div>
                </div>




            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <h4 class="card-title pb-3">Manager</h4>
                            <p class="card-text">
                                <a class="btn btn-success btn-lg btn-block"
                                   href="${pageContext.request.contextPath }/teamManager/add"
                                   role="button">ADD</a> <a
                                    class="btn btn-primary btn-lg btn-block"
                                    href="${pageContext.request.contextPath }/teamManager/show-all" role="button">SHOW
                                ALL</a>
                            </p>
                        </div>
                    </div>
                </div>




            </div>
            <div class="row">
                <div class="col-sm-12">
                    <div class="card mb-2">
                        <div class="card-body">
                            <h4 class="card-title pb-3">Members</h4>
                            <p class="card-text">
                                <a class="btn btn-success btn-lg btn-block"
                                   href="${pageContext.request.contextPath }/member/add"
                                   role="button">ADD</a> <a
                                    class="btn btn-primary btn-lg btn-block"
                                    href="${pageContext.request.contextPath }/member/show-all" role="button">SHOW
                                ALL</a>
                            </p>
                        </div>
                    </div>
                </div>





            </div>

        </div>



    </div>

</div>


<!-- GLOBAL FOOTER -->
<jsp:include page="common/footer.jsp"/>




