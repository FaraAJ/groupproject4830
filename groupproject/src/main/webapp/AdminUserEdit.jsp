<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin EDIT</title>
<link rel="shortcut icon" href="favicon.ico"/>
</head>
<body>

<h1>Admin User Edit Page</h1>

<table style="width:150%">

<form action="${pageContext.request.contextPath}/AdminUser" method="post">
	<label for ="Name">Name<br></label>
	<input type="text" id="Name" name="Name" /><br>
	<label for ="Password">Password<br></label>
	<input type="text" id="Password" name="Password" /><br>
	<label for ="Phone">Phone<br></label>
	<input type="text" id="Phone" name="Phone" />
	<br><br>
	<input type="submit" value="Submit" id="submitButton">
</form>

</table>

<br><a href="AdminUser"><button>BACK</button></a>

</body>
</html>