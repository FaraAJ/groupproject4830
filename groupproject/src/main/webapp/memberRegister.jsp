<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New User Registration</title>
</head>
<body>
 <form action="Register" method="post">
 <table>
	 <tr>
	 <td>User Name</td>
	 <td><input type="text" name="username"></td> </tr>
	 <tr>
	 <td>Password</td>
	 <td><input type="password" name="password"></td>
	 </tr>
	 <tr>
	 <td>Phone</td>
	 <td><input type="text" name="phone"></td>
	 </tr>
	 <tr>
	 <td>Submit</td>
	 <td><input type="submit" value="register"></td>
	 </tr>
 </table>
 </form>
</body>
</html>