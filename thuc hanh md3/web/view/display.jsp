<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 26/05/2020
  Time: 9:45 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Show Product</title>
    <link href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
    <script src="//netdna.bootstrapcdn.com/bootstrap/3.0.0/js/bootstrap.min.js"></script>
    <script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="container" align="center">
    <div class="row col-md-10 col-md-offset-1 custyle">
        <form action="/product">
            <input type="text" name="name">
            <button type="submit" name="action" value="find">tim kiem</button>
        </form>
        <form method="get">
            <table class="table table-striped custab">
                <thead>
                <a href="/product?action=create"
                   class="btn btn-primary btn-xs pull-left"><b>+</b> Add new Product</a>
                <tr>
                    <th>ID</th>
                    <th>Product Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>Color</th>
                    <th>Category</th>
                    <th class="text-center">Action</th>
                </tr>
                </thead>
                <c:forEach items="${list}" var="list">
                    <tr>
                        <td>${list.getId()}</td>
                        <td>${list.getName()}</td>
                        <td>${list.getPrice()}</td>
                        <td>${list.getQuantity()}</td>
                        <td>${list.getColor()}</td>
                        <td>${list.getCategory()}</td>
                        <td class="text-center"><a class='btn btn-info btn-xs'
                                                   href="#"><span
                                class="glyphicon glyphicon-edit"></span> Edit</a>
                            <a href="/product?action=delete&id=${list.getId()}" class="btn btn-danger btn-xs"><span
                                    class="glyphicon glyphicon-remove"></span> Delete</a></td>
                    </tr>
                </c:forEach>
            </table>
        </form>

    </div>
</div>
</body>
</html>
