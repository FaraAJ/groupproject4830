<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Reservation Table</title>
</head>
<body>
<div id="dayList" style="float:left; margin-right: 10px; width:33%; text-align: center; border: 2px solid black">
|Day of the Week|
	<form>
		
		<input type="radio" id="monday" name="monday" value="Monday">
		<div><label for="monday">Monday</label></div>
	</form>
</div>
<div id="tableList" style="float:right; margin-left: 10px; width:33%; text-align: center; border: 2px solid black">
|Tables|
</div>
<div id="timeList" style="width:33%; text-align: center; margin: 0 auto; border: 2px solid black">
|Time of Day|
</div>
</body>
</html>