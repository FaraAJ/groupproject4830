import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.PreparedStatement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyReservationsServlet")
public class MyReservationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/techDB?useSSL=false&allowPublicKeyRetrieval=true";
    static String user = "bnokerremote";
    static String password = "password";
    Connection connection = null;
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;

        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish MySQL connection
            connection = DriverManager.getConnection(url, user, password);
            connection.setCatalog("groupDB");

            // Retrieve userid from request
            String userid = request.getParameter("userid").trim();
            //System.out.println(userid);

            // Define arrays for days, times, and tables
            String[] days = {"Monday", "Tuesday", "Wednesday", "Thursday", "Friday"};
            String[] times = {"400", "430", "500", "530", "600", "630", "700", "730"};
            String[] tables = {"table1", "table2", "table3", "table4", "table5", "table6", "table7", "table8"};

            // Construct HTML table rows with day and time values
            StringBuilder returnString = new StringBuilder();
            
            // Construct table header row
            returnString.append("<tr>");
            returnString.append("<th>Day</th>");
            returnString.append("<th>Time</th>");
            returnString.append("</tr>");

            // Iterate through tables, days, and times
            for (String table : tables) {
                for (String day : days) {
                    for (String time : times) {
                    	preparedStatement = connection.prepareStatement("SELECT * FROM " + table + " WHERE day = '" + day + "' AND `" + time + "` = '" + userid + "'");
                        resultSet = preparedStatement.executeQuery();
                        
                        
                        // Process the resultSet here and append to returnString
                        while (resultSet.next()) {
                            String dayValue = resultSet.getString(day);
                            String timeValue = resultSet.getString(time);

                            returnString.append("<tr>");
                            returnString.append("<td>").append(dayValue).append("</td>");
                            returnString.append("<td>").append(timeValue).append("</td>");
                            returnString.append("</tr>");
                        }
                    }  
                }
            }
            
            // Construct HTML table closing tag
            returnString.append("</table>");

            // Send the HTML table rows back as the servlet response
            response.setContentType("text/html");
            response.getWriter().append(returnString);
        } catch (ClassNotFoundException e) {
            // Handle ClassNotFound exception
            System.out.println("The MySQL JDBC Driver is missing :(");
            e.printStackTrace();
        } catch (SQLException e) {
            // Handle SQL exceptions
            System.out.println("Connection Failed! Check output console");
            e.printStackTrace();
        } finally {
            // Close resultSet, preparedStatement, and connection
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}