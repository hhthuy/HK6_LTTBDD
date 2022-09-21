<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Danh sách</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css"
        integrity="sha384-zCbKRCUGaJDkqS1kPbPd7TveP5iyJE0EjAuZQTgFLD2ylzuqKfdKlfG/eSrtxUkn"
        crossorigin="anonymous">
</head>

<body>
    <div class="container">
        <div class="control bg-primary">
            <h1 class="text-white text-center">Danh sách</h1>
            <c:url var="addCustomer" value="./add-customer" />
            <a href="${addCustomer}" class="btn btn-success ml-2 mb-2">Thêm khách hàng</a>
        </div>
        <table class="table">
            <thead>
                <tr>
                    <th scope="col">STT</th>
                    <th scope="col">Id</th>
                    <th scope="col">First Name</th>
                    <th scope="col">Last Name</th>
                    <th scope="col">Email</th>
                    <th scope="col">Action</th>
                </tr>
            </thead>
            <tbody>
                    <c:forEach items="${customers}" var="customer" varStatus="loop">
                        <tr>
                            <th scope="row">${loop.index}</th>
                            <td>${customer.id}</td>
                            <td>${customer.firstName}</td>
                            <td>${customer.lastName}</td>
                            <td>${customer.email}</td>
                            <td>
                                <c:url var="updateLink" value="./${customer.id}" />
                                <c:url var="deleteLink" value="./delete/${customer.id}" />
                                <a class="btn btn-primary" href="${updateLink}" role="button">Sửa</a>
                                <a
                                    class="btn btn-danger"
                                    href="${deleteLink}"
                                    role="button"
                                    onclick="if(!confirm('Bạn muốn xóa khách hàng này?')) return false;"
                                >
                                    Xóa
                                </a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
        </table>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/jquery@3.5.1/dist/jquery.slim.min.js"
        integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"
        crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-fQybjgWLrvvRgtW6bFlB7jaZrFsaBXjsOMm/tB9LTS58ONXgqbR9W8oWht/amnpF"
        crossorigin="anonymous"></script>
</body>

</html>