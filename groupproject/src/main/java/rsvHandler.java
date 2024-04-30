

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class rsvHandler
 */
@WebServlet("/rsvHandler")
public class rsvHandler extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public rsvHandler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		// response.getWriter().append("Served at: ").append(request.getContextPath());

	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
response.setContentType("text/html;charset=UTF-8");
		
		try {
	         Class.forName("com.mysql.cj.jdbc.Driver");// ("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.out.println("The MySQL JDBC Driver is missing :(");
	         e.printStackTrace();
	         return;
	      }
		try {
	          connection = DriverManager.getConnection(url, user, password);
	          connection.setCatalog("groupDB"); 
	      } catch (SQLException e) {
	          System.out.println("Connection Failed! Check output console");
	          e.printStackTrace();
	          return;
	       }
		if (connection != null) {
			System.out.println("Connected to database successfully.");
	       }
	       else {
	          System.out.println("Failed to make connection!");
	       }
		
		// TODO need to get mySQL tables displaying onto displayTable
		try {
			response.setContentType("text/html");
			String selectedDay = request.getParameter("days").trim();
			String time = request.getParameter("times").trim();
			String table = request.getParameter("tables").trim();
			System.out.println(selectedDay);
			System.out.println(time);
			System.out.println(table);
	    	String sqlcommand = "SELECT * FROM "+ table + " WHERE day=\'" + selectedDay + "\';";
	    	System.out.println(sqlcommand);
	    	PreparedStatement prepState = connection.prepareStatement(sqlcommand);
	    	ResultSet rs = prepState.executeQuery();

	    	if (rs.next()) {
	    		System.out.println(rs.getString(time));
	    		if (rs.wasNull()) {
	    			System.out.println("Null detected");
	    			String message = "Reservation is empty";
	    			response.setContentType("text/plain");
	    		    response.setCharacterEncoding("UTF-8");
	    		    response.getWriter().write(message);
	    		    response.getWriter().close();
	    		}
	    		else {
	    			String message = "Reservation is already filled";
	    			response.setContentType("text/plain");
	    		    response.setCharacterEncoding("UTF-8");
	    		    response.getWriter().write(message);
	    		    response.getWriter().close();
	    			
	    		}
	    		
	    		request.getRequestDispatcher("displayTable.jsp").forward(request, response);
	    	}
	    
		} catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();

	}

}
