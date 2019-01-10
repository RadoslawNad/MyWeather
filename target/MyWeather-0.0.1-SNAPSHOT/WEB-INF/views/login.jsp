<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">
.error {
	color: red;
}
</style>

</head>
<body>
	<h2 align="center">
		<spring:message code="view.login.title" />
	</h2>
	<form:form action="/MyWeather/user/login" method="POST"
		modelAttribute="userCredential">

		<table align="center">
			<tr>
				<td style="color: red;"> <c:if test="${not empty error}">
						<spring:message code="view.login.error" />
					</c:if>
				</td>
			</tr>
			<tr>
				<td><spring:message code="view.login.label.username" /></td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
			</tr>
			<tr>
				<td><spring:message code="view.login.label.password" /></td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>
			<tr>
				<td><input type="submit"
					value=<spring:message code="view.login.button.login"/>></td>
			</tr>
		</table>
	</form:form>
</body>
</html>