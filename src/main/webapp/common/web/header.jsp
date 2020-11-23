<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<header class="site-navbar" role="banner">
    <div class="container-fluid">
        <div class="row align-items-center">

            <div class="col-12 search-form-wrap js-search-form">
                <form method="get" action="#">
                    <input type="text" id="s" class="form-control" placeholder="Search...">
                    <button class="search-btn" type="submit"><span class="icon-search"></span></button>
                </form>
            </div>

            <div class="col-4 site-logo">
                <a href="<c:url value="/trang-chu"/> " class="text-black h2 mb-0">Người nổi tiếng</a>
            </div>

            <div class="col-8 text-right">
                <nav class="site-navigation" role="navigation">
                    <ul class="site-menu js-clone-nav mr-auto d-none d-lg-block mb-0">
                        <li><a href="<c:url value='/trang-chu'/>">Trang chủ</a></li>
                        <li><a href="category.html">Chính trị</a></li>
                        <li><a href="category.html">Công nghệ</a></li>
                        <li><a href="category.html">Giải trí</a></li>
                        <li><a href="category.html">Du lịch</a></li>
                        <li class="d-none d-lg-inline-block"><a href="#" class="js-search-toggle"><span class="icon-search"></span></a></li>
                        <c:if test="${not empty USERMODEL}">
                            <li class="nav-item">
                                <a data-toggle="tooltip" href='<c:url value="/thoat?action=logout"/>' title="Thoat" <%--class="dropdown-toggle"--%>>
                                    <figure class="author-figure mb-0 mr-3 d-inline-block"><img src="<c:url value="${USERMODEL.avatar}"/>" alt="${USERMODEL.fullName}" class="img-fluid" width="32px"></figure>
                                </a>
                            </li>
                           <%-- <li class="nav-item">
                                <a class="nav-link" href='<c:url value="/thoat?action=logout"/>'>Thoát</a>
                            </li>--%>
                        </c:if>
                        <c:if test="${empty USERMODEL}">
                            <li class="nav-item">
                                <a class="nav-link" href='<c:url value="/dang-nhap?action=login"/>'>Đăng nhập</a>
                            </li>
                        </c:if>

                    </ul>
                </nav>
                <a href="#" class="site-menu-toggle js-menu-toggle text-black d-inline-block d-lg-none"><span class="icon-menu h3"></span></a></div>
        </div>

    </div>
</header>