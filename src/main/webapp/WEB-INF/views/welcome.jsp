<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home Page</title>
</head>
<body>
	<h2 align="center">
		<spring:message code="view.welcome.title.label" />
	</h2>
	<h3 align="center">
		<a href="<spring:url value="/location"/>" class="btn btn-default"><spring:message
				code="view.welcome.button.guest" /></a>
	</h3>
	<table align="center">
		<tr>
			<td><a href="<spring:url value="/user/login"/>"
				class="btn btn-default"><spring:message
						code="view.welcome.button.login" /></a></td>
			<td><a href="<spring:url value="/user/register"/>"
				class="btn btn-default"><spring:message
						code="view.welcome.button.register" /></a></td>
		</tr>
	</table>
</body>
</html>