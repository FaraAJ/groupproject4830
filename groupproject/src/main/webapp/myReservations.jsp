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
    <tbody>
        <tr>
            <td>${table}</td>
            <td>${day}</td>
            <td>${time}</td>
        </tr>
    </tbody>
</table>

</body>
</html>
