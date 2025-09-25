package controller.attendanceController;

import dao.attendanceDao.AdminDAO;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/adminAttendanceServlet")
public class AdminAttendanceServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        AdminDAO dao = new AdminDAO();

        try {
            List<Integer> present = dao.getPresentEmployees();
            List<Integer> absent = dao.getAbsentEmployees();

            request.setAttribute("presentEmployees", present);
            request.setAttribute("absentEmployees", absent);

        } catch (SQLException e) {
            e.printStackTrace();
        }

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/views/attendanceVeiw/manager.jsp");


        dispatcher.forward(request, response);
    }
}
