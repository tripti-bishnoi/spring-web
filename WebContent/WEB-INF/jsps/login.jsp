<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>Login Page</title>
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css" />
</head>
<body onload='document.f.username.focus();'>
	<c:if test="${param.error != null }">
		<p class="error">Login has failed. Please provide correct Username
			and Password.</p>
	</c:if>
	<h3>Login with Username and Password</h3>
	<form name='f' action='${pageContext.request.contextPath }/login'
		method='POST'>
		<table class="formtable">
			<tr>
				<td>User:</td>
				<td><input type='text' name='username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='password' /></td>
			</tr>
			<tr>
				<td><input type='checkbox' name='remember-me' checked="checked"/>Remember Me</td>
				<!-- _spring_security_remember_me -->
				<td></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit"
					value="Login" /></td>
			</tr>
			<input name="${_csrf.parameterName}" type="hidden"
				value="${_csrf.token }" />
		</table>
	</form>

<p><a href="<c:url value="/newAccount"/>"/>Create New Account</p>

</body>
</html>