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
	
		<table border="1 px solid">
			<tr>
				<th>Id</th>
				<th>Status</th>
				<th>Description</th>
				<th>Person Assigned</th>
			</tr>
			<%
			List<Task> tasks = (new TaskDao()).viewTasks();
            if(tasks!=null && tasks.isEmpty()==false){
			for (Task task : tasks) {
			%>


			<tr>
				<td><%=task.getTaskId()%></td>
				<td><%=task.getStatus()%></td>
				<td><%=task.getDescription()%>
				<td><%=task.getUser().getName()%>
			</tr>



			<%}
			}%>
		</table>
		
	<%if(tasks==null) {%>
	<table>
	<tr>
	<td>No Tasks Assigned</td>
	</tr>
	</table>
<%} %>
</body>
</html>