<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html; charset=UTF-8" %>

<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>Weather</title>
</head>
<body>
	<section>
		<div class="jumbotron">
			<div class="container">
				<h1>Weather</h1>
			</div>
		</div>
	</section>
	<section class="cointainer">
		<div class="row">
			<div class="col-md-5">
				<h2>${objectToDisplay.stationName}</h2>
				<p>
					<strong>Date of measurement: </strong>${objectToDisplay.dateOfMeasurement}
				</p>
				<p>
					<strong>Time of measurement: </strong>${objectToDisplay.timeOfMeasurement}:00
				</p>
				<p>
					<strong>Temperature: </strong>${objectToDisplay.temperature} C
				</p>
				<p>
					<strong>Wind speed: </strong>${objectToDisplay.windSpeed} m/s
				</p>
				<p>
					<strong>Wind direction: </strong>${objectToDisplay.windDirection}
				</p>
				<p>
					<strong>Humidity: </strong>${objectToDisplay.humidity}%
				</p>
				<p>
					<strong>Precipitation summary: </strong>${objectToDisplay.precipitationSummary} mm
				</p>
				<p>
					<strong>Pressure: </strong>${objectToDisplay.pressure} hPa
				</p>

				<a href="<spring:url value="/location" />" class="btn btn-default">
					<span class="glyphicon-hand-left glyphicon"></span> Back
				</a>

			</div>
		</div>
	</section>
</body>
</html>