<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Registration Page</title>
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<h3 align="center">${headerMessage}</h3>
	<form:form modelAttribute="user" method="POST" action="/MyWeather/user/processRegistration">
		<table align="center">
			<caption align="top">User registration form</caption>
			<tr>
				<td>Enter Email:</td>
				<td><form:input path="email" /></td>
				<td><form:errors path="email" cssClass="error" /></td>
				<td>${emailError}</td>
			</tr>
			<tr>
				<td>Enter Password:</td>
				<td><form:password path="password" /></td>
				<td><form:errors path="password" cssClass="error" /></td>
			</tr>

			<tr>
				<td>Enter your Name:</td>
				<td><form:input path="name" /></td>
				<td><form:errors path="name" cssClass="error" /></td>
			</tr>

			<tr>
				<td><input type="submit" value="Register"></td>
			</tr>
		</table>

	</form:form>

</body>
</html>