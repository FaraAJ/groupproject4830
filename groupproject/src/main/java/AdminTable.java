
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Table
 */
@WebServlet("/AdminTable")
public class AdminTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html;charset=UTF-8");
	      //this gets the driver
	      try {
	         Class.forName("com.mysql.cj.jdbc.Driver");// ("com.mysql.jdbc.Driver");
	      } catch (ClassNotFoundException e) {
	         System.out.println("The MySQL JDBC Driver is missing :(");
	         e.printStackTrace();
	         return;
	      }
	      connection = null;
	      //this changes the connection from null to the sql database
	      try {
	          connection = DriverManager.getConnection(url, user, password);
	          connection.setCatalog("groupDB"); 
	       } catch (SQLException e) {
	          System.out.println("Connection Failed! Check output console");
	          e.printStackTrace();
	          return;
	       }
		//if connection NOT = null, can be used for sql queries
	      if (connection != null) {
	    	  System.out.println("Connected to database successfully.<br>");
	       }
	      else {
	          System.out.println("Failed to make connection!");
	       }
		
	      try {
	    	  String sqlcommand = "Select * from table1";
	    	  PreparedStatement prepState = connection.prepareStatement(sqlcommand);
	    	  ResultSet rs = prepState.executeQuery();
	    	  
	    	  response.getWriter().append("<a href=\"AdminEdit.jsp\"><button>EDIT</button></a><br><br>");
		      response.getWriter().append("<div style=\"white-space:pre\">");
	    	  
		      String dashes = "+-----------";
		      for (int x = 0; x < 8; x++) {
		    	  dashes = dashes + "+-----------";
		      }
		      
		      response.getWriter().append(dashes + "+" + "<br>");
		      response.getWriter().append("|     day      |     400     |     430     |     500     |     530     |     600      |     630     |     700     |     730     |" + "<br>");
		      response.getWriter().append(dashes + "+" + "<br>");
		    while(rs.next()) {
		    	
		    	response.getWriter().append("| " + rs.getString("day") + " |    " + rs.getString("400") + "     |     " + rs.getString("430") + "     |     " + rs.getString("500") + "     |     " + rs.getString("530") + "     |     " + rs.getString("600") + "     |     " + rs.getString("630") + "     |     " + rs.getString("700") + "     |     " + rs.getString("730") + "     |     " + "<br>");
		    	
		    	response.getWriter().append(dashes + "+" + "<br>");
	    		
			}
		    
		    response.getWriter().append("</div>");
	    	response.getWriter().append("<br><a href=\"AdminEdit.jsp\"><button>EDIT</button></a>");
	    	
		    
	      } catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String Date = request.getParameter("Date").trim();
		String four = request.getParameter("four").trim();
		String four30 = request.getParameter("four30").trim();
		String five = request.getParameter("five").trim();
		String five30 = request.getParameter("five30").trim();
		String six = request.getParameter("six").trim();
		String six30 = request.getParameter("six30").trim();
		String seven = request.getParameter("seven").trim();
		String seven30 = request.getParameter("seven30").trim();
		
		try {
			String sqlcommand = "INSERT INTO tabel1 (day, 400, 430, 500, 530, 600, 630, 700) VALUES ('" + Date + "', '" + four + "', '" + four30 + "', '" + five + "', '" + five30 + "', '" + six + "', '" + six30 + "', '" + seven + "', '" + seven30 + "', now())";
			PreparedStatement prepState = connection.prepareStatement(sqlcommand);
			int rs = prepState.executeUpdate();
		} catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br><br>");
	    	  e.printStackTrace();
	      }
		
		doGet(request, response);
		
	}

}