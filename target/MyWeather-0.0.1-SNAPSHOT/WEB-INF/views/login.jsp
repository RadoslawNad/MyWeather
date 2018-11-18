<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>History</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Login</h1>
			</div>
		</div>
	</section>
	<div class="cointainer">
		<div class="row">
			<div class="col-md-4 col-md-offset-4">
				<div class="panel panel-default">
					<div class=" panel-heading">
						<h3 class="panel-title">Login</h3>
					</div>
					<div class="panel-body">
						<c:if test="${not empty error}">
							<div class="alert alert-danger">
								<spring:message
									code="AbstractUserDetailsAuthenticationProvider.badCredentials" />
							</div>
						</c:if>
						<form action='<spring:url value="/login"/>' method="post">
							<div class="form-group">
								<label for="username">User Name: </label> <input type="text"
									class="form-control" id="username" placeholder="Enter UserName"
									name="username" />
							</div>
							<div class="form-group">
								<label for="password">Password: </label> <input type="password"
									class="form-control" id="password" placeholder="Enter Password"
									name="password" />
							</div>
							<button type="submit" class="btn btn-primary btn-block">Submit</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>