<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>

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
<title>Registration Confirmation</title>
</head>

<body>
	<div class="container">

		<div class="alert alert-success" role="alert">
			<h2>User registered successfully!</h2>
		</div>

		<div class="row justify-content-between">
			<div>
				<a href="${pageContext.request.contextPath}/login"
					class="btn btn-link">Login </a>
			</div>
			<div>
				<a href="<spring:url value="/" />" class="btn btn-link"> Back </a>
			</div>
		</div>

	</div>
</body>

</html>