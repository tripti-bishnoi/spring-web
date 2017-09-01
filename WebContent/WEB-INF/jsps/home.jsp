<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link href="${pageContext.request.contextPath }/static/css/main.css" rel="stylesheet" type="text/css"/>
<title>Insert title here</title>
</head>
<body>
<!-- Hi There!! -->

<%-- Session- <%= session.getAttribute("name") %> <p/>
Request- <%= request.getAttribute("name") %> <p/> --%>

<%-- Request (using Expression Language)- ${name} <p/>
<c:out value="${name }"></c:out> --%>

<%-- <sql:query var="rs" dataSource="jdbc/springdb">
select id, username from users
</sql:query>
<c:forEach var="row" items="${rs.rows}">
    ID ${row.id}<br/>
    UserName ${row.username}<br/>
</c:forEach> --%>
<div style="height: 100px;">
<img alt="Gotya" src="${pageContext.request.contextPath }/static/images/gotya.jpg"/>
</div>
<table>

<tr><td><a href="${pageContext.request.contextPath }/showUsers">Show All Users</a></td></tr>
<tr><td><a href="${pageContext.request.contextPath }/createUsers">Create Users</a></td></tr>
</table>
</body>
</html>