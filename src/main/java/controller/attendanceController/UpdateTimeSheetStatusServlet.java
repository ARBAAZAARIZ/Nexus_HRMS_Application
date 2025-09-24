package controller.attendanceController;

import dao.attendanceDao.ManagerDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/updateTimeSheetStatusServlet")
public class UpdateTimeSheetStatusServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int timeSheetId = Integer.parseInt(request.getParameter("timeSheetId"));
        String status = request.getParameter("status");

        ManagerDao dao = new ManagerDao();
        try {
            dao.updateStatus(timeSheetId, status);
        } catch (Exception e) {
            e.printStackTrace();
        }

       
        response.sendRedirect("managerTimeSheetServlet");
    }
}
