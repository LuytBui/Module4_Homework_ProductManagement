<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 18/3/2022
  Time: 14:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Calculator</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <style>
        .img-product{
            height: 150px;
        }
        td{
            vertical-align: middle;
        }
    </style>
</head>
<body>

<div class="container mt-4">
    <div class="d-flex justify-content-between mb-3">
        <a href="/products?action=create" class="btn btn-success"><i class="bi bi-plus"></i>Add new product</a>
        <form class="search-form d-flex">
            <input class="input-search" type="text" placeholder="Search product ... " name="q">
            <button class="btn btn-primary">Search </button>
        </form>
    </div>
    <table class="table table-bordered caption-top mt-2">
        <caption><span>${requestScope["list-description"]}</span></caption>
        <thead>
        <tr>
            <th scope="col">#</th>
            <th scope="col">Product name</th>
            <th scope="col">Price</th>
            <th scope="col">Description</th>
            <th scope="col">Image</th>
            <th scope="col" colspan="2">Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="product" items="${products}" varStatus="loop">
            <tr>
                <td>${loop.count}</td>
                <td><a href="/products/${product.id}">${product.name}</a></td>
                <td>${product.price}</td>
                <td>${product.description}</td>
                <td><img class="img-product" src="${product.image}" alt="${product.name}"></td>
                <td><a class="btn btn-primary" href="/products/edit/${product.id}">Edit</a></td>
                <td><a class="btn btn-danger"  href="/products/delete/${product.id}">Delete</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>
