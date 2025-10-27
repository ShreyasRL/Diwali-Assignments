<%@page import="java.util.*,com.bookmanager.model.Book"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Book List</title>
</head>
<body>
     <h2>Books</h2>
<a href="new">Add New Book</a>
<table border="1">
    <tr><th>ID</th><th>Title</th><th>Author</th><th>Price</th><th>Actions</th></tr>
    <%
        List<Book> list = (List<Book>) request.getAttribute("listBook");
        for(Book b : list){
    %>
    <tr>
        <td><%=b.getId()%></td>
        <td><%=b.getTitle()%></td>
        <td><%=b.getAuthor()%></td>
        <td><%=b.getPrice()%></td>
        <td>
            <a href="edit?id=<%=b.getId()%>">Edit</a>
            <a href="delete?id=<%=b.getId()%>" onclick="return confirm('Are you sure?')">Delete</a>
        </td>
    </tr>
    <% } %>
</table>
</body>
</html>