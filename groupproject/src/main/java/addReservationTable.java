import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addReservationTable
 */
@WebServlet("/addReservationTable")
public class addReservationTable extends HttpServlet {
    private static final long serialVersionUID = 1L;
    static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
    static String user = "bnokerremote";
    static String password = "password";

    public addReservationTable() {
        super();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        // Create reservations table if it doesn't exist
        createReservationsTable();

        // Handle reservation form data
        saveReservation(request, response);
    }

    private void createReservationsTable() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("The MySQL JDBC Driver is missing :(");
            e.printStackTrace();
            return;
        }

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setCatalog("groupDB");

            String createTableSQL = "CREATE TABLE IF NOT EXISTS reservations ("
                    + "id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "name VARCHAR(255) NOT NULL,"
                    + "phone VARCHAR(15) NOT NULL,"
                    + "day VARCHAR(10) NOT NULL,"
                    + "time VARCHAR(5) NOT NULL)";

            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableSQL);
            statement.close();
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void saveReservation(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String phone = request.getParameter("phone");
        String day = request.getParameter("date");
        String time = request.getParameter("time");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(url, user, password);
            connection.setCatalog("groupDB");

            String insertSQL = "INSERT INTO reservations (name, phone, day, time) VALUES (?, ?, ?, ?)";
            PreparedStatement pstmt = connection.prepareStatement(insertSQL);
            pstmt.setString(1, name);
            pstmt.setString(2, phone);
            pstmt.setString(3, day);
            pstmt.setString(4, time);

            int affectedRows = pstmt.executeUpdate();

            if (affectedRows > 0) {
                response.getWriter().println("Reservation saved successfully!<br>");
            } else {
                response.getWriter().println("Error saving reservation.<br>");
            }

            pstmt.close();
            connection.close();
        } catch (SQLException e) {
            response.getWriter().println("Error saving reservation.<br>");
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
