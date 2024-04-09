<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="java.sql.*, java.util.ArrayList" %>
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
                out.println("<input type='radio' id='" + day.toLowerCase() + "' name='day' value='" + day + "'>");
                out.println("<div><label for='" + day.toLowerCase() + "'>" + day + "</label></div>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </form>
</div>

<div id="tableList" style="float:right; margin-left: 10px; width:33%; text-align: center; border: 2px solid black">
    |Tables|
    <form>
        <% 
        try {
            String dburl = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
            String user = "bnokerremote";
            String password = "password";
            String dbdriver = "com.mysql.jdbc.Driver";

            Class.forName(dbdriver);
            Connection con = DriverManager.getConnection(dburl, user, password);
            Statement stmt = con.createStatement();

            ResultSet rs = stmt.executeQuery("SELECT table_name FROM information_schema.tables WHERE table_schema = 'myDB' AND table_name != 'addTable'");
            
            while (rs.next()) {
                String tableName = rs.getString("table_name");
                out.println("<input type='checkbox' id='" + tableName.toLowerCase() + "' name='table' value='" + tableName + "'>");
                out.println("<div><label for='" + tableName.toLowerCase() + "'>" + tableName + "</label></div>");
            }

            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        %>
    </form>
</div>

<div id="timeList" style="width:33%; text-align: center; margin: 0 auto; border: 2px solid black">
    |Time of Day|
    <select name="time">
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
            e.printStackTrace();
        }
        %>
    </select>
</div>

</body>
</html>
