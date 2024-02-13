<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%session.invalidate();

%>
<h1>Logged out successfully</h1>
<a href="login.jsp">Go to Login</a>
</body>
</html>