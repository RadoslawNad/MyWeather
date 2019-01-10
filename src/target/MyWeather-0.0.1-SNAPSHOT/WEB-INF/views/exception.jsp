<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>SessionFactoryException</title>
</head>
<body>
	<div class="alert alert-danger">
		<h1>${message}</h1>
	</div>

	<a href="<spring:url value="/location" />" class="btn btn-default">
		<span class="glyphicon-hand-left glyphicon"></span> Back
	</a>
</body>
</html>