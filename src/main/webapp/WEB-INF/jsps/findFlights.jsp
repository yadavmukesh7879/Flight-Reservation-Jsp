<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Find Flights</title>
</head>
<body>
	<h1>Find Flights Here:</h1>
	<form action="findFlights" method="POST">
		From:<input type="text" name="from">
		To:<input type="text" name="to">
		Departure Date:<input type="text" name="departureDate" placeholder="DD-MM-YYYY">
		<input type="submit" value="Search">
	</form>
</body>
</html>