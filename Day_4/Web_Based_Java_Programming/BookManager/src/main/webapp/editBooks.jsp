<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>

<%@ page import="com.bookmanager.model.Book" %>
<%
    Book book = (Book) request.getAttribute("book");
%>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
    <h2>Edit Book</h2>
<form action="update" method="post">
    <input type="hidden" name="id" value="<%=book.getId()%>"/>
    Title: <input type="text" name="title" value="<%=book.getTitle()%>" required/><br/>
    Author: <input type="text" name="author" value="<%=book.getAuthor()%>" required/><br/>
    Price: <input type="number" step="0.01" name="price" value="<%=book.getPrice()%>" required/><br/>
    <input type="submit" value="Update"/>
</form>
<a href="list">Back to List</a>
</body>
</html>