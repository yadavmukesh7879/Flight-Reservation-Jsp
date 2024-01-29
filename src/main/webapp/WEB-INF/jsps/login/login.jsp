<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
  <h2>Login:</h2>
	<form action="login" method="post">
	 <pre>
	   <input type="text" name="email"></br>
	   <input type="password" name="password"></br>
	   <input type="submit" value="Login"/>
	 </pre>
	</form>
	${msg}
</body>
</html>