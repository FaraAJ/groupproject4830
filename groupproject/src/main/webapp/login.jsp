<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Login</title>
	<style>
	.container {
		text-align: center;
	}
	</style>
</head>
<body>
	<div id="centerdiv" name="centerdiv" class="container">
		<form id="login" name="login" action="login" method="post">
			<label for="username">User name:</label><br>
			<input type="text" id="username" name="username" autocomplete="off"><br>
			<label for="password">Password:</label><br>
			<input type="password" id="password" name="password" autocomplete="off"><br><br>
			<input type="submit" value="Submit" id="submitButton">
		</form>
	<div>
	<a href="createuser.jsp">New user? Create account here.</a>
	</div>
</div>
</body>
</html>