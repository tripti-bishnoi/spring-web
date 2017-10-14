<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib prefix="sec"
	uri="http://www.springframework.org/security/tags"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta name="_csrf_header" content="${_csrf.headerName}"/>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<div style="height: 100px;">
		<img alt="Gotya"
			src="${pageContext.request.contextPath }/static/images/gotya.jpg" />
	</div>
	<table>

		<tr>
			<td><a href="${pageContext.request.contextPath }/showUsers">Show
					All Users</a></td>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath }/createUsers">Create
					Users</a></td>
		</tr>
		<tr>
			<td><a
				href="${pageContext.request.contextPath }/showAllStudents">Show
					All Students</a></td>
		</tr>
		<tr>
			<td><a href="${pageContext.request.contextPath }/insertStudent">Insert
					Student Details</a></td>
		</tr>
		<sec:authorize access="hasRole('ROLE_ADMIN')"> <%-- hasAuthority('admin') --%>
			<tr>
				<td><a href="${pageContext.request.contextPath }/adminStuff">Admin</a></td>
			</tr>
		</sec:authorize>
		<sec:authorize access="isAuthenticated()">
			<tr>
				<td><c:url var="logoutUrl" value="/loggedOut" />
					<form action="${logoutUrl}" method="post">
						<input type="submit" value="Logout" /> <input type="hidden"
							name="${_csrf.parameterName}" value="${_csrf.token}" />
					</form> <!-- j_spring_security_logout --></td>
			</tr>
		</sec:authorize>

	</table>
</body>
</html>