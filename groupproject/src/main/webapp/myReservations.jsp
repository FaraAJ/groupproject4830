<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Reservations</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f9f9f9;
        }
        h2 {
            text-align: center;
            margin-top: 20px;
            color: #333;
            text-shadow: 2px 2px 4px rgba(0, 0, 0, 0.2);
        }
        table {
            border-collapse: collapse;
            width: 80%;
            margin: 20px auto;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 12px;
        }
        th {
            background-color: #f2f2f2;
        }
        .button {
            display: inline-block;
            padding: 10px 20px;
            background-color: #007bff;
            color: white;
            text-decoration: none;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            transition: background-color 0.3s ease;
        }
        .button:hover {
            background-color: #0056b3;
        }
        .button + .button {
            margin-left: 10px;
        }
    </style>
            <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
   
    $(document).ready(function(){
   	    const str = window.location.search;
   		const param = new URLSearchParams(str);
   		const id = param.get("userid");
   		const servletURL = "${pageContext.request.contextPath}/MyReservationsServlet?userid="+id;
    	$.post(servletURL,function(responseText){
    		$("#tablebody").html(responseText);
    	})
    });
		
    </script>
</head>
<body>

<h2 style="font-size: 28px; font-weight: bold;">My Reservations</h2>

<table>
    <thead>
        <tr>
            <th>Table</th>
            <th>Day</th>
            <th>Time</th>
        </tr>
    </thead>
    <tbody id="tablebody">
    	<tr><td>loading...</td></tr>
    </tbody>
</table>

<div style="text-align: center; margin-top: 20px;">
    <a href="displayTable.jsp" class="button">Back</a> 
    <a href="login.jsp" class="button">Logout</a>
</div>

</body>
</html>
