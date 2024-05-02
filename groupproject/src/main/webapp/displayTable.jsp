<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Customer Reservation Table</title>
	<style>
		.days input {display: none;}
		.days label {display: block;}
		.days input + div {background: white;}
		.days input + div label {
			padding: 53.3px;
			cursor: pointer;
			border: 2px solid black;
		}
		.days input:checked + div {background: green;}
		
		.times input {display: none;}
		.times label {display: block;}
		.times input + div {background: white;}
		.times input + div label {
			padding: 29px;
			cursor: pointer;
			border: 2px solid black;
		}
		.times input:checked + div {background: green;}
		
		.rsv input {display:none;}
		.rsv label {display: block;}
		.rsv input + div {background: white;}
		.rsv input + div label {
			cursor: pointer;
			padding: 28.9px;
			border: 2px solid black;
		}
		.rsv input:checked + div {background: green;}
		
		body {
			height: 100%; margin: 0;
		}
		
		.bg {background-image: url("rsv_b_image.jpg"); height: 100%; background-position: center; background-repeat: no-repeat; background-size: cover;}
	</style>
	
	<script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
        <script>
        const ServletURL = "${pageContext.request.contextPath}/rsvHandler";
        const rsvServletURL = "${pageContext.request.contextPath}/MyReservationsServlet";
		$(document).on("click", "#submitButton", function(event) {
			event.preventDefault();
			if($('input[name=days]:checked').length == 0) {
				alert("Select day!");
			} else if($('input[name=times]:checked').length == 0) {
				alert("Select time!");
			} else if($('input[name=tables]:checked').length == 0) {
				alert("Select table!");
			} else {
				$.post(ServletURL, $("#inputForm").serialize(), function(responseText) {
					$("#messageContainer").text(responseText);
				});
				
				$.post(rsvServletURL, $("#inputForm").serialize(), function(responseText) {
					$("#rsvmessageContainer").text(responseText);
				});
				
			}
		});
	</script>
		
</head>
<body>
<div class = "bg">
<form action="" id="inputForm">
<input type="hidden" name="userid" value=<%= request.getParameter("userid") %>>
<div class="rsv" id="tableList" style="float:right; margin-left: 10px; width:30%; text-align: center; border: 2px solid black; background-color: white;">
|Tables|
	<input type="radio" id="table1" name="tables" value="table1">
	<div><label for="table1">TABLE 1</label></div>
	<input type="radio" id="table2" name="tables" value="table2">
	<div><label for="table2">TABLE 2</label></div>
	<input type="radio" id="table3" name="tables" value="table3">
	<div><label for="table3">TABLE 3</label></div>
	<input type="radio" id="table4" name="tables" value="table4">
	<div><label for="table4">TABLE 4</label></div>
	<input type="radio" id="table5" name="tables" value="table5">
	<div><label for="table5">TABLE 5</label></div>
	<input type="radio" id="table6" name="tables" value="table6">
	<div><label for="table6">TABLE 6</label></div>
	<input type="radio" id="table7" name="tables" value="table7">
	<div><label for="table7">TABLE 7</label></div>
	<input type="radio" id="table8" name="tables" value="table8">
	<div><label for="table8">TABLE 8</label></div>
</div>
<div class="days" id="dayList" style="float:left; margin-right: 10px; width:30%; text-align: center; border: 2px solid black; background-color: white;">
|Day of the Week|
		<input type="radio" id="monday" name="days" value="Monday">
		<div><label for="monday">Monday</label></div>
		<input type="radio" id="tuesday" name="days" value="Tuesday">
		<div><label for="tuesday">Tuesday</label></div>
		<input type="radio" id="wednesday" name="days" value="Wednesday">
		<div><label for="wednesday">Wednesday</label></div>
		<input type="radio" id="thursday" name="days" value="Thursday">
		<div><label for="thursday">Thursday</label></div>
		<input type="radio" id="friday" name="days" value="Friday">
		<div><label for="friday">Friday</label></div>
</div>

<div class="times" id="timeList" style="width: 30%; text-align: center; margin: 0 auto; border: 2px solid black; background-color: white;">
|Time of Day|
		<input type="radio" id="0400" name="times" value="400">
		<div><label for="0400">4:00-4:30</label></div>
		<input type="radio" id="0430" name="times" value="430">
		<div><label for="0430">4:30-5:00</label></div>
		<input type="radio" id="0500" name="times" value="500">
		<div><label for="0500">5:00-5:30</label></div>
		<input type="radio" id="0530" name="times" value="530">
		<div><label for="0530">5:30-6:00</label></div>
		<input type="radio" id="0600" name="times" value="600">
		<div><label for="0600">6:00-6:30</label></div>
		<input type="radio" id="0630" name="times" value="630">
		<div><label for="0630">6:30-7:00</label></div>
		<input type="radio" id="0700" name="times" value="700">
		<div><label for="0700">7:00-7:30</label></div>
		<input type="radio" id="0730" name="times" value="730">
		<div><label for="0730">7:30-8:00</label></div>
		
</div>

<div style="bottom: 0; text-align: center; width: 100%; margin-top: 5px">
		<div id="messageContainer" style="background-color: white; display: inline-block; margin-bottom: 5px; border: 2px solid black;"></div><br>
		<input type="submit" value="Reserve Table" id="submitButton"><br>

</div>
</form>

		<div style="text-align: center; width: 100%; margin-top: 5px">
			<script>
			function func(){
				const str = window.location.search;
				const param = new URLSearchParams(str);
				const id = param.get("userid");
				window.location.href = "myReservations.jsp?userid="+id;
				
			}
			</script>
					
			<a onclick= "func();">
				<button>My Reservations</button>
			</a>
		</div>
</div>
</body>	
</html>