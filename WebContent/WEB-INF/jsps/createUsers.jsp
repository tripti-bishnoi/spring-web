<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="sf" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/main.css"
	rel="stylesheet" type="text/css" />
<title>Insert title here</title>
</head>
<body>
	<sf:form method="post"
		action="${pageContext.request.contextPath }/doCreate"
		modelAttribute="user">
		<div style="height: 100px;">
			<img alt="Gotya"
				src="${pageContext.request.contextPath }/static/images/gotya.jpg" />
		</div>
		<table>
			<tr>
				<td class="tablecol"></td>
				<td>
					<table class="formtable">
						<tr>
							<td class="label">User Name:</td>
							<td><sf:input path="username" name="username" type="text" /><br />
								<sf:errors path="username" cssClass="error"></sf:errors></td>
						</tr>
						<tr>
							<td></td>
							<td><input value="Create User" type="submit" /></td>
						</tr>
					</table>
				</td>
			</tr>
		</table>
	</sf:form>
</body>
</html>