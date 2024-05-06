

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/login")
public class login extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	      response.getWriter().append("This is the Login Page!!!");

	 }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO actually make login check for correctness 
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
	      //as long as the connection isn't null, you can now use it for sql queries
	      if (connection != null) {
	          response.getWriter().println("Connected to database successfully.<br>");
	       }
	       else {
	          System.out.println("Failed to make connection!");
	       }
	      
	      try {
	    	  String sqlcommand = "Select * from users where name= '" + request.getParameterValues("username")[0] +"'";
	    	  PreparedStatement prepState = connection.prepareStatement(sqlcommand);
	    	  ResultSet rs = prepState.executeQuery();
	    	  rs.next();
	    	  String pword = rs.getString("password");
	    	  String admin = rs.getString("is_admin");
	    	  String id = rs.getString("id");	    	  
	    	  if (pword.equals(request.getParameterValues("password")[0])) {
	    		  if(Integer.parseInt(admin) == 1) {
	    			  //TODO THIS NEEDS TO GO TO ADMIN PAGE
	    			  response.sendRedirect("Admin.jsp");
	    		  }
	    		  else {
	    		  response.sendRedirect("displayTable.jsp?userid="+ id);
	    		  }
	    	  }
	    	  else {
	    		  
	    		  response.sendRedirect("login.jsp?invalid=true");
	    		  
	    	  }
	    	  
	    	  
	    	  
	      } catch (SQLException e) {
    		  response.sendRedirect("login.jsp?invalid=true");
    		  e.printStackTrace();
	      }
		

	}

}
