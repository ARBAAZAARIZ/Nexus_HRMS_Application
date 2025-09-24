package controller.attendanceController;

import dao.attendanceDao.ManagerDao;
import model.TimeSheet;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/managerTimeSheetServlet")
public class ManagerTimeSheetServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	ManagerDao dao = new ManagerDao();
        try {
            List<TimeSheet> pendingList = dao.getPendingTimeSheets();
            request.setAttribute("pendingList", pendingList);
            System.out.println(pendingList);
            request.getRequestDispatcher("WEB-INF/views/attendanceVeiw/managerDashboard.jsp").forward(request, response);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int timeSheetId = Integer.parseInt(request.getParameter("timeSheetId"));
        ManagerDao dao = new ManagerDao();
        try {
            dao.approveTimeSheet(timeSheetId);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        response.sendRedirect("managerTimeSheetServlet");
    }
}
