package controller.attendanceController;

import dao.attendanceDao.AttendanceDAO;
import helper.employeeHelper.UserDetails;
import model.Attendance;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.WebServlet;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

@WebServlet("/todaysAttendanceServlet")
public class TodaysAttendanceServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    	HttpSession session =request.getSession(false);
    	UserDetails user = (UserDetails) session.getAttribute("employee");
        int userId = user.getUserId();
        AttendanceDAO dao = new AttendanceDAO();
        try {
            List<Attendance> todaysAttendance = dao.getTodaysAttendance(userId);
            int total_present = dao.getAllPresent();
            int total_absent = dao.getAllAbsent();
            int total_employee = dao.getTotalEmployees();
            request.setAttribute("total_absent", total_absent);
            request.setAttribute("total_present", total_present);
            request.setAttribute("total_employee", total_employee);
            request.setAttribute("todaysAttendance", todaysAttendance);
            System.out.println(todaysAttendance );
        } catch (SQLException e) {
            e.printStackTrace();
        }

        request.getRequestDispatcher("WEB-INF/views/attendanceVeiw/amdinAttendance.jsp")
        .forward(request, response);
    }
}
