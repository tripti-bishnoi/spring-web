<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css" />
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/script/jquery.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath }/static/script/scripts.js"
	async></script>
</head>
<body>
	<sf:form action="${pageContext.request.contextPath }/createAccount"
		method="post" modelAttribute="loginDetails">
		<table class="formtable">
			<tr>
				<th>User Name:</th>
				<td><sf:input path="username" name="username" type="text" /><br />
					<sf:errors path="username" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Authority:</th>
				<td><sf:input path="authority" name="authority" type="text" /><br />
					<sf:errors path="authority" cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Password:</th>
				<td><sf:input id="password" path="password" name="password"
						type="password" /><br /> <sf:errors path="password"
						cssClass="error"></sf:errors></td>
			</tr>
			<tr>
				<th>Confirm Password:</th>
				<td><input id="confirmPass" name="confirmPass" type="password" /></td>
			</tr>
			<tr>
				<td></td>
				<td><div id="passwordMessage" class="error"></div></td>
			</tr>
			<tr>
				<td></td>
				<td><input value="Create Account" type="submit" /></td>
			</tr>
		</table>
	</sf:form>
</body>
</html>