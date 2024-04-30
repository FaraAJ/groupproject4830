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

    <script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
    <script>
        const ServletURL = "${pageContext.request.contextPath}/NoteMaker";

        $(document).on("click", "#submitButton", function(event) {
            event.preventDefault();

            // Check if all required fields are filled
            if ($.trim($("#uname").val()) === "") {
                alert("User Name Required");
                return;
            }
            if ($.trim($("#password").val()) === "") {
                alert("Password Required");
                return;
            }
            if ($.trim($("#cpassword").val()) === "") {
                alert("Confirm Password Required");
                return;
            }
            if ($.trim($("#phone").val()) === "") {
                alert("Phone Number Required");
                return;
            }
            
         	// Check if password meets minimum length requirement
            const minPasswordLength = 5;
            if ($("#password").val().length < minPasswordLength) {
                alert("Password must be at least " + minPasswordLength + " characters long");
                return;
            }
            

            // Check if password and confirm password match
            if ($("#password").val() !== $("#cpassword").val()) {
                alert("Passwords do not match");
                return;
            }

            // If all checks pass, submit the form via AJAX
            $.post(ServletURL,
                $("#register").serialize(),
                function(responseText) {
                    if (responseText === "Data Not Entered Successfully") {
                        alert("Failed to register user. Please try again later.");
                    } else {
                        document.getElementById("register").reset();
                        $("#leftdiv").html(responseText);
                    }
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
			<input type="cpassword" id="cpassword" name="cpassword" autocomplete="off"><br>
			<label for="phone">Phone Number:</label><br>
			<input type="text" id="phone" name="phone" autocomplete="off"><br><br>
			<input type="submit" value="Submit" id="submitButton">
		</form>
	</div>
 </form>
</body>
</html>