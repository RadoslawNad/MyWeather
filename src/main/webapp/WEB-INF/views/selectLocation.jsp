<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>

<html>
<head>
<meta charset="utf-8">

<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
<script
	src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
<title>Select locations</title>
</head>

<body>

	<div class="container">

		<ul class="nav bg-light justify-content-between">

			<li class="nav-item ml-3 align-items-center">

				<div class="row">
					<security:authorize access="hasRole('USER')">
						<div>
							<a href="<spring:url value="/userhistory" />"
								class="nav-link active"> History </a>
						</div>
					</security:authorize>

					<security:authorize access="hasRole('ADMIN')">
						<div>
							<a href="<spring:url value="/history" />" class="nav-link active">
								All history </a>
						</div>
						<div>
							<a href="<spring:url value="/userhistory" />"
								class="nav-link active"> History </a>
						</div>
					</security:authorize>
				</div>
			</li>

			<li class="nav-item mr-5 align-items-center">
				<security:authorize
					access="!isAuthenticated()">
					<div>
						<p>Welcome: GUEST</p>
					</div>
				</security:authorize> 
				
				<security:authorize access="isAuthenticated()">
					<div class="row align-items-center">

						<div class="row mr-4 ">
							<p class="mr-2">Welcome:</p>
							<p>
								<security:authentication property="principal.username" />
							</p>
						</div>

						<div>
							<form:form action="${pageContext.request.contextPath}/logout"
								method="POST" class="form-horizontal">
								<div>
									<button type="submit" class="btn btn-link">Logout</button>
								</div>
							</form:form>
						</div>

					</div>
				</security:authorize></li>
		</ul>

		<div class="ml-4 mt-4">
			<div>
				<h1>LOCATION</h1>
			</div>

			<div>
				<p>Choose a city to show the weather</p>
			</div>

			<div>
				<form:form modelAttribute="locationToShow" method="POST"
					action="${pageContext.request.contextPath}/weather">
					<form:select path="stationName" items="${cities}" />
					<input type="submit" class="btn btn-success" value="Show" />
				</form:form>
			</div>

			<div class="mt-10">
				<a href="<spring:url value="/" />" class="btn btn-link"> Back</a>
			</div>

		</div>
	</div>

</body>
</html>