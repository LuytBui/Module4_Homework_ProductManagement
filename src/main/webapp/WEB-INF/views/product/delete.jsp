<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Delete product</title>
    <%--    Bootstrap--%>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.0.0/css/all.min.css"
          integrity="sha512-9usAa10IRO0HhonpyAIVpjrylPvoDwiPUiKdWk5t3PyolY1cOd4DSE0Ga+ri4AuTroPR5aQvXU9xC6qOPnzFeg=="
          crossorigin="anonymous" referrerpolicy="no-referrer"/>
    <style>
        .message-true{
            color: green;
        }
        .message-false{
            color: red;
        }
    </style>
</head>
<body>
<div class="container">
    <h1>Delete product</h1>
    <c:if test="${message != null}">
        <p class="message-${success}">${message}</p>
    </c:if>
    <form method="post">
        <div class="mb-3">
            <label for="name" class="form-label">Name</label>
            <input type="type" class="form-control" id="name" name="name" value="${product.name}" disabled>
        </div>
        <div class="mb-3">
            <label for="price" class="form-label">Price</label>
            <input type="type" class="form-control" id="price" name="price" value="${product.price}" disabled>
        </div>
        <div class="mb-3">
            <label for="description" class="form-label">Description</label>
            <input type="type" class="form-control" id="description" name="description" value="${product.description}" disabled>
        </div>
        <div class="mb-3">
            <label for="image" class="form-label">Image URL</label>
            <input type="text" class="form-control" id="image" name="image" value="${product.image}" disabled>
        </div>
        <button type="submit" class="btn btn-danger">Confirm delete</button>
        <a class="btn btn-primary" href="/products" id="btn-back">Back to list</a>
    </form>
</div>
</body>
</html>
