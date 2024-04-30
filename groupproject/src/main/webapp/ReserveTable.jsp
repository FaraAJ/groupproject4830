<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reserve Table</title>
</head>
<body>
    <h1>Reserve a Table</h1>
    <form action="addReservationTable" method="post">
        
        <!-- Name Input -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <!-- Phone Input -->
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" required pattern="[0-9]{10}"><br><br>
        
        <!-- Date Dropdown -->
        <label for="date">Date:</label>
        <select id="date" name="date" required>
            <option value="Monday">Monday</option>
            <option value="Tuesday">Tuesday</option>
            <option value="Wednesday">Wednesday</option>
            <option value="Thursday">Thursday</option>
            <option value="Friday">Friday</option>
        </select><br><br>
        
        <!-- Time Dropdown -->
        <label for="time">Time:</label>
        <select id="time" name="time" required>
            <% 
            for (int hour = 4; hour <= 7; hour++) { // From 4:00 PM to 7:00 PM
                for (int minute = 0; minute <= 30; minute += 30) { // 30-minute increments
                    String timeSlot = String.format("%02d%02d", hour, minute);
                    out.println("<option value='" + timeSlot + "'>" + hour + ":" + String.format("%02d", minute) + " PM</option>");
                }
            }
            %>
        </select><br><br>
        
        <!-- Submit Button -->
        <input type="submit" value="Reserve">
    </form>
</body>
</html>
