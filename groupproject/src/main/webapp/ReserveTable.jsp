<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Reserve Table</title>
</head>
<body>
    <h1>Reserve a Table</h1>
    <form action="processReservation" method="post">
        
        <!-- Name Input -->
        <label for="name">Name:</label>
        <input type="text" id="name" name="name" required><br><br>
        
        <!-- Phone Input -->
        <label for="phone">Phone Number:</label>
        <input type="tel" id="phone" name="phone" required pattern="[0-9]{10}"><br><br>
        
        <!-- Date Dropdown -->
        <label for="date">Date:</label>
        <select id="date" name="date" required>
            <%
            try {
                String dburl = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
                String user = "bnokerremote";
                String password = "password";
                String dbdriver = "com.mysql.jdbc.Driver";

                Class.forName(dbdriver);
                Connection con = DriverManager.getConnection(dburl, user, password);
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT day FROM addTable");
                
                while (rs.next()) {
                    String day = rs.getString("day");
                    out.println("<option value='" + day + "'>" + day + "</option>");
                }

                con.close();
            } catch (Exception e) {
                out.println("Error fetching days: " + e.getMessage());
                e.printStackTrace();
            }
            %>
        </select><br><br>
        
        <!-- Time Dropdown -->
        <label for="time">Time:</label>
        <select id="time" name="time" required>
            <%
            try {
                String dburl = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
                String user = "bnokerremote";
                String password = "password";
                String dbdriver = "com.mysql.jdbc.Driver";

                Class.forName(dbdriver);
                Connection con = DriverManager.getConnection(dburl, user, password);
                Statement stmt = con.createStatement();

                ResultSet rs = stmt.executeQuery("SELECT COLUMN_NAME FROM INFORMATION_SCHEMA.COLUMNS WHERE TABLE_NAME='addTable' AND COLUMN_NAME != 'day'");
                
                while (rs.next()) {
                    String timeSlot = rs.getString("COLUMN_NAME");
                    out.println("<option value='" + timeSlot + "'>" + timeSlot + "</option>");
                }

                con.close();
            } catch (Exception e) {
                out.println("Error fetching time slots: " + e.getMessage());
                e.printStackTrace();
            }
            %>
        </select><br><br>
        
        <!-- Submit Button -->
        <input type="submit" value="Reserve">
    </form>
</body>
</html>
