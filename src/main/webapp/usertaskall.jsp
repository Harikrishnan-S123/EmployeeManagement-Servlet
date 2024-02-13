<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@page import="com.ty.entity.UserInfo"%>
<%@page import="com.ty.dao.TaskDao"%>
<%@page import="com.ty.entity.Task"%>
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

<%UserInfo user=(UserInfo)session.getAttribute("user");
if(user!=null){
%>
   <table border="1 px solid">
			<tr>
				<th>Id</th>
				<th>Description</th>
				<th>Status</th>
				<th>Assigned Date</th>
			</tr>
			
			<%
			
			List<Task> tasks=(new TaskDao()).viewAllTasksUser(user.getId());
			if(tasks.isEmpty()==false){
			for (Task task : tasks) {
            System.out.println(task.getDescription());
			%>


			<tr>
				<td><%=task.getTaskId()%></td>
				<td><%=task.getDescription()%>
			     <td>
			   
			   <%=task.getStatus() %>
			     
			     </td>
			     
				<td><%=task.getCreatedTime()%>
			</tr>



			<%}%>
			<%}}
else{      %>

<h1>No task assigned</h1>
<%} %>
			<%if(user==null){
				response.sendRedirect("login.jsp");
			}
			
				%>
			

		</table>
</body>
</html>