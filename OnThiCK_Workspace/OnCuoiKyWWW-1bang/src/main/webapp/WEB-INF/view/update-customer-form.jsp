<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Form thêm</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
          integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
          crossorigin="anonymous">
</head>

<body>
<div class="container">
    <div class="control bg-primary">
        <h2 class="text-white text-center">Form sửa thông tin khách hàng</h2>
        <c:url var="backToHome" value="/"/>
        <a href="${backToHome}" class="btn btn-success ml-2 mb-2">Trang chủ</a>
    </div>
    <div>
        <form:form method="POST"
                   modelAttribute="customer"
                   action="${pageContext.request.contextPath}/${customer.id}"
                   accept-charset="UTF-8">
            <div class="form-group">
                <label for="id">Mã khách hàng:</label>
                <input type="text" class="form-control" name="id" id="id" placeholder="Id" value="${customer.id}" readonly>
            </div>
            <div class="form-group">
                <label for="lastName">Họ:</label>
                <input type="text" class="form-control" name="lastName" id="lastName" placeholder="Nhập họ" value="${customer.lastName}">
            </div>
            <div class="form-group">
                <label for="firstName">Tên:</label>
                <input type="text" class="form-control" name="firstName" id="firstName" placeholder="Nhập tên:" value="${customer.firstName}">
            </div>
            <div class="form-group">
                <label for="email">Email</label>
                <input type="text" class="form-control" name="email" id="email" placeholder="Nhập email" value="${customer.email}">
            </div>
            <button type="submit" class="btn btn-primary">Sửa</button>
        </form:form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
</body>

</html>