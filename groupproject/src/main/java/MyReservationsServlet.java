import java.io.IOException;
import java.sql.Connection;

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

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	//put MySQL connection here
    	
    	StringBuilder returnString = new StringBuilder();
    	returnString.append("<tr><td>1</td><td>2</td><td>3</td></tr>");
    	
    	response.getWriter().append(returnString);
    	
    }
}
