<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title><dec:title default="Trang chủ" /></title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <%--css--%>
    <link href="https://fonts.googleapis.com/css?family=Muli:300,400,700|Playfair+Display:400,700,900" rel="stylesheet">

    <link href="<c:url value='/template/web/fonts/icomoon/style.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/bootstrap.min.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/magnific-popup.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/jquery-ui.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/owl.carousel.min.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/owl.theme.default.min.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/bootstrap-datepicker.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/fonts/flaticon/font/flaticon.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/aos.css' />" rel="stylesheet" type="text/css" media="all">
    <link href="<c:url value='/template/web/css/style.css' />" rel="stylesheet" type="text/css" media="all">

</head>
<body>
<div class="site-wrap">

<div class="site-mobile-menu">
    <div class="site-mobile-menu-header">
        <div class="site-mobile-menu-close mt-3">
            <span class="icon-close2 js-menu-toggle"></span>
        </div>
    </div>
    <div class="site-mobile-menu-body"></div>
</div>
<%--header--%>
    <%@include file="/common/web/header.jsp"%>
<%--header--%>

<%--body--%>
    <dec:body/>
<%--body--%>

<%--footer--%>
    <%@include file="/common/web/footer.jsp"%>
<%--footer--%>
</div>

<script type="text/javascript" src="<c:url value='/template/web/js/jquery-3.3.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/jquery-migrate-3.0.1.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/jquery-ui.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/popper.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/bootstrap.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/owl.carousel.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/jquery.stellar.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/jquery.countdown.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/jquery.magnific-popup.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/bootstrap-datepicker.min.js' />"></script>
<script type="text/javascript" src="<c:url value='/template/web/js/aos.js' />"></script>

<script type="text/javascript" src="<c:url value='/template/web/js/main.js' />"></script>

</body>
</html>

