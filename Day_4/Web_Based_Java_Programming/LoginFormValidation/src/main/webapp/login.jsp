<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login</title>
</head>
<body>
	<h2>Login Form</h2>
	<form action="LoginServlet" method="post">
	    <label>Login Id:</label>
	    <input type="text" name="loginId">
	    <label>Password:</label>
	    <input type="password" name="password">
	    <input type="submit" name="Login">
	</form>
</body>
</html>