
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
@WebServlet("/AdminUser")
public class AdminUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminUser() {
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
	    	  response.getWriter().append("<title>Admin Users</title>");
	    	  response.getWriter().append("<link rel=\"shortcut icon\" href=\"favicon.ico\"/>");
	    	  response.getWriter().append("<a href=\"Admin.jsp\"><button>HOME</button></a><br>");
	    	  
	    	  String commander = "Select * from users";
	    			    
	    		  PreparedStatement prepState = connection.prepareStatement(commander);
	    		  ResultSet rs = prepState.executeQuery();
	    		  
	    		  response.getWriter().append("<div style=\"white-space:pre\">");
	    		  
	    		  response.getWriter().append("<h3>User List</h3>");
	    		  
	    		  
	    		  String dashes = "+-----------";
	    		  for (int x = 0; x < 3; x++) {
	    			  dashes = dashes + "+-----------";
	    		  }
	    		  
	    		  response.getWriter().append(dashes + "+" + "<br>");
	    		  response.getWriter().append("|     id      |     name     |     password     |     phone     |" + "<br>");
	    		  response.getWriter().append(dashes + "+" + "<br>");
	    		  while(rs.next()) {
	    			  
	    			  response.getWriter().append("| " + rs.getString("id") + " |    " + rs.getString("name") + "     |     " + rs.getString("password") + "     |     " + rs.getString("phone") + "     |     " + "<br>");
	    			  
	    			  response.getWriter().append(dashes + "+" + "<br>");
	    			  
	    		  }
		    
	    		  response.getWriter().append("<a href=\"AdminUserEdit.jsp\"><button>EDIT</button></a><br><br>");
	    		  response.getWriter().append("</div>");
	    	
		    
	      } catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
	      
		  response.getWriter().append("<br><a href=\"Admin.jsp\"><button>HOME</button></a>");  
		  
	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("Name").trim();
		String pass = request.getParameter("Password").trim();
		String phon = request.getParameter("Phone").trim();
		
		String sqldelete = "DELETE FROM users WHERE name = ?";
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true", "bnokerremote", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(sqldelete)) {
				
			preparedStatement.setString(1, userName);
			
	        int col = preparedStatement.executeUpdate();
	        
	        System.out.println(col);	
	        
			preparedStatement.close();
			
		} catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
		
		String sqladd = "INSERT INTO users (name, password, phone) VALUES (?, ?, ?)";
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true", "bnokerremote", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(sqladd)) {

			preparedStatement.setString(1, userName);
			preparedStatement.setString(2, pass);
			preparedStatement.setString(3, phon);
			
			int row = preparedStatement.executeUpdate();

			System.out.println(row);
			
			preparedStatement.close();
			
		} catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br><br>");
	    	  e.printStackTrace();
	      }
		doGet(request, response);
	}	
}