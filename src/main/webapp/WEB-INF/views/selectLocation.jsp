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


<title><spring:message code="view.login.label.header" /></title>
</head>

<body>

	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">

			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<!-- is User login -->
				<security:authorize access="hasRole('USER')">

					<div class="navbar-nav">
						<a class="nav-item nav-link"
							href="<spring:url value="/userhistory" />"> <spring:message
								code="view.select.location.link.user.history" />
						</a>
					</div>

					<div class="navbar-nav ml-auto p-2">
						<span class="navbar-text"> <spring:message
								code="view.select.location.label.welcome" />
						</span> <span class="navbar-text"> <security:authentication
								property="principal.username" />
						</span>

						<form:form action="${pageContext.request.contextPath}/logout"
							method="POST" class="form-horizontal">
							<div>
								<button type="submit" class="btn btn-link">
									<spring:message code="button.logout" />
								</button>
							</div>
						</form:form>
					</div>

				</security:authorize>

				<!-- is Admin login -->
				<security:authorize access="hasRole('ADMIN')">

					<div class="navbar-nav">
						<a class="nav-item nav-link"
							href="<spring:url value="/userhistory" />"> <spring:message
								code="view.select.location.link.user.history" />
						</a> <a class="nav-item nav-link"
							href="<spring:url value="/history" />"> <spring:message
								code="view.select.location.link.all.history" />
						</a>
					</div>

					<div class="navbar-nav ml-auto p-2">
						<span class="navbar-text"> <spring:message
								code="view.select.location.label.welcome" />
						</span> <span class="navbar-text"> <security:authentication
								property="principal.username" />
						</span>

						<form:form action="${pageContext.request.contextPath}/logout"
							method="POST" class="form-horizontal">
							<div>
								<button type="submit" class="btn btn-link">
									<spring:message code="button.logout" />
								</button>
							</div>
						</form:form>
					</div>
				</security:authorize>

				<!-- no one is logged in -->
				<security:authorize access="!isAuthenticated()">
					<div class="navbar-nav ml-auto p-2">
						<span class="navbar-text"> <spring:message
								code="view.select.location.label.guest" />
						</span>
					</div>
				</security:authorize>

			</div>
		</nav>


		<div class="ml-4 mt-4">
			<div>
				<h1>
					<spring:message code="view.select.location.label.title" />
				</h1>
			</div>

			<div>
				<p>
					<spring:message code="view.select.location.label.message" />
				</p>
			</div>

			<div>
				<form:form modelAttribute="locationToShow" method="POST"
					action="${pageContext.request.contextPath}/weather">
					<form:select path="stationName" items="${cities}" />
					<button type="submit" class="btn btn-success">
						<spring:message code="view.select.location.button.display.weather" />
					</button>
				</form:form>
			</div>

			<div class="mt-10">
				<a href="<spring:url value="/" />" class="btn btn-link"> <spring:message
						code="button.back" /></a>
			</div>

		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>