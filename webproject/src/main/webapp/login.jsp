<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Restaurant Login</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		<script>
			const ServletURL = "${pageContext.request.contextPath}/mysqlcheck";
			$(document).on("click", "#submitButton", function(event) {
				event.preventDefault();
				if($.trim($("#username").val()) === ""){
					alert("Username required!");
				} 
				else if($.trim($("#password").val()) === ""){
					alert("Password required!");
				}
				else{
				$.post(ServletURL,
							$("#inputcontact").serialize(),
							function(responseText) {
        			document.getElementById("inputcontact").reset();
						$("#leftdiv").html(responseText);
    			})};
			});
		</script>
		<script>
			const ServletURL2 = "${pageContext.request.contextPath}/mysqlcheck";
			$(document).ready(function() { 
    			$.get(ServletURL2, function(responseText) {
        			$("#leftdiv").html(responseText);           
    			});
			});
		</script>
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
			<input type="text" id="password" name="password"><br>
		</form>
	<div id="submitdiv" name="submitdiv" style="margin-top: 10px; margin-bottom: 10px">
		<form id="submitform" name="submitform">
			<input type="submit" value="Submit" id="loginSubmit">
		</form>
	</div>
	<div>
	<a href="createuser.jsp">New user? Create account here.</a>
	</div>
</div>
</body>
</html>