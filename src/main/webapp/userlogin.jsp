<%@page import="org.hibernate.Session"%>
<%@page import="com.ty.entity.UserInfo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%UserInfo info=(UserInfo)session.getAttribute("user"); %>
<%if(info==null){
	response.sendRedirect("login.jsp");
}

	%>
<%if(info!=null){ %>
<div style="text-align: center;"">
   <h1>Hi <%=info.getName()%></h1>
<hr><hr>
  <a style="color: blue" href="usertask.jsp">View Pending Tasks</a>
  <br>
  <hr>
  <a style="color: blue" href="usertaskall.jsp">View All Tasks</a>
  <br>
  <hr>
  <a style="color: blue" href="logout.jsp">Logout</a>
  <hr>
  </div>
  <%} %>
</body>
</html>