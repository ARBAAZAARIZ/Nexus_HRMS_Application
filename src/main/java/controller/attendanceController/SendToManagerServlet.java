package controller.attendanceController;

import dao.attendanceDao.ManagerDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import java.io.IOException;
import java.sql.Date;
import java.sql.SQLException;
import java.net.URLEncoder;


@WebServlet("/sendToManagerServlet")
public class SendToManagerServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String userIdStr = request.getParameter("userId");
        String workingHoursStr = request.getParameter("workingHours");
        String dateStr = request.getParameter("date");

        
        if(userIdStr == null || userIdStr.isEmpty() ||
           workingHoursStr == null || workingHoursStr.isEmpty() ||
           dateStr == null || dateStr.isEmpty()) {
            response.sendRedirect("WEB-INF/views/attendanceVeiw/attendance.jsp");
            return;
        }

        try {
            int userId = Integer.parseInt(userIdStr);
            double workingHours = Double.parseDouble(workingHoursStr);
            Date todayDate = Date.valueOf(dateStr);

            ManagerDao dao = new ManagerDao();
            dao.saveOrUpdateTimeSheet(userId, todayDate, workingHours);

           
            
            response.sendRedirect("attendanceServlet");

        } catch (NumberFormatException e) {
        
           
            response.sendRedirect("attendanceServlet");

        } catch (SQLException e) {
            
            e.printStackTrace();
           
            response.sendRedirect("attendanceServlet");
        }

    }
}
