<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
   "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Form</title>
</head>
<body>
	<h1 style="text-align: center;color: red">Login</h1>
	<center>
	<form action="login" method="post">
		<table cellpadding="3pt" border="1px solid">
			<tr>
				<td>Email :</td>
				<td><input type="text" name="email" size="30" /></td>
			</tr>
			<tr>
				<td>Password :</td>
				<td><input type="password" name="password" size="30" /></td>
			</tr>
		</table>
		<p />
		<input type="submit" value="Login" />
	</form>
	</center>
</body>
</html>