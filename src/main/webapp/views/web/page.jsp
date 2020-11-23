<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>${model.title}</title>

</head>
<body>
<div class="site-cover site-cover-sm same-height overlay single-page" style="background-image: url('<c:url value="${model.headimg}"/>');">
    <div class="container">
        <div class="row same-height justify-content-center">
            <div class="col-md-12 col-lg-10">
                <div class="post-entry text-center">
                    <span class="post-category text-white bg-success mb-3">
                        <c:forEach var="category" items="${categories}">
                            <c:if test="${category.id == model.categoryid}">
                                ${category.name}
                            </c:if>
                        </c:forEach>
                    </span>
                    <h1 class="mb-4"><a href="#">${model.title}</a></h1>
                    <div class="post-meta align-items-center text-center">
                        <c:forEach var="author" items="${users}">
                            <c:if test="${author.fullName == model.createdby}">
                                <figure class="author-figure mb-0 mr-3 d-inline-block"><img src="${author.avatar}" alt="Image" class="img-fluid"></figure>
                            </c:if>
                        </c:forEach>

                        <span class="d-inline-block mt-1">By ${model.createdby}</span>
                        <span>&nbsp;-&nbsp; <fmt:formatDate type = "date" value = "${model.createddate}" /> - ${model.view} views</span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

<section class="site-section py-lg">
    <div class="container">

        <div class="row blog-entries element-animate">

            <div class="col-md-12 col-lg-8 main-content">

                <div class="post-content-body">
                    ${model.content}
                </div>

                <div class="pt-5">
                    <p>Categories:  <a href="#">Food</a>, <a href="#">Travel</a>  Tags: <a href="#">#manila</a>, <a href="#">#asia</a></p>
                </div>

                    <%--comment--%>
                    <%@include file="/common/web/comment.jsp"%>
                    <%--comment--%>
            </div>

                <!-- END main-content -->
                <%--sidebar--%>
            <div class="col-md-12 col-lg-4 sidebar">
                <div class="sidebar-box search-form-wrap">
                    <form action="#" class="search-form">
                        <div class="form-group">
                            <span class="icon fa fa-search"></span>
                            <input type="text" class="form-control" id="s" placeholder="Type a keyword and hit enter">
                        </div>
                    </form>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <div class="bio text-center">
                        <c:forEach var="celebritySet" items="${celebrities}">
                            <c:if test="${celebritySet.id == model.celebrityid}">
                                <c:set var="celebrity" value="${celebritySet}"></c:set>
                            </c:if>
                        </c:forEach>
                        <img src="<c:url value='${celebrity.avatar}'/>" alt="${celebrity.name}" class="img-fluid mb-5">
                        <div class="bio-body">
                            <h2>${celebrity.name}</h2>
                            <p>Ngày sinh: ${celebrity.dob}</p>
                            <p>Nơi sinh: ${celebrity.city}, ${celebrity.nationality}</p>
                            <c:if test=" ${not empty celebrity.profile}"><p>Profile: ${profile}</p></c:if>
                            <p><a href="#" class="btn btn-primary btn-sm rounded px-4 py-2">Yêu thích</a></p>
                            <p class="social">
                                <a href="#" class="p-2"><span class="fa fa-facebook"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-twitter"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-instagram"></span></a>
                                <a href="#" class="p-2"><span class="fa fa-youtube-play"></span></a>
                            </p>
                        </div>
                    </div>
                </div>
                <!-- END sidebar-box -->
                <div class="sidebar-box">
                    <h3 class="heading">Popular Posts</h3>
                    <div class="post-entry-sidebar">
                        <ul>
                            <c:forEach var="popular" items="${popularPosts}">
                                <li>
                                    <a href="<c:url value='/post?id=${popular.id}'/>">
                                        <img src="<c:url value="${popular.thumbnail}"/>" alt="${popular.title}" class="mr-4">
                                        <div class="text">
                                            <h4>${popular.title}</h4>
                                            <div class="post-meta">
                                                <span class="mr-2"><fmt:formatDate type = "date" value = "${model.createddate}" /> </span>
                                            </div>
                                        </div>
                                    </a>
                                </li>
                            </c:forEach>
                        </ul>
                    </div>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Categories</h3>
                    <ul class="categories">
                        <c:forEach var="category" items="${categories}">
                            <li><a href="#">${category.name} <span>(${category.amount})</span></a></li>
                        </c:forEach>
                    </ul>
                </div>
                <!-- END sidebar-box -->

                <div class="sidebar-box">
                    <h3 class="heading">Tags</h3>
                    <ul class="tags">
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                        <li><a href="#">Travel</a></li>
                        <li><a href="#">Adventure</a></li>
                        <li><a href="#">Food</a></li>
                        <li><a href="#">Lifestyle</a></li>
                        <li><a href="#">Business</a></li>
                        <li><a href="#">Freelancing</a></li>
                    </ul>
                </div>
            </div>
                <!-- END sidebar -->

        </div>
    </div>
</section>

<div class="site-section bg-light">
    <div class="container">

        <div class="row mb-5">
            <div class="col-12">
                <h2>More Related Posts</h2>
            </div>
        </div>

        <div class="row align-items-stretch retro-layout">

            <div class="col-md-5 order-md-2">
                <a href="single.html" class="hentry img-1 h-100 gradient" style="background-image: url('<c:url value="/template/web/images/img_4.jpg"/>');">
                    <span class="post-category text-white bg-danger">Travel</span>
                    <div class="text">
                        <h2>The 20 Biggest Fintech Companies In America 2019</h2>
                        <span>February 12, 2019</span>
                    </div>
                </a>
            </div>

            <div class="col-md-7">

                <a href="single.html" class="hentry img-2 v-height mb30 gradient" style="background-image: url('<c:url value="/template/web/images/img_1.jpg"/>');">
                    <span class="post-category text-white bg-success">Nature</span>
                    <div class="text text-sm">
                        <h2>The 20 Biggest Fintech Companies In America 2019</h2>
                        <span>February 12, 2019</span>
                    </div>
                </a>

                <div class="two-col d-block d-md-flex">
                    <a href="single.html" class="hentry v-height img-2 gradient" style="background-image: url('<c:url value="/template/web/images/img_2.jpg"/>');">
                        <span class="post-category text-white bg-primary">Sports</span>
                        <div class="text text-sm">
                            <h2>The 20 Biggest Fintech Companies In America 2019</h2>
                            <span>February 12, 2019</span>
                        </div>
                    </a>
                    <a href="single.html" class="hentry v-height img-2 ml-auto gradient" style="background-image: url('<c:url value="/template/web/images/img_3.jpg"/>');">
                        <span class="post-category text-white bg-warning">Lifestyle</span>
                        <div class="text text-sm">
                            <h2>The 20 Biggest Fintech Companies In America 2019</h2>
                            <span>February 12, 2019</span>
                        </div>
                    </a>
                </div>

            </div>
        </div>

    </div>
</div>


<div class="site-section bg-lightx">
    <div class="container">
        <div class="row justify-content-center text-center">
            <div class="col-md-5">
                <div class="subscribe-1 ">
                    <h2>Subscribe to our newsletter</h2>
                    <p class="mb-5">Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sit nesciunt error illum a explicabo, ipsam nostrum.</p>
                    <form action="#" class="d-flex">
                        <input type="text" class="form-control" placeholder="Enter your email address">
                        <input type="submit" class="btn btn-primary" value="Subscribe">
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>