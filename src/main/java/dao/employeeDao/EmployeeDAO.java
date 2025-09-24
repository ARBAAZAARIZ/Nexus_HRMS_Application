package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

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
	 
	 
	 
	 
	 

	 public int saveSalary(int userId, double totalSalary, double netSalary) throws SQLException {
	        String sql = "INSERT INTO emp_salary (user_id, total_salary, net_salary, created_date) VALUES (?,?,?,?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	        		
	        		PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
	            ps.setInt(1, userId);
	            ps.setDouble(2, totalSalary);
	            ps.setDouble(3, netSalary);
	            ps.setDate(4, new java.sql.Date(System.currentTimeMillis()));
	            ps.executeUpdate();

	            try (ResultSet rs = ps.getGeneratedKeys()) {
	                if (rs.next()) {
	                    return rs.getInt(1); // salary_id
	                }
	            }
	        }
	        return 0;
	    }

	   
	    public boolean saveEmployeeEarning(int userId, int salaryId, int earningId, double earningAmt) throws SQLException {
	        String sql = "INSERT INTO employee_earning (user_id, salary_id, earning_id, earning_amt) VALUES (?,?,?,?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	        		PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, userId);
	            ps.setInt(2, salaryId);
	            ps.setInt(3, earningId);
	            ps.setDouble(4, earningAmt);
	            return ps.executeUpdate() > 0;
	        }
	    }


	    public boolean saveEmployeeDeduction(int userId, int salaryId, int deductionId, double deductionAmt) throws SQLException {
	        String sql = "INSERT INTO employee_deduction (user_id, salary_id, deduction_id, deduction_amt) VALUES (?,?,?,?)";
	        try (Connection conn = DatabaseConnection.getConnection();
	        		PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, userId);
	            ps.setInt(2, salaryId);
	            ps.setInt(3, deductionId);
	            ps.setDouble(4, deductionAmt);
	            return ps.executeUpdate() > 0;
	        }
	    }
	    
	    
	    
		 public List<Users> getAllEmployees() {
		        List<Users> users=new ArrayList<Users>();
		        String query = "SELECT * FROM users";
		        
		        try (Connection conn = DatabaseConnection.getConnection();
		             PreparedStatement ps = conn.prepareStatement(query)) {
		            
		            ResultSet rs = ps.executeQuery();
		            
		            if (rs.next()) {
		                users.add(mapResultSetToUser(rs)) ;
		            }
		        } catch (Exception e) {
		            System.out.println("Error in getEmployeeByEmail: " + e.getMessage());
		        }
		        
		        return users;
		    }
	 
	 
	 
	 

}
