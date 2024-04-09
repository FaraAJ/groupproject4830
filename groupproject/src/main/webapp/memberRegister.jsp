<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
	<style>
	.container {
		text-align: center;
	}
	</style>
</head>
<body>
 <form action="${pageContext.request.contextPath}/Register" method="post">
 
 <div id="centerdiv" name="centerdiv" class="container">
		<form id="register" name="register" action="register" method="post">
			<label for="uname">User name:</label><br>
			<input type="text" id="uname" name="uname" autocomplete="off"><br>
			<label for="password">Password:</label><br>
			<input type="password" id="password" name="password" autocomplete="off"><br>
			<label for="password">Confirm Password:</label><br>
			<input type="cpassword" id="cpassword" name="cpassword" autocomplete="off"><br>
			<label for="phone">Phone Number:</label><br>
			<input type="text" id="phone" name="phone" autocomplete="off"><br><br>
			<input type="submit" value="Submit" id="submitButton">
		</form>
	</div>
 </form>
</body>
</html>