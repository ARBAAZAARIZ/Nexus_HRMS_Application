package service.attendanceService;

import java.sql.SQLException;

import dao.attendanceDao.AttendanceDAO;
import model.Attendance;

public class AttendanceService {
   
	   private AttendanceDAO attend ; 
	   
	   public AttendanceService() {
		    this.attend = new AttendanceDAO();
	   }
	   
	   public String handlePunch(int userId) {
		     try {
		    	System.out.println(attend.handlePunch(userId) + "service class");
				return attend.handlePunch(userId);
				
				 
			 } catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				return "Error" ; 
			
				
			 }
			
	   }
	   public Attendance getTodayAttendance(int userId) throws SQLException {
		   
		    return attend.getTodayAttendance(userId); 
		}
}
