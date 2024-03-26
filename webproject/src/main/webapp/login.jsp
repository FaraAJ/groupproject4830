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
		<form id="login" name="login" >
			<label for="username">User name:</label><br>
			<input type="text" id="username" name="username"><br>
			<label for="password">Password:</label><br>
			<input type="text" id="password" name="username"><br>
		</form>
	<div id="submitdiv" name="submitdiv" style="margin-top: 10px; margin-bottom: 10px">
		<form id="submitform" name="submitform">
			<input type="submit" value="Submit" id="submitButton">
		</form>
	</div>
	<div>
	<a href="createuser.jsp">New user? Create account here.</a>
	</div>
</div>
</body>
</html>