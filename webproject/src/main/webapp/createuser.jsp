<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create user</title>
<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
		<script>
			const ServletURL = "${pageContext.request.contextPath}/Usercreator";
			$(document).on("click", "#submitButton", function(event) {
				event.preventDefault();
				if($.trim($("#createUsername").val()) === ""){
					alert("Username required!");
				} 
				else if($.trim($("#createPassword").val()) === ""){
					alert("Password required!");
				}
				else if($.trim($("#createPhone").val()) === ""){
					alert("Phone number required!");
				}
				else if($.trim($("#email").val()) === ""){
					alert("Email required!");
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
			const ServletURL2 = "${pageContext.request.contextPath}/Contactmaker";
			$(document).ready(function() { 
    			$.get(ServletURL2, function(responseText) {
        			$("#leftdiv").html(responseText);           
    			});
			});
		</script>
</head>
<body>
	<div style="margin-bottom: 10px;">
		<form style="text-align:center;">
			<label for="createUsername">User name:</label><br>
			<input type="text" id="createUsername" name="createUsername"><br>
			<label for="createPassword">Password:</label><br>
			<input type="text" id="createPassword" name="createPassword"><br>
			<label for="createPhone">Phone number:</label><br>
			<input type="text" id="createPhone" name="createPhone"><br>
		</form>
	</div>
	<div>
		<form style="text-align:center;">
			<input type="submit" value="Submit" id="createSubmit">
		</form>
	</div>
</body>
</html>