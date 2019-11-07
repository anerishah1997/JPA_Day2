<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="java.util.List"%>
<%@page import="com.lti.model.Users"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h3><a href='AddUser.jsp'>Add User</a> | <a href='Home.jsp'>Home</a></h3>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Mobile Number</th>
			<th>Update?</th>
			<th>Delete?</th>
		</tr>
		<c:forEach var="user" items="${ requestScope.UsersList }">
			<c:url var="deleteUrl" value="delete.do">
				<c:param name="username" value="${ user.username }"></c:param>
			</c:url>
			<c:url var="updateUrl" value="UpdateUser.jsp">
			    <c:param name="username" value="${user.username }"></c:param>
			    <c:param name="firstname" value="${user.firstname }"></c:param>
			    <c:param name="lastname" value="${user.lastname }"></c:param>
			    <c:param name="mobilenumber" value="${user.mobilenumber }"></c:param>
			</c:url>
			<tr>
				<td> <c:out value="${ user.firstname }"></c:out> </td>
				<td> <c:out value="${ user.lastname }"></c:out> </td>
				<td> <c:out value="${ user.mobilenumber }"></c:out> </td>
				<td><a href='<c:out value="${updateUrl }"></c:out>'>Update</a></td>
				<td><a href='<c:out value="${ deleteUrl }"></c:out>'>Delete</a></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>