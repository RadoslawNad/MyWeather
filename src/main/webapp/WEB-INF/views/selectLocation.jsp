<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Select locations</title>
</head>
<body>

	<security:authorize access="!isAuthenticated()">
  		<p>
			Welcome: GUEST
		</p>
	</security:authorize>
	<security:authorize access="isAuthenticated()">
		<p>
			Welcome:
			<security:authentication property="principal.username" />
			<br />
			<security:authentication property="principal.authorities" />
			<br />
		</p>
		<form:form action="${pageContext.request.contextPath}/logout"
			method="POST" class="form-horizontal">
			<div>
				<input type="submit" value="Logout" />
			</div>
		</form:form>
	</security:authorize>

	<div>
		<h1>LOCATION</h1>
		<p>Choose a city to show the weather.</p>
	</div>
	<div>
		<form:form modelAttribute="locationToShow" method="POST"
			action="/MyWeather/weather">
			<form:select path="stationName" items="${cities}" />
			<input type="submit" id="btnAdd" class="btn btn-primary" value="Show" />
		</form:form>
	</div>
	<div>
		<a href="<spring:url value="/history" />" class="btn btn-default">
			<span class="glyphicon glyphicon-folder-open"></span> History
		</a>
	</div>
		<div>
		<a href="<spring:url value="/" />" class="btn btn-default">
			<span class="glyphicon glyphicon-menu-left"></span> Back
		</a>
	</div>
</body>
</html>