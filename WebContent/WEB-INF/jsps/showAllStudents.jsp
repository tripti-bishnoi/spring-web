<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css" />
<title>All Students Details</title>
</head>
<body>
	<table class="students">
		<tr>
			<th>ID</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Age</th>
			<th>Email</th>
			<th>Standard</th>
			<th>Text</th>
		</tr>
		<c:forEach var="stu" items="${students }">
			<tr>
				<td><c:out value="${stu.id }"></c:out></td>
				<td><c:out value="${stu.firstname }"></c:out></td>
				<td><c:out value="${stu.lastname }"></c:out></td>
				<td><c:out value="${stu.age }"></c:out></td>
				<td><c:out value="${stu.email }"></c:out></td>
				<td><c:out value="${stu.standard }"></c:out></td>
				<td><c:out value="${stu.text }"></c:out></td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>