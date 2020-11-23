<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@include file="/common/taglib.jsp" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Trang chủ</title>
</head>
<body>
    <div class="site-section bg-light">
        <div class="container">
          <div class="row align-items-stretch retro-layout-2">
            <div class="col-md-4">
              <a href="single.html" class="h-entry mb-30 v-height gradient" style="background-image: url('<c:url value="/template/web/images/img_1.jpg"/>');">
                
                <div class="text">
                  <h2>The AI magically removes moving objects from videos.</h2>
                  <span class="date">July 19, 2019</span>
                </div>
              </a>
              <a href="single.html" class="h-entry v-height gradient" style="background-image: url('<c:url value="/template/web/images/img_2.jpg"/>');">
                
                <div class="text">
                  <h2>The AI magically removes moving objects from videos.</h2>
                  <span class="date">July 19, 2019</span>
                </div>
              </a>
            </div>
            <div class="col-md-4">
              <a href="single.html" class="h-entry img-5 h-100 gradient" style="background-image: url('<c:url value="/template/web/images/img_v_1.jpg"/>');">
                
                <div class="text">
                  <div class="post-categories mb-3">
                    <span class="post-category bg-danger">Travel</span>
                    <span class="post-category bg-primary">Food</span>
                  </div>
                  <h2>The AI magically removes moving objects from videos.</h2>
                  <span class="date">July 19, 2019</span>
                </div>
              </a>
            </div>
            <div class="col-md-4">
              <a href="single.html" class="h-entry mb-30 v-height gradient" style="background-image: url('<c:url value="/template/web/images/img_3.jpg"/>');">
                
                <div class="text">
                  <h2>The 20 Biggest Fintech Companies In America 2019</h2>
                  <span class="date">July 19, 2019</span>
                </div>
              </a>
              <a href="single.html" class="h-entry v-height gradient" style="background-image: url('<c:url value="/template/web/images/img_4.jpg"/>');">
                
                <div class="text">
                  <h2>The 20 Biggest Fintech Companies In America 2019</h2>
                  <span class="date">July 19, 2019</span>
                </div>
              </a>
            </div>
          </div>
        </div>
      </div>
  
      <div class="site-section">
        <form action="<c:url value= '/trang-chu' />" id="formRecentPosts" method="get">
          <div class="container">
            <div class="row mb-5">
              <div class="col-12">
                <h2>Recent Posts</h2>
              </div>
            </div>
            <div class="row">

              <c:forEach var="item" items="${model.listResult}">
                <div class="col-lg-4 mb-4">
                  <div class="entry2">
                    <a id="click_${item.id}" href="<c:url value='/post?id=${item.id}'/>"><img src="<c:url value="${item.thumbnail}"/>" alt="Image" class="img-fluid rounded" width="800px"></a>
                    <div class="excerpt">
                      <span class="post-category text-white bg-success mb-3">
                        <c:forEach var="category" items="${categories}">
                          <c:if test="${category.id == item.categoryid}">
                            ${category.name}
                          </c:if>
                        </c:forEach>
                      </span>

                      <h2><a href="<c:url value='/post?id=${item.id}'/>">${item.title}</a></h2>
                      <div class="post-meta align-items-center text-left clearfix">
                        <c:forEach var="author" items="${users}">
                          <c:if test="${author.fullName == item.createdby}">
                            <figure class="author-figure mb-0 mr-3 float-left"><img src="${author.avatar}" alt="Image" class="img-fluid"></figure>
                          </c:if>
                        </c:forEach>

                        <span class="d-inline-block mt-1">By <a href="#">${item.createdby}</a></span>
                        <span>&nbsp;-&nbsp; <fmt:formatDate type = "date" value = "${item.createddate}" /> - <a href="#">${item.view}</a> views</span>
                      </div>

                      <p>${item.shortdescription}</p>
                      <p><a href="<c:url value='/post?id=${item.id}'/>">Read More</a></p>
                    </div>
                  </div>
                </div>
              </c:forEach>
            </div>
            <input type="hidden" value="" id="page" name="page"/>
            <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
            <input type="hidden" value="" id="sortName" name="sortName"/>
            <input type="hidden" value="" id="sortBy" name="sortBy"/>
            <input type="hidden" value="" id="type" name="type"/>
            <div class="row text-center pt-5 border-top">
              <div class="col-md-12">
                <ul class="custom-pagination" id="pagination"></ul>
              </div>
            </div>
          </div>
        </form>
      </div>


  
      <div class="site-section bg-light">
        <div class="container">
  
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

    <script>
      var totalPages = ${model.totalPage};
      var currentPage = ${model.page};
      var limit = 10;
      $(function () {
        window.pagObj = $('#pagination').twbsPagination({
          totalPages: totalPages,
          visiblePages: 10,
          startPage: currentPage,
          onPageClick: function (event, page) {
            if (currentPage != page) {
              $('#maxPageItem').val(limit);
              $('#page').val(page);
              $('#sortName').val('title');
              $('#sortBy').val('desc');
              $('#type').val('list');
              $('#formSubmit').submit();
            }
          }
        });
      });

    </script>
</body>
</html>