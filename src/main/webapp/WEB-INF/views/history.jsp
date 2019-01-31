<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
<link rel="stylesheet"
	href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
<title>History</title>

<style>
#history {
	font-family: "Trebuchet MS", Arial, Helvetica, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

#history td, #history th {
	border: 1px solid #ddd;
	padding: 8px;
}

#history tr:nth-child(even) {
	background-color: #f2f2f2;
}

#history tr:hover {
	background-color: #ddd;
}

#history th {
	padding-top: 12px;
	padding-bottom: 12px;
	text-align: left;
	background-color: #4CAF50;
	color: white;
}
</style>
</head>
<body>
	<div>
		<h1>History</h1>
	</div>
	<div>
		<table id="history">
			<tr>
				<th>Username</th>
				<th>Nr.</th>
				<th>City</th>
				<th>Date of measurement</th>
				<th>Time of measurement</th>
				<th>Temperature (C)</th>
				<th>Wind speed (m/s)</th>
				<th>Wind direction</th>
				<th>Humidity(%)</th>
				<th>Precipitation summary (mm)</th>
				<th>Pressure (hPa)</th>
			</tr>
			<c:forEach var="users" items="${users}">
				<tr>
					<td>${users.username}</td>
				</tr>

				<c:forEach var="history" items="${users.history}" varStatus="status">
					<tr>
						<td></td>
						<td>${status.count}</td>
						<td>${history.stationName}</td>
						<td>${history.dateOfMeasurement}</td>
						<td>${history.timeOfMeasurement}:00</td>
						<td>${history.temperature}</td>
						<td>${history.windSpeed}</td>
						<td>${history.windDirection}</td>
						<td>${history.humidity}</td>
						<td>${history.precipitationSummary}</td>
						<td>${history.pressure}</td>
					</tr>
				</c:forEach>
			</c:forEach>

		</table>
	</div>
	<a href="<spring:url value="/location" />" class="btn btn-default">
		<span class="glyphicon-hand-left glyphicon"></span> Back
	</a>
</body>
</html>