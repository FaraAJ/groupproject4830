
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
	
	body, html {
			height: 100%; margin: 0;
		}
		
	
	.back {
		background-image: url("res_back.jpg"); height: 100%; background-position: bottom; background-repeat: no-repeat; background-size: cover;
	}
	
</style>
</head>
<body>
<div class = "back" >
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
<script>
    $(document).ready(function() {
        const ServletURL = "${pageContext.request.contextPath}/Register";

        $(document).on("click", "#submitButton", function(event) {
            // Remove preventDefault to allow form submission
            // event.preventDefault();

            // Check if all required fields are filled
            if ($.trim($("#uname").val()) === "") {
                alert("User Name Required");
                return false;
            }
            if ($.trim($("#password").val()) === "") {
                alert("Password Required");
                return false;
            }
            if ($.trim($("#cpassword").val()) === "") {
                alert("Confirm Password Required");
                return false;
            }
            if ($.trim($("#phone").val()) === "") {
                alert("Phone Number Required");
                return false;
            }

            // Check if password meets minimum length requirement
            const minPasswordLength = 5;
            if ($("#password").val().length < minPasswordLength) {
                alert("Password must be at least " + minPasswordLength + " characters long");
                return false;
            }

            // Check if password and confirm password match
            if ($("#password").val() !== $("#cpassword").val()) {
                alert("Passwords do not match");
                return false;
            }

            // If all checks pass, the form will be submitted normally
            return true;
        });
    });
</script>

 <form action="${pageContext.request.contextPath}/Register" method="post">
 
 <div id="centerdiv" name="centerdiv" class="container">
		<form id="register" name="register" action="register" method="post">
			<label for="uname">User name:</label><br>
			<input type="text" id="uname" name="uname" autocomplete="off"><br>
			<label for="password">Password:</label><br>
			<input type="password" id="password" name="password" autocomplete="off"><br>
			<label for="password">Confirm Password:</label><br>
			<input type="password" id="cpassword" name="cpassword" autocomplete="off"><br>
			<label for="phone">Phone Number:</label><br>
			<input type="text" id="phone" name="phone" autocomplete="off"><br><br>
			<input type="submit" value="Submit" id="submitButton">
		</form>
	</div>
 </form>
</div>
</body>
</html>