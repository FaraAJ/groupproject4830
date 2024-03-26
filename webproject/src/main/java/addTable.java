

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class addTable
 */
@WebServlet("/addTable")
public class addTable extends HttpServlet {
	private static final long serialVersionUID = 1L;
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/myDB?useSSL=false&allowPublicKeyRetrieval=true";
	static String user = "bnokerremote";
	static String password = "password";
	Connection connection = null;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public addTable() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
	      
	      //makes a table for a table i.e. a table table.
	      //TODO make a table table table?
	      
	      //false so it doesn't run unless we explicitly want it to
	      boolean run = false;
	      int num = 2;
	      if (run) {
	      try {
	    	  Statement sqlstate = connection.createStatement();
	    	  String sqlstring = "create table table"+ num +
	    			  " (day varchar(10) not null, "+
	    			  " `400` int,"+
	    			  " `430` int,"+
	    			  " `500` int,"+
	    			  " `530` int,"+
	    			  " `600` int,"+
	    			  " `630` int,"+
	    			  " `700` int,"+
	    			  " `730` int)"
	    			  ;
	    	  sqlstate.executeUpdate(sqlstring);
	    	  sqlstate.executeUpdate("insert into table"+num+" (day) values ('Monday')");
	    	  sqlstate.executeUpdate("insert into table"+num+" (day) values ('Tuesday')");
	    	  sqlstate.executeUpdate("insert into table"+num+" (day) values ('Wednesday')");
	    	  sqlstate.executeUpdate("insert into table"+num+" (day) values ('Thursday')");
	    	  sqlstate.executeUpdate("insert into table"+num+" (day) values ('Friday')");
	    	  response.getWriter().println("table"+num+" created successfully<br>");

	      } catch (SQLException e) {
	    	  response.getWriter().println("SQL table maker didn't run right<br>");
	    	  e.printStackTrace();
	      }
	      } else {
	    	  response.getWriter().println("No table made, run set to false <br>");
	      }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
