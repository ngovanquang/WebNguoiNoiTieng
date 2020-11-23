<%@ taglib prefix="C" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="/common/taglib.jsp"%>
<c:url var="APIurl" value="/api-admin-users"/>
<c:url var ="UserURL" value="/admin-users"/>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Danh sách người dùng</title>
</head>

<body>
<div class="main-content">
    <form action="<c:url value='/admin-users'/>" id="formSubmit" method="get">
        <div class="main-content-inner">
            <div class="breadcrumbs ace-save-state" id="breadcrumbs">
                <ul class="breadcrumb">
                    <li>
                        <i class="ace-icon fa fa-home home-icon"></i>
                        <a href="#">Trang chủ</a>
                    </li>
                </ul>
                <!-- /.breadcrumb -->
            </div>
            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <c:if test="${not empty messageResponse}">
                            <div class="alert alert-${alert}">
                                    ${messageResponse}
                            </div>
                        </c:if>
                        <div class="widget-box table-filter">
                            <div class="table-btn-controls">
                                <div class="pull-right tableTools-container">
                                    <div class="dt-buttons btn-overlap btn-group">
                                        <a flag="info"
                                           class="dt-button buttons-colvis btn btn-white btn-primary btn-bold" data-toggle="tooltip"
                                           title='Thêm người dùng' href='<c:url value="/admin-users?type=edit"/>'>
															<span>
																<i class="fa fa-plus-circle bigger-110 purple"></i>
															</span>
                                        </a>
                                        <button id="btnDelete" type="button"
                                                class="dt-button buttons-html5 btn btn-white btn-primary btn-bold" data-toggle="tooltip" title='Xóa'>
																<span>
																	<i class="fa fa-trash-o bigger-110 pink"></i>
																</span>
                                        </button>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col-xs-12">
                                <div class="table-responsive">
                                    <table class="table table-bordered">
                                        <thead>
                                        <tr>
                                            <th><input type="checkbox" name="checkAll" id="checkAll"></th>
                                            <th>Tên người dùng</th>
                                            <th>UserName</th>
                                            <th>Password</th>
                                            <th>Status</th>
                                            <th>Hình đại diện</th>
                                            <th>Thao tác</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="user" items="${model.listResult}">
                                            <C:if test="${user.status == '1'}">
                                                <tr>
                                                    <td><input type="checkbox" name="checkbox_user" id="checkbox_${user.id}" value="${user.id}"></td>
                                                    <td>${user.fullName}</td>
                                                    <td>${user.userName}</td>
                                                    <td>${user.password}</td>
                                                    <td>
                                                        <c:if test="${user.status == '1'}">
                                                            Khả dụng
                                                        </c:if>
                                                        <c:if test="${user.status == '0'}">
                                                            Không khả dụng
                                                        </c:if>
                                                    </td>
                                                    <td>
                                                        <img src="${user.avatar}" alt="${user.fullName}" width="150px" class="img-rounded">
                                                    </td>
                                                    <td>
                                                        <c:url var="editURL" value="/admin-users">
                                                            <c:param name="type" value="edit"/>
                                                            <c:param name="id" value="${user.id}"/>
                                                        </c:url>
                                                        <a class="btn btn-sm btn-primary btn-edit" data-toggle="tooltip"
                                                           title="Cập nhật thông tin" href='${editURL}'><i class="fa fa-pencil-square-o" aria-hidden="true"></i>
                                                        </a>
                                                    </td>
                                                </tr>
                                            </C:if>
                                            <C:if test="${user.status == '0'}"></C:if>

                                        </c:forEach>
                                        </tbody>
                                    </table>
                                    <ul class="pagination" id="pagination"></ul>
                                    <input type="hidden" value="" id="page" name="page"/>
                                    <input type="hidden" value="" id="maxPageItem" name="maxPageItem"/>
                                    <input type="hidden" value="" id="sortName" name="sortName"/>
                                    <input type="hidden" value="" id="sortBy" name="sortBy"/>
                                    <input type="hidden" value="" id="type" name="type"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </form>
</div>
<!-- /.main-content -->
<script>
    var totalPages = ${userModel.totalPage};
    var currentPage = ${userModel.page};
    var limit = 10;
    $(function () {
        window.pagObj = $('#pagination').twbsPagination({
            totalPages: totalPages,
            visiblePages: 8,
            startPage: currentPage,
            onPageClick: function (event, page) {
                if (currentPage != page) {
                    $('#maxPageItem').val(limit);
                    $('#page').val(page);
                    $('#sortName').val('fullName');
                    $('#sortBy').val('desc');
                    $('#type').val('list');
                    $('#formSubmit').submit();
                }
            }
        });
    });

    $("#btnDelete").click(function() {
        var data = {};
        var ids = $('tbody input[type=checkbox]:checked').map(function () {
            return $(this).val();
        }).get();
        data['ids'] = ids;
        deleteUser(data);
    });

    function deleteUser(data) {
        $.ajax({
            url: '${APIurl}',
            type: 'DELETE',
            contentType: 'application/json',
            data: JSON.stringify(data),
            success: function (result) {
                window.location.href = "${UserURL}?type=list&maxPageItem=8&page=1&message=delete_success";
            },
            error: function (error) {
                window.location.href = "${UserURL}?type=list&maxPageItem=8&page=1&message=error_system";
            }
        });
    }
    $('#checkAll').click(function(event) {
        if(this.checked) {
            // Iterate each checkbox
            $(':checkbox').each(function() {
                this.checked = true;
            });
        } else {
            $(':checkbox').each(function() {
                this.checked = false;
            });
        }
    });
</script>
</body>

</html>