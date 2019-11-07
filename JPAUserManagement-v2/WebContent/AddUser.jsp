<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add User</title>
<script src="js/AddForm.js"></script>
</head>
<body>
	<form action="add.do" id="frm" method="post">
		<table>
			<tr>
				<td>Username</td>
				<td><input type="text" name="username" id="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password" id="password"></td>
			</tr>
			<tr>
				<td>First Name</td>
				<td><input type="text" name="firstname" id="firstname"></td>
			</tr>
			<tr>
				<td>Last Name</td>
				<td><input type="text" name="lastname" id="lastname"></td>
			</tr>
			<tr>
				<td>Mobile Number</td>
				<td><input type="text" name="mobilenumber" id="mobilenumber"></td>
			</tr>
			<tr>
				<td colspan="2"><input type="button" value="Save User" onclick="validateUser();"></td>
			</tr>
		</table>
	</form>
</body>
</html>