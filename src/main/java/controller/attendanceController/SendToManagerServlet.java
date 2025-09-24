package controller.attendanceController;

import dao.attendanceDao.ManagerDao;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;
import java.io.IOException;
import java.sql.Date;

@WebServlet("/sendToManagerServlet")
public class SendToManagerServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int userId = Integer.parseInt(request.getParameter("userId"));
        double workingHours = Double.parseDouble(request.getParameter("workingHours"));
        Date todayDate = Date.valueOf(request.getParameter("date"));

        ManagerDao dao = new ManagerDao();
        try {
            dao.saveOrUpdateTimeSheet(userId, todayDate, workingHours);
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        response.sendRedirect("attendanceServlet");
    }
}
