<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Login</title>
<link rel="shortcut icon" href="favicon.ico"/>
	<style>
	.container {
		text-align: center;
	}
	</style>
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
	<script>
	$(document).ready(function(){
		let url = new URL(window.location.href);
		let params = new URLSearchParams(url.search);
		if(params.get('invalid') == 'true'){
			alert("Bad login! Please try again.");
			}
		if(params.get('accountmade') == 'true'){
			alert("Account successfully made, you may now log in.");
		}
	});
	</script>
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
	
	<a href="memberRegister.jsp" id="newUser">New user? Create account here.</a>
	</div>
</div>
</body>
</html>