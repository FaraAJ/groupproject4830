import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MyReservationsServlet")
public class MyReservationsServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Retrieve form data
        String table = request.getParameter("tables");
        String day = request.getParameter("days");
        String time = request.getParameter("times");

        // Forward the request to the JSP
        request.setAttribute("table", table);
        request.setAttribute("day", day);
        request.setAttribute("time", time);
        request.getRequestDispatcher("myReservations.jsp").forward(request, response);
    }
}
