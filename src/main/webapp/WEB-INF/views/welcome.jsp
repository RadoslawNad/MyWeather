<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="security"
	uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html>

<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<title><spring:message code="view.welcome.label.header" /></title>
</head>

<body>

	<div class="container">

		<nav class="navbar navbar-expand-lg navbar-light bg-light">

			<div class="collapse navbar-collapse" id="navbarSupportedContent">

				<!-- is login -->
				<security:authorize access="isAuthenticated()">

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
						<a class="nav-item nav-link text-primary"
							href="<spring:url value="/login"/>"> <spring:message
								code="button.login" />

						</a> <a class="nav-item nav-link text-primary"
							href="<spring:url value="/register"/>"> <spring:message
								code="button.register" />
						</a>
					</div>
				</security:authorize>


			</div>
		</nav>


		<div class="row justify-content-md-center  mt-5">

			<h2>
				<spring:message code="view.welcome.label.title" />
			</h2>

		</div>

		<div class="row justify-content-md-center  mt-5">
			<a class="btn btn-success" href="<spring:url value="/location"/>">
				<spring:message code="view.welcome.button.enter" />
			</a>
		</div>
		
		<div style="margin-top:150px;">
			<p class="font-weight-bold"><spring:message code="view.welcome.text.quick.use" /></p>
			<p class="font-italic"><spring:message code="view.welcome.text.info" /></p>
			<p><spring:message code="view.welcome.text.user" /></p>
			<p><spring:message code="view.welcome.text.admin" /></p>
		</div>
		
		<div style="margin-top:100px;">
			<p class="font-italic"><small><spring:message code="view.welcome.license.en" /></small></p>
			<p class="font-italic"><small><spring:message code="view.welcome.license.pl" /></small></p>
		</div>

	</div>

	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.6/umd/popper.min.js"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/js/bootstrap.min.js"></script>
</body>
</html>