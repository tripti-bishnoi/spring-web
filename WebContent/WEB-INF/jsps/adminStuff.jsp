<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css" />
<title>Update Login Details - Admin</title>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath }/userEnabled"
		method="post" modelAttribute="loginUpdate">
		<table class="formtable">
			<tr>
				<th>User Name:</th>
				<td><sf:input path="username" name="username" type="text" /></td>
			</tr>
			<tr>
				<th>Enabled:</th>
				<td><sf:input path="enabled" name="enabled" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Update" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>