

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Usercreator
 */
@WebServlet("/Usercreator")
public class Usercreator extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Usercreator() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=UTF-8");
		
		// Retrieve user information from request parameters
        String username = request.getParameter("createUsername");
        String password = request.getParameter("createPassword");
        String phone = request.getParameter("createPhone");
        
     // Validate user information
        if (username == null || password == null || phone == null ||
            username.isEmpty() || password.isEmpty() || phone.isEmpty()) {
            response.getWriter().append("All fields are required");
            return;
        }
        
        
     // Establish database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            response.getWriter().println("The MySQL JDBC Driver is missing :(");
            e.printStackTrace();
            return;
        }

        try (Connection connection = DriverManager.getConnection(url, user, password);
             PreparedStatement pstmt = connection.prepareStatement(
                     "INSERT INTO users (name, password, phone) VALUES (?, ?, ?)")) {

            // Set parameters for the SQL query
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, phone);

            // Execute the SQL query
            int rowsAffected = pstmt.executeUpdate();

            // Check if user was saved successfully
            if (rowsAffected > 0) {
                response.getWriter().append("User created and saved to database successfully");
            } else {
                response.getWriter().append("Error saving user to database");
            }

        } catch (SQLException e) {
            response.getWriter().println("SQL Exception occurred. <br>");
            e.printStackTrace();
        }
	}

}
