<%@page import="com.ty.dao.LoginDao"%>
<%@page import="com.ty.entity.UserInfo"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%List<UserInfo> users=(new LoginDao()).getAllUsers();
if(users!=null && users.isEmpty()==false){
%>
<h1>Select the user</h1>
<%String user="" ;%>
<form action="assigned" method="post">
<select name="name">
<% 
for(UserInfo employee: users){
%>
<%user=employee.getId()+" "+ employee.getName();%>


<option value = "<%= employee.getId() %>"><%= user %></option>



<%} %>
<%} %>
</select>
<br><br>
Description:
<input type="text" name="description" width="50">
<br><br>
<input type="submit"> 
  </form>
 
</body>
</html>