<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Complete Reservation</title>
</head>
<body>
	<h2>Complete Reservation</h2>
	AirLine: ${flight.operatingAirlines}
	<br /> DepartureCity: ${flight.departureCity}
	<br /> ArrivalCity: ${flight.arrivalCity}
	<br />

	<form Action="completeReservation" method="POST">
		<pre>
		<h2>Passenger Details:</h2>
		First Name:<input type="text" name="passengerFirstName" /><br />
		Last Name:<input type="text" name="passengerLastName" /><br />
		Email:<input type="text" name="passengerEmail" /><br />
		Phone:<input type="text" name="passengerPhone" /><br />
		
		<h2>Card Details:</h2>
		Name on the card:<input type="text" name="nameOnTheCard"><br />
		Card No:<input type="text" name="cardNumber"><br />
		Expiry Date:<input type="text" name="expirationDate"><br />
		Three Digit Sec Code:<input type="text" name="securityCode"><br />
		<input type="hidden" name="flightId" value="${flight.id}">
		
		<input type="submit" value="Confirm">
</pre>
	</form>

</body>
</html>