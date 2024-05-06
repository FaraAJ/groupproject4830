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
		color: ivory;
		margin: auto;
		text-align: center;
		float: right;
		width: 50%;
		line-height: 200px;
		height: 200px;

	}
	.container p {
		margin: auto;
		font-size: 40px;
		font-weight: bold;
	}
	.login {
		vertical-align: middle;
		display: inline-block;
		line-height: 1.5;
	}
	
	body, html {
			height: 100%; margin: 0;
		}
		
	.bg {background-image: url("res_front.jpg"); height: 100%; background-position: center; background-repeat: no-repeat; background-size: cover;}
	
	
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
	<div class="bg">
		<div id="centerdiv" class="container">
		<p>Restaurant Reserver</p>
			<div class="login">
				<form id="login" name="login" action="login" method="post">
					<label for="username">User name:</label><br>
					<input type="text" id="username" name="username" autocomplete="off"><br>
					<label for="password">Password:</label><br>
					<input type="password" id="password" name="password" autocomplete="off"><br><br>
					<input type="submit" value="Submit" id="submitButton">
				</form>
			</div>
			<div>
				<a href="memberRegister.jsp" id="newUser" style="color: ivory">New user? Create account here.</a>
			</div>
		</div>
	</div>
</body>
</html>