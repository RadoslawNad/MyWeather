<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8"%>

<html>
<head>
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.2.1/css/bootstrap.min.css">

<title><spring:message code="view.display.weather.label.header"/></title>
</head>
<body>
	<div class="container">

		<div class="jumbotron  row justify-content-md-center ">
			<h1><spring:message code="view.display.weather.label.title"/></h1>
		</div>

		<div class="row">
			<div class="col-md-5">
				<div>
					<h2>${objectToDisplay.stationName}</h2>
				</div>
				
				<div>
					<p>
						<strong><spring:message code="view.display.weather.label.date"/></strong>${objectToDisplay.dateOfMeasurement}
					</p>
					<p>
						<strong><spring:message code="view.display.weather.label.time"/></strong>${objectToDisplay.timeOfMeasurement}:00
					</p>
					<p>
						<strong><spring:message code="view.display.weather.label.temperature"/></strong>${objectToDisplay.temperature} C
					</p>
					<p>
						<strong><spring:message code="view.display.weather.label.wind.speed"/></strong>${objectToDisplay.windSpeed} m/s
					</p>
					<p>
						<strong><spring:message code="view.display.weather.label.wind.direction"/></strong>${objectToDisplay.windDirection}
					</p>
					<p>
						<strong><spring:message code="view.display.weather.label.humidity"/></strong>${objectToDisplay.humidity}%
					</p>
					<p>
						<strong><spring:message code="view.display.weather.label.precipitation.summary"/></strong>${objectToDisplay.precipitationSummary}
						mm
					</p>
					<p>
						<strong><spring:message code="view.display.weather.label.pressure"/></strong>${objectToDisplay.pressure} hPa
					</p>
				</div>
				
				<div>
					<a href="<spring:url value="/location" />" class="btn btn-link">
						<spring:message code="button.back" /> </a>
				</div>
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