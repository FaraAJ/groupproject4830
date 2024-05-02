<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>My Reservations</title>
    <style>
        table {
            border-collapse: collapse;
            width: 100%;
        }
        th, td {
            border: 1px solid #dddddd;
            text-align: left;
            padding: 8px;
        }
        th {
            background-color: #f2f2f2;
        }
    </style>
            <script src="https://code.jquery.com/jquery-3.7.1.min.js"></script>
    <script>
    const servletURL = "${pageContext.request.contextPath}/MyReservationsServlet";
    $(document).ready(function(){
    	$.post(servletURL,function(responseText){
    		$("#tablebody").html(responseText);
    	})
    });
		
    </script>
</head>
<body>

<h2>My Reservations</h2>

<table>
    <thead>
        <tr>
            <th>Table</th>
            <th>Day</th>
            <th>Time</th>
        </tr>
    </thead>
    <tbody id="tablebody">
    </tbody>
</table>

</body>
</html>
