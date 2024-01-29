<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Flight</title>
</head>
<body>
	<h1>Add Flight</h1>
	<form action="addFlight" method="POST">
		<pre>
		FlightNumber:<input type="text" name="flightNumber"><br />
		OperatingAirlines:<input type="text" name="operatingAirlines"><br />
		DepartureCity:<input type="text" name="departureCity"><br />
		ArrivalCity:<input type="text" name="arrivalCity"><br />
		DateOfDeparture:<input type="text" name="dateOfDeparture"
				placeholder="DD-MM-YYYY"><br />
		estimatedDepartureTime:<input type="text"
				name="estimatedDepartureTime" placeholder="yyyy-mm-dd hh:mm:ss"><br />
		<input type="submit" value="Add">
		</pre>
	</form>
</body>
</html>