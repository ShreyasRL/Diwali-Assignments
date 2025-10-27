<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Form</title>
 <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"/>
</head>
<body class="p-3">
      <div class="container">
    <h2>${title}</h2>
    <form:form method="post" modelAttribute="customer" action="/customers/save" class="mt-3">
        <form:hidden path="id"/>
        <div class="mb-3">
            <label>First Name</label>
            <form:input path="firstName" cssClass="form-control"/>
            <form:errors path="firstName" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label>Last Name</label>
            <form:input path="lastName" cssClass="form-control"/>
            <form:errors path="lastName" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label>Email</label>
            <form:input path="email" cssClass="form-control"/>
            <form:errors path="email" cssClass="text-danger"/>
        </div>
        <div class="mb-3">
            <label>Phone</label>
            <form:input path="phone" cssClass="form-control"/>
        </div>

        <button type="submit" class="btn btn-success">Save</button>
        <a href="/customers" class="btn btn-secondary">Cancel</a>
    </form:form>
</div>
</body>
</html>