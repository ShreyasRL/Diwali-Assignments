<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-3">
     <div class="container">
    <div class="d-flex justify-content-between align-items-center mb-3">
        <h2>Customer List</h2>
        <a href="customers/new" class="btn btn-primary">Add Customer</a>
    </div>

    <table class="table table-bordered">
        <thead>
        <tr>
            <th>ID</th><th>First Name</th><th>Last Name</th><th>Email</th><th>Phone</th><th>Actions</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach var="c" items="${customers}">
            <tr>
                <td>${c.id}</td>
                <td>${c.firstName}</td>
                <td>${c.lastName}</td>
                <td>${c.email}</td>
                <td>${c.phone}</td>
                <td>
                    <a href="customers/edit/${c.id}" class="btn btn-warning btn-sm">Edit</a>
                    <a href="customers/delete/${c.id}" class="btn btn-danger btn-sm"
                       onclick="return confirm('Delete this customer?');">Delete</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
</html>