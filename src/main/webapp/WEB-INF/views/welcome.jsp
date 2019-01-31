<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html>
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

<title>Home Page</title>
</head>

<body>

	<div class="container">

		<ul class="nav justify-content-end btn-toolbar bg-light"
			role="toolbar">
				<li class="nav-item">
					<a class="nav-link active" href="<spring:url value="/login"/>"><spring:message
							code="view.welcome.button.login" /></a>
				</li>

				<li class="nav-item">
					<a class="nav-link active" href="<spring:url value="/register"/>"><spring:message
							code="view.welcome.button.register" /></a>
				</li>
		</ul>

		<div class="row justify-content-md-center  mt-5">

			<h2>
				<spring:message code="view.welcome.title.label" />
			</h2>

		</div>

		<div class="row justify-content-md-center  mt-5">
			<a class="btn btn-success" href="<spring:url value="/location"/>">
				<spring:message code="view.welcome.button.guest" />
			</a>

		</div>

	</div>
</body>
</html>