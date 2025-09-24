package controller.attendanceController;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Attendance;
import service.attendanceService.AttendanceService;

import java.io.IOException;
import java.sql.SQLException;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


import dao.attendanceDao.AttendanceDAO;
import helper.employeeHelper.UserDetails;

@WebServlet("/attendanceServlet")
public class AttendanceServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private AttendanceService attendanceService = new AttendanceService();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    	HttpSession session =request.getSession(false);
    	
        UserDetails user = (UserDetails) session.getAttribute("employee");
        
        
        Integer user_id = (Integer)user.getUserId() ; 
        if (user == null || user_id == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        int userId = user.getUserId();

        
        LocalDateTime now = LocalDateTime.now();
        String greeting = (now.getHour() < 12) ? "Good Morning"
                : (now.getHour() < 17) ? "Good Afternoon" : "Good Evening";

        request.setAttribute("greeting", greeting);
        request.setAttribute("currentTime", now.format(DateTimeFormatter.ofPattern("hh:mm a, dd MMM yyyy")));
        request.setAttribute("profile", user.getProfilePicture());
        request.setAttribute("username", user.getFirstName());
        request.setAttribute("userId", userId);
        Attendance attend = null;
        try {
            attend = attendanceService.getTodayAttendance(userId);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        String nextAction = "Punch In";
       
        AttendanceDAO hours = new AttendanceDAO();
        
        Double todayWorkingHour = null ;
        Double WeeklyWorkingHours = null ; 
        Double MonthlyWorkingHours = null ;
        Double todayBreakHours = null ;
        try {
			todayWorkingHour = hours.getWeeklyWorkingHours(userId);
			WeeklyWorkingHours = hours.getWeeklyWorkingHours(userId);
			MonthlyWorkingHours = hours.getMonthlyWorkingHours(userId);
			todayBreakHours = hours.getTodayBreakHours(userId);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
     
        double productiveHours = todayWorkingHour ; 
        double breakHours = todayBreakHours ; 
        double totalTime = productiveHours + breakHours;
    
		 
        int productivePercent = (int)((productiveHours / totalTime) * 100);
        int breakPercent = (int)((breakHours / totalTime) * 100);

        System.out.println(productivePercent);
        System.out.println(breakPercent);
        request.setAttribute("nextAction", nextAction);
        System.out.println(nextAction + "from serlvert");
     
        request.setAttribute("punch_in", attend != null ? attend.getCheck_in() : null);
        request.setAttribute("todayWorkingHour", todayWorkingHour);
        request.setAttribute("weeklyWorkingHour",  WeeklyWorkingHours);
        request.setAttribute("monthlyWorkingHours",  MonthlyWorkingHours);
        request.setAttribute("todayBreak", todayBreakHours);
        request.setAttribute("productionPre",productivePercent );
        request.setAttribute("breakPre", breakPercent);
        request.setAttribute("employee", user);
        request.getRequestDispatcher("WEB-INF/views/attendanceVeiw/attendance.jsp")
                .forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
  


   
        
        

HttpSession session =request.getSession(false);
    	
        UserDetails user = (UserDetails) session.getAttribute("employee");
        Integer user_id = user.getUserId() ; 
        if (user == null || user_id == null) {
            response.sendRedirect("login.jsp");
            return;
        }
        int userId = user.getUserId();
        Attendance attend = null;
       
        try {
            attend = attendanceService.getTodayAttendance(userId);
            
        } catch (SQLException e) {
            e.printStackTrace();
        }

        AttendanceDAO action = new AttendanceDAO() ; 
        String action1 = null;
		try {
			action1 = action.handlePunch(userId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        request.setAttribute("nextAction", action1);
        System.out.println(action + "from post");	
        LocalDateTime now = LocalDateTime.now();
        String greeting = (now.getHour() < 12) ? "Good Morning"
                : (now.getHour() < 17) ? "Good Afternoon" : "Good Evening";

        request.setAttribute("greeting", greeting);
        request.setAttribute("currentTime", now.format(DateTimeFormatter.ofPattern("hh:mm a, dd MMM yyyy")));
        request.setAttribute("profile", user.getProfilePicture());
        request.setAttribute("username", user.getFirstName());
        
		request.setAttribute("production", attend != null ?
		 attend.getProduction_hours() : null);
		
        request.setAttribute("punch_in", attend != null ? attend.getCheck_in() : null);
        

        request.getRequestDispatcher("WEB-INF/views/attendanceVeiw/attendance.jsp")
                .forward(request, response);
    }
}

