<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css" />
<title>Insert Student Details</title>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath }/studentSuccess"
		method="post" modelAttribute="student">
		<table class="formtable">
			<tr>
				<th>First Name:</th>
				<td><sf:input path="firstname" type="text" /><br /> <sf:errors
						path="firstname" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Last Name:</th>
				<td><sf:input path="lastname" type="text" /><br /> <sf:errors
						path="lastname" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Age</th>
				<td><sf:input path="age" type="text" /><br /> <sf:errors
						path="age" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Email:</th>
				<td><sf:input path="email" type="text" /><br /> <sf:errors
						path="email" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Standard:</th>
				<td><sf:input path="standard" type="text" /><br /> <sf:errors
						path="standard" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Text</th>
				<td><sf:input path="text" type="text" /></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Insert Student" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>