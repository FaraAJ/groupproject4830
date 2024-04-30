<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Admin EDIT</title>
</head>
<body>

<h1>Admin Edit Page</h1>

<table style="width:150%">

<form action="${pageContext.request.contextPath}/AdminTable" method="post">
	<label for ="Date">Date<br></label>
	<input type="text" id="Date" name="Date" /><br>
	<label for ="400">4:00<br></label>
	<input type="text" id="four" name="four" /><br>
	<label for ="430">4:30<br></label>
	<input type="text" id="four30" name="four30" /><br>
	<label for ="500">5:00<br></label>
	<input type="text" id="five" name="five" /><br>
	<label for ="530">5:30<br></label>
	<input type="text" id="five30" name="five30" /><br>
	<label for ="600">6:00<br></label>
	<input type="text" id="six" name="six" /><br>
	<label for ="630">6:30<br></label>
	<input type="text" id="six30" name="six30" /><br>
	<label for ="700">7:00<br></label>
	<input type="text" id="seven" name="seven" /><br>
	<label for ="730">7:30<br></label>
	<input type="text" id="seven30" name="seven30" /><br>
	<br><br>
	<input type="submit" value="Submit" id="submitButton">
</form>

</table>

</body>
</html>