
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
	static String url = "jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true";
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
	    	  response.getWriter().append("<title>Admin Table</title>");
	    	  response.getWriter().append("<link rel=\"shortcut icon\" href=\"favicon.ico\"/>");
	    	  response.getWriter().append("<a href=\"Admin.jsp\"><button>HOME</button></a><br>");
	    	  String[] sqlCommands = new String[] {
	    			    "Select * from table1",
	    			    "Select * from table2",
	    			    "Select * from table3",
	    			    "Select * from table4",
	    			    "Select * from table5",
	    			    "Select * from table6",
	    			    "Select * from table7",
	    			    "Select * from table8"
	    			};

	    	  for (int xx = 0; xx < sqlCommands.length; xx++) {
	    		  	String command = sqlCommands[xx];
	    			
	    		  PreparedStatement prepState = connection.prepareStatement(command);
	    		  ResultSet rs = prepState.executeQuery();
	    		  
	    		  response.getWriter().append("<div style=\"white-space:pre\">");
	    		  
	    		  response.getWriter().append(String.format("<h3>Table %s</h3>", xx + 1));
	    		  
	    		  
	    		  String dashes = "+--------------------";
	    		  for (int x = 0; x < 8; x++) {
	    			  dashes = dashes + "+--------------------";
	    		  }
	    		  
	    		  double colLen = 13;
	    		  
	    		  response.getWriter().append(dashes + "+" + "<br>");
	    		  response.getWriter().append("|" + spaceMaker((colLen) - 4) + "<b>day </b>" + spaceMaker((colLen) - 4) + "|" + spaceMaker((colLen - 5)) + "<b>4:00</b>" + spaceMaker((colLen - 5)) + "|" + spaceMaker((colLen - 5)) + "<b>4:30 </b>" + spaceMaker((colLen - 5)) + "|" + spaceMaker((colLen - 5)) + "<b>5:00 </b>" + spaceMaker((colLen - 5)) + "|" + spaceMaker((colLen - 5)) + "<b>5:30 </b>" + spaceMaker((colLen - 5)) + "|" + spaceMaker((colLen - 5)) + "<b>6:00 </b>" + spaceMaker((colLen - 5)) + "|" + spaceMaker((colLen - 5)) + "<b>6:30 </b>" + spaceMaker((colLen - 5)) + "|" + spaceMaker((colLen - 5)) + "<b>7:00 </b>" + spaceMaker((colLen - 5)) + "|" + spaceMaker((colLen - 5)) + "<b>7:30</b>" + spaceMaker((colLen - 5)) + "|" + "<br>");
	    		  response.getWriter().append(dashes + "+" + "<br>");
	    		  while(rs.next()) {
	    			  
	    			  response.getWriter().append("|" + spaceMaker((colLen - ((rs.getString("day")).length() + 1))) + rs.getString("day") + spaceMaker((colLen - ((rs.getString("day")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("400")).length() + 1))) + rs.getString("400") + spaceMaker((colLen - ((rs.getString("400")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("430")).length() + 1))) + rs.getString("430") + spaceMaker((colLen - ((rs.getString("430")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("500")).length() + 1))) + rs.getString("500") + spaceMaker((colLen - ((rs.getString("500")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("530")).length() + 1))) + rs.getString("530") + spaceMaker((colLen - ((rs.getString("530")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("600")).length() + 1))) + rs.getString("600") + spaceMaker((colLen - ((rs.getString("600")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("630")).length() + 1))) + rs.getString("630") + spaceMaker((colLen - ((rs.getString("630")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("700")).length() + 1))) + rs.getString("700") + spaceMaker((colLen - ((rs.getString("700")).length() + 1))) + "|" + spaceMaker((colLen - ((rs.getString("730")).length() + 1))) + rs.getString("730") + spaceMaker((colLen - ((rs.getString("730")).length() + 1))) + "|" + "<br>");
	    			  
	    			  response.getWriter().append(dashes + "+" + "<br>");
	    			  
	    		  }
		    
	    		  response.getWriter().append("<a id=\"TableEdit"+ Integer.toString(xx) + "\" href=\"AdminTableEdit.jsp\"><button>EDIT</button></a><br><br>");
	    		  response.getWriter().append("</div>");
	    	
	    	  }
		    
	      } catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
	      
		  response.getWriter().append("<br><a href=\"Admin.jsp\"><button>HOME</button></a>");  
		  
	}
	
	public String spaceMaker(double num) {
		//System.out.println("This is num: " + num);
		  String result = "";
		  if(num % 1 != 1) {
			  for(int x = 0; x <= num + 1; x++) {
				  result = result + " ";
			  }
		  }
		  else {
			  for(int x = 0; x < num; x++) {
				  result = result + " ";
			  }
		  }
		  return result;
	  }
	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String TableNum = request.getParameter("TableNum").trim();
		String Date_ = request.getParameter("Date").trim();
		String four_ = request.getParameter("four").trim();
		String four30_ = request.getParameter("four30").trim();
		String five_ = request.getParameter("five").trim();
		String five30_ = request.getParameter("five30").trim();
		String six_ = request.getParameter("six").trim();
		String six30_ = request.getParameter("six30").trim();
		String seven_ = request.getParameter("seven").trim();
		String seven30_ = request.getParameter("seven30").trim();
		
		try {
			String commandd = "Select * from " + TableNum.toLowerCase() + " WHERE day = ?";
			try (PreparedStatement prepState = connection.prepareStatement(commandd)) {
	            prepState.setString(1, Date_); 
	            
	            ResultSet rs = prepState.executeQuery();
			
			while(rs.next()) {
				if (four_ == "") {
					four_ = rs.getString("400");
				}
				if (four30_ == "") {
					four30_ = rs.getString("430");
				}
				if (five_ == "") {
					five_ = rs.getString("500");
				}
				if (five30_ == "") {
					five30_ = rs.getString("530");
				}
				if (six_ == "") {
					six_ = rs.getString("600");
				}
				if (six30_ == "") {
					six30_ = rs.getString("630");
				}
				if (seven_ == "") {
					seven_ = rs.getString("700");
				}
				if (seven30_ == "") {
					seven30_ = rs.getString("730");
				} 
			}
		
			prepState.close();
			
			}
			
		} catch (SQLException e) {
	    	  response.getWriter().println("SQL Exception occured. <br>");
	    	  e.printStackTrace();
	      }
		
		String sqlupdate = "UPDATE " + TableNum.toLowerCase() + " SET `400` = ?, `430` = ?, `500` = ?, `530` = ?, `600` = ?, `630` = ?, `700` = ?, `730` = ? WHERE day = ?";
		System.out.println(sqlupdate);
		
		try (Connection conn = DriverManager.getConnection(
				"jdbc:mysql://ec2-174-129-188-22.compute-1.amazonaws.com:3306/groupDB?useSSL=false&allowPublicKeyRetrieval=true", "bnokerremote", "password");
             PreparedStatement preparedStatement = conn.prepareStatement(sqlupdate)) {

			preparedStatement.setString(1, four_);
			preparedStatement.setString(2, four30_);
			preparedStatement.setString(3, five_);
			preparedStatement.setString(4, five30_);
			preparedStatement.setString(5, six_);
			preparedStatement.setString(6, six30_);
			preparedStatement.setString(7, seven_);
			preparedStatement.setString(8, seven30_);
			preparedStatement.setString(9, Date_);
			
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