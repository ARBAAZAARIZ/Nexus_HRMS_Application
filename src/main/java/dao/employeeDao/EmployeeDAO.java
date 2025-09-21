package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import model.Users;
import util.DatabaseConnection;

public class EmployeeDAO {

	public EmployeeDAO() {
		
	}
	
	 public Users getEmployeeByEmail(String email) {
	        Users user = null;
	        String query = "SELECT * FROM users WHERE email = ?";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            
	            ps.setString(1, email);
	            ResultSet rs = ps.executeQuery();
	            
	            if (rs.next()) {
	                user = mapResultSetToUser(rs);
	            }
	        } catch (Exception e) {
	            System.out.println("Error in getEmployeeByEmail: " + e.getMessage());
	        }
	        
	        return user;
	    }
	 
	 
	 
	 
	 
	 public Users getEmployeeById(int userId) {
	        Users user = null;
	        String query = "SELECT * FROM users WHERE user_id = ?";
	        
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement ps = conn.prepareStatement(query)) {
	            
	            ps.setInt(1, userId);
	            ResultSet rs = ps.executeQuery();
	            
	            if (rs.next()) {
	                user = mapResultSetToUser(rs);
	            }
	        } catch (Exception e) {
	            System.out.println("Error in getEmployeeById: " + e.getMessage());
	        }
	        
	        return user;
	    }
	 
	 
	 
	 
	 
	 private Users mapResultSetToUser(ResultSet rs) throws Exception {
	        Users user = new Users();
	        user.setUserId(rs.getInt("user_id"));
	        user.setFirstName(rs.getString("first_name"));
	        user.setLastName(rs.getString("last_name"));
	        user.setEmail(rs.getString("email"));
	        user.setHashPassword(rs.getString("hash_password"));
	        user.setContactNumber(rs.getString("contact_number"));
	        user.setRoleId(rs.getInt("role_id"));
	        user.setDepartmentId(rs.getInt("department_id"));
	        user.setDesignationId(rs.getInt("designation_id"));
	        user.setDateOfJoining(rs.getDate("date_of_joining"));
	        user.setDateOfBirth(rs.getDate("date_of_birth"));
	        user.setAddress(rs.getString("address"));
	        user.setProfilePicture(rs.getString("profile_picture"));
	        user.setReportingManager(rs.getInt("reporting_manager"));
	        user.setAboutEmployee(rs.getString("about_employee"));
	        user.setCreatedAt(rs.getDate("created_at"));
	        user.setCreatedBy(rs.getString("created_by"));
	        user.setModifiedAt(rs.getDate("modified_at"));
	        user.setModifiedBy(rs.getString("modified_by"));
	        return user;
	    }
	 
	 
	 
	 

}
