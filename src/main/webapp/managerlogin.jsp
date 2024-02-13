<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Manager login</title>
</head>
<body>
     <%if(session.getAttribute("user")!=null){%>
     <div style="text-align: center;">
     <h1>Welcome Manager sir</h1>
        <a href="managertask.jsp"><button style="width:25%;">Assign Task</button></a>
        <hr><hr>
        <a href="managerviewtask.jsp"><button style="width:25%;">view Tasks</button></a>
        <hr><hr>
         <a style="color: blue" href="logout.jsp"><button style="width:25%;">Logout</button></a>
          </div>
    <%}%> 
   
   <%if(session.getAttribute("user")==null){ %>
   <h1>Please login sir</h1>
   <%request.getRequestDispatcher("login.jsp").include(request, response);%>
   <%} %>
</body>
</html>