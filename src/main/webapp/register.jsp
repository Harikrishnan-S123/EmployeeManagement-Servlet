
<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Form</title>
</head>
<body>
	<h1>Registration Form</h1>
	<form action="register" method="post">
		<table cellpadding="3pt" border="1px solid">
			<tr>
				<td>User Name :</td>
				<td><input type="text" name="userName" size="30" /></td>
			</tr>
			<tr>
				<td>email :</td>
				<td><input type="text" name="email" size="30" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" size="30" /></td>
			</tr>

			<tr>
				<td>Role :</td>
				<td>
				
				<select name="role" style="width:230px;">
				<option>Employee</option>
				<option>Manager</option>
				
				</select>
				
				</td>
			</tr>
			
			<tr>
				<td>Designation :</td>
				<td><input type="text" name="designation" size="30" /></td>
			</tr>
			<tr>
				<td>Salary :</td>
				<td><input type="text" name="salary" size="30" /></td>
			</tr>
		</table>
		<p />
		<input type="submit" value="Register" />
	</form>
</body>
</html>