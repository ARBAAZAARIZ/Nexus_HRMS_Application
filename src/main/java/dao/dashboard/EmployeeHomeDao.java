package dao.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import helper.dashboardHelper.EmployeeDashboardMetrics;
import helper.dashboardHelper.TrainingInfo;
import util.DatabaseConnection;

public class EmployeeHomeDao {

  
    public EmployeeDashboardMetrics employeeGetDashboardMetrics(int userId) {
        EmployeeDashboardMetrics metrics = new EmployeeDashboardMetrics();

        try (Connection conn = DatabaseConnection.getConnection()) {
           
            String sqlInfo = "SELECT r.role_name, d.department_name, des.designation_name, "
                    + "u.date_of_joining, mgr.first_name AS mgr_first, mgr.last_name AS mgr_last "
                    + "FROM users u "
                    + "LEFT JOIN roles r ON u.role_id = r.role_id "
                    + "LEFT JOIN departments d ON u.department_id = d.department_id "
                    + "LEFT JOIN designation des ON u.designation_id = des.designation_id "
                    + "LEFT JOIN users mgr ON u.reporting_manager = mgr.user_id "
                    + "WHERE u.user_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlInfo)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        metrics.setRoleName(rs.getString("role_name"));
                        metrics.setDepartmentName(rs.getString("department_name"));
                        metrics.setDesignationName(rs.getString("designation_name"));
                        metrics.setDateOfJoining(rs.getDate("date_of_joining"));
                        String mgrName = rs.getString("mgr_first") != null ? (rs.getString("mgr_first") + " " + rs.getString("mgr_last")) : "No Manager";
                        metrics.setReportingManagerName(mgrName);
                    }
                }
            }
            System.out.println(metrics.getReportingManagerName() + " from employee dashboard dao" );
            System.out.println(metrics.getDateOfJoining() + " from employee  dashboard dao");

            
            String sqlUpcomingTrainings = "SELECT COUNT(*) FROM training WHERE user_id = ? AND start_date >= CURDATE() AND status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sqlUpcomingTrainings)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        metrics.setUpcomingTrainings(rs.getInt(1));
                    }
                }
            }

           
            String sqlCompletedTrainings = "SELECT COUNT(*) FROM training WHERE user_id = ? AND end_date < CURDATE() AND status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sqlCompletedTrainings)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        metrics.setCompletedTrainings(rs.getInt(1));
                    }
                }
            }

            

        } catch (Exception e) {
            e.printStackTrace();
        }

        return metrics;
    }
    
    
	public List<TrainingInfo> employeeGetTrainingProgress(int userId) {
	    List<TrainingInfo> trainingList = new ArrayList<>();
	    String sql = "SELECT t.training_id, tt.training_type, t.description, t.training_cost, "
	            + "t.start_date, t.end_date, t.status, "
	            + "tr.first_name AS trainer_first_name, tr.last_name AS trainer_last_name, tr.profile_picture "
	            + "FROM training t "
	            + "LEFT JOIN training_type tt ON t.training_type_id = tt.training_type_id "
	            + "LEFT JOIN trainers tr ON t.trainer_id = tr.trainer_id "
	            + "WHERE t.user_id = ? ORDER BY t.start_date DESC";


	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                TrainingInfo training = new TrainingInfo();
	                training.setTrainingId(rs.getInt("training_id"));
	                training.setTrainingType(rs.getString("training_type"));
	                training.setDescription(rs.getString("description"));
	                training.setStartDate(rs.getDate("start_date"));
	                training.setEndDate(rs.getDate("end_date"));
	                training.setStatus(rs.getString("status"));
	                training.setTrainingCost(rs.getDouble("training_cost")); // use BigDecimal for currency
	                String trainerFullName = "";
	                if (rs.getString("trainer_first_name") != null) {
	                    trainerFullName = rs.getString("trainer_first_name") + " " + rs.getString("trainer_last_name");
	                }
	                training.setTrainerName(trainerFullName);
	                training.setTrainerProfilePicture(rs.getString("profile_picture"));

	                trainingList.add(training);
	                
	            }
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return trainingList;
	}
}
