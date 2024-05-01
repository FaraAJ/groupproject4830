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

<h1>Admin Table Edit Page</h1>

<table style="width:150%">

<form action="${pageContext.request.contextPath}/AdminTable" method="post">
	<label for ="table">Table Number<br></label>
	<select name="TableNum" id="TableNum">
  		<option value="Table1">Table1</option>
  		<option value="Table2">Table2</option>
  		<option value="Table3">Table3</option>
  		<option value="Table4">Table4</option>
  		<option value="Table5">Table5</option>
  		<option value="Table6">Table6</option>
  		<option value="Table7">Table7</option>
  		<option value="Table8">Table8</option>
	</select><br>
	<label for ="date">Date<br></label>
	<select name="Date" id="Date">
  		<option value="Monday">Monday</option>
  		<option value="Tuesday">Tuesday</option>
  		<option value="Wednesday">Wednesday</option>
  		<option value="Thursday">Thursday</option>
  		<option value="Friday">Friday</option>
	</select><br><br>
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

<br><a href="AdminTable"><button>BACK</button></a>

</body>
</html>