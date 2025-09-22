package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import helper.employeeHelper.UserDetails;
import model.Users;
import util.DatabaseConnection;

public class UserDAO {

	private Connection conn;
	public UserDAO() {
		conn = DatabaseConnection.getConnection();
	}
	
	
	
	
	
	 // Add new user
	// Add new user
	public boolean addUser(Users u) {
	    String sql = "INSERT INTO users (first_name, last_name, email, "
	            + "hash_password, contact_number, role_id, department_id, designation_id, "
	            + "date_of_joining, date_of_birth, address, profile_picture, reporting_manager, "
	            + "about_employee, created_by, status) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	    
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, u.getFirstName());
	        ps.setString(2, u.getLastName());
	        ps.setString(3, u.getEmail());
	        ps.setString(4, u.getHashPassword());
	        ps.setString(5, u.getContactNumber());
	        ps.setInt(6, u.getRoleId());
	        ps.setInt(7, u.getDepartmentId());
	        ps.setInt(8, u.getDesignationId());
	        ps.setDate(9, u.getDateOfJoining());
	        ps.setDate(10, u.getDateOfBirth());
	        ps.setString(11, u.getAddress());
	        ps.setString(12, u.getProfilePicture());
	        
	        if (u.getReportingManager() <= 0) {
	            ps.setNull(13, java.sql.Types.INTEGER);
	        } else {
	            ps.setInt(13, u.getReportingManager());
	        }

	        ps.setString(14, u.getAboutEmployee());
	        ps.setString(15, u.getCreatedBy());
	        ps.setString(16, u.getStatus());
	        
	        boolean success = ps.executeUpdate() > 0;
	        
	        // If user was added successfully, update employee counts
	        if (success) {
	            updateDepartmentEmployeeCount(u.getDepartmentId());
	            updateDesignationEmployeeCount(u.getDesignationId());
	        }
	        
	        return success;
	    } catch (SQLException e) {
	        System.out.println("Error adding user: " + e.getMessage());
	        return false;
	    }
	}
    
    
 // Update department employee count
    public boolean updateDepartmentEmployeeCount(int departmentId) {
        String sql = "UPDATE departments SET number_of_employee = " +
                     "(SELECT COUNT(*) FROM users WHERE department_id = ? AND status = 'ACTIVE') " +
                     "WHERE department_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            ps.setInt(2, departmentId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating department employee count: " + e.getMessage());
            return false;
        }
    }

    // Update designation employee count
    public boolean updateDesignationEmployeeCount(int designationId) {
        String sql = "UPDATE designation SET number_of_employee = " +
                     "(SELECT COUNT(*) FROM users WHERE designation_id = ? AND status = 'ACTIVE') " +
                     "WHERE designation_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, designationId);
            ps.setInt(2, designationId);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating designation employee count: " + e.getMessage());
            return false;
        }
    }
    
   
    
    public  List<UserDetails> getAllUserDetails() {
        List<UserDetails> list = new ArrayList<>();
        String sql = "SELECT u.*, r.role_name, d.department_name, des.designation_name FROM users u " +
                     "JOIN roles r ON u.role_id = r.role_id " +
                     "JOIN departments d ON u.department_id = d.department_id " +
                     "JOIN designation des ON u.designation_id = des.designation_id";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                UserDetails user = new UserDetails();
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setContactNumber(rs.getString("contact_number"));
                user.setDateOfJoining(rs.getDate("date_of_joining"));
                user.setDateOfBirth(rs.getDate("date_of_birth"));
                user.setAddress(rs.getString("address"));
                user.setProfilePicture(rs.getString("profile_picture"));
                user.setReportingManager(rs.getInt("reporting_manager"));
                user.setAboutEmployee(rs.getString("about_employee"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedBy(rs.getString("created_by"));
                user.setModifiedAt(rs.getTimestamp("modified_at"));
                user.setModifiedBy(rs.getString("modified_by"));
                user.setRoleName(rs.getString("role_name"));
                user.setDepartmentName(rs.getString("department_name"));
                user.setDesignationName(rs.getString("designation_name"));
                user.setStatus(rs.getString("status"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public static UserDetails getUserDetailsById(int userId) {
        UserDetails user = null;

        try (Connection con = DatabaseConnection.getConnection()) {

            String sql = "SELECT u.user_id, u.first_name, u.last_name, u.email, u.contact_number, " +
                    "u.date_of_joining, u.date_of_birth, u.address, u.profile_picture, u.reporting_manager, " +
                    "u.about_employee, u.created_at, u.created_by, u.modified_at, u.modified_by, u.status, " +
                    "r.role_id, r.role_name, d.department_id, d.department_name, g.designation_id, g.designation_name " +
                    "FROM users u " +
                    "LEFT JOIN roles r ON u.role_id = r.role_id " +
                    "LEFT JOIN departments d ON u.department_id = d.department_id " +
                    "LEFT JOIN designation g ON u.designation_id = g.designation_id " +
                    "WHERE u.user_id = ?";

            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, userId);

            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                user = new UserDetails(
                        rs.getInt("user_id"),
                        rs.getString("first_name"),
                        rs.getString("last_name"),
                        rs.getString("email"),
                        rs.getString("contact_number"),
                        rs.getInt("role_id"),
                        rs.getInt("department_id"),
                        rs.getInt("designation_id"),
                        rs.getString("role_name"),
                        rs.getString("department_name"),
                        rs.getString("designation_name"),
                        rs.getDate("date_of_joining"),
                        rs.getDate("date_of_birth"),
                        rs.getString("address"),
                        rs.getString("profile_picture"),
                        rs.getInt("reporting_manager"),
                        rs.getString("about_employee"),
                        rs.getTimestamp("created_at"),
                        rs.getString("created_by"),
                        rs.getTimestamp("modified_at"),
                        rs.getString("modified_by"),
                        rs.getString("status")
                );
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return user;
    }
    
    
    public List<UserDetails> getAllManagers() {
        List<UserDetails> list = new ArrayList<>();
        String sql = "SELECT u.*, r.role_name, d.department_name, des.designation_name FROM users u " +
                     "JOIN roles r ON u.role_id = r.role_id " +
                     "JOIN departments d ON u.department_id = d.department_id " +
                     "JOIN designation des ON u.designation_id = des.designation_id " +
                     "WHERE r.role_name = 'Manager' AND u.status = 'ACTIVE'";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                UserDetails user = new UserDetails();
                // Map all the necessary fields
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setContactNumber(rs.getString("contact_number"));
                user.setRoleName(rs.getString("role_name"));
                user.setDepartmentName(rs.getString("department_name"));
                user.setDesignationName(rs.getString("designation_name"));
                user.setDateOfJoining(rs.getDate("date_of_joining"));
                user.setDateOfBirth(rs.getDate("date_of_birth"));
                user.setAddress(rs.getString("address"));
                user.setProfilePicture(rs.getString("profile_picture"));
                user.setReportingManager(rs.getInt("reporting_manager"));
                user.setAboutEmployee(rs.getString("about_employee"));
                user.setCreatedAt(rs.getTimestamp("created_at"));
                user.setCreatedBy(rs.getString("created_by"));
                user.setModifiedAt(rs.getTimestamp("modified_at"));
                user.setModifiedBy(rs.getString("modified_by"));
                user.setStatus(rs.getString("status"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    public List<UserDetails> getManagersByDeptAndDesignation(int deptId, int designationId) {
        List<UserDetails> list = new ArrayList<>();
        String sql = "SELECT u.* FROM users u " +
                     "JOIN roles r ON u.role_id = r.role_id " +
                     "WHERE u.department_id = ? AND u.designation_id = ? " +
                     "AND r.role_name = 'Manager' AND u.status = 'ACTIVE'";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptId);
            ps.setInt(2, designationId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                UserDetails user = new UserDetails();
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                // Set other fields as needed
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
 // Get user by ID
    public Users getUserById(int userId) {
        Users user = null;
        String sql = "SELECT * FROM users WHERE user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                user = new Users();
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
                user.setStatus(rs.getString("status"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    // Update user with profile picture handling
 // Update user with profile picture handling and employee count synchronization
    public boolean updateUser(Users u) {
        // First get the old user data to check if department or designation changed
        Users oldUser = getUserById(u.getUserId());
        if (oldUser == null) {
            return false;
        }
        
        String sql;
        boolean hasProfilePicture = u.getProfilePicture() != null && !u.getProfilePicture().isEmpty();
        
        if (hasProfilePicture) {
            sql = "UPDATE users SET first_name=?, last_name=?, contact_number=?, "
                + "role_id=?, department_id=?, designation_id=?, date_of_joining=?, "
                + "date_of_birth=?, address=?, profile_picture=?, reporting_manager=?, "
                + "about_employee=?, modified_by=?, status=? WHERE user_id=?";
        } else {
            sql = "UPDATE users SET first_name=?, last_name=?, contact_number=?, "
                + "role_id=?, department_id=?, designation_id=?, date_of_joining=?, "
                + "date_of_birth=?, address=?, reporting_manager=?, "
                + "about_employee=?, modified_by=?, status=? WHERE user_id=?";
        }
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int paramIndex = 1;
            ps.setString(paramIndex++, u.getFirstName());
            ps.setString(paramIndex++, u.getLastName());
            ps.setString(paramIndex++, u.getContactNumber());
            ps.setInt(paramIndex++, u.getRoleId());
            ps.setInt(paramIndex++, u.getDepartmentId());
            ps.setInt(paramIndex++, u.getDesignationId());
            ps.setDate(paramIndex++, u.getDateOfJoining());
            ps.setDate(paramIndex++, u.getDateOfBirth());
            ps.setString(paramIndex++, u.getAddress());
            
            if (hasProfilePicture) {
                ps.setString(paramIndex++, u.getProfilePicture());
            }
            
            if (u.getReportingManager() <= 0) {
                ps.setNull(paramIndex++, java.sql.Types.INTEGER);
            } else {
                ps.setInt(paramIndex++, u.getReportingManager());
            }
            
            ps.setString(paramIndex++, u.getAboutEmployee());
            ps.setString(paramIndex++, u.getModifiedBy());
            ps.setString(paramIndex++, u.getStatus());
            ps.setInt(paramIndex++, u.getUserId());
            
            boolean success = ps.executeUpdate() > 0;
            
            // If user was updated successfully, update employee counts
            if (success) {
                // Check if department changed
                if (oldUser.getDepartmentId() != u.getDepartmentId()) {
                    // Update both old and new departments
                    updateDepartmentEmployeeCount(oldUser.getDepartmentId());
                    updateDepartmentEmployeeCount(u.getDepartmentId());
                } else {
                    // Department didn't change, just update the current one
                    updateDepartmentEmployeeCount(u.getDepartmentId());
                }
                
                // Check if designation changed
                if (oldUser.getDesignationId() != u.getDesignationId()) {
                    // Update both old and new designations
                    updateDesignationEmployeeCount(oldUser.getDesignationId());
                    updateDesignationEmployeeCount(u.getDesignationId());
                } else {
                    // Designation didn't change, just update the current one
                    updateDesignationEmployeeCount(u.getDesignationId());
                }
                
                // Also update if status changed (active/inactive affects counts)
                if (!oldUser.getStatus().equals(u.getStatus())) {
                    updateDepartmentEmployeeCount(u.getDepartmentId());
                    updateDesignationEmployeeCount(u.getDesignationId());
                }
            }
            
            return success;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    
    
    
    
    
    public List<UserDetails> getUsersByIds(String[] userIds) {
        List<UserDetails> list = new ArrayList<>();
        if (userIds == null || userIds.length == 0) return list;
        
        String placeholders = String.join(",", Collections.nCopies(userIds.length, "?"));
        String sql = "SELECT u.*, r.role_name, d.department_name, des.designation_name FROM users u " +
                     "JOIN roles r ON u.role_id = r.role_id " +
                     "JOIN departments d ON u.department_id = d.department_id " +
                     "JOIN designation des ON u.designation_id = des.designation_id " +
                     "WHERE u.user_id IN (" + placeholders + ")";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            for (int i = 0; i < userIds.length; i++) {
                ps.setInt(i + 1, Integer.parseInt(userIds[i]));
            }
            
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                UserDetails user = new UserDetails();
                // Map all fields as in getAllUserDetails()
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public boolean updateUserDetails(UserDetails user) {
        String sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, role_id = ?, department_id = ?, designation_id = ?, date_of_joining = ?, date_of_birth = ?, contact_number = ?, address = ?, about_employee = ?, status = ?, reporting_manager = ?, modified_by = ?, modified_at = CURRENT_TIMESTAMP, profile_picture = ? WHERE user_id = ?";
        
        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getRoleId());
            ps.setInt(5, user.getDepartmentId());
            ps.setInt(6, user.getDesignationId());
            ps.setDate(7, user.getDateOfJoining());
            ps.setDate(8, user.getDateOfBirth());
            ps.setString(9, user.getContactNumber());
            ps.setString(10, user.getAddress());
            ps.setString(11, user.getAboutEmployee());
            ps.setString(12, user.getStatus());
            
            if (user.getReportingManager() <= 0) {
                ps.setObject(13, null);
            } else {
                ps.setObject(13, user.getReportingManager());
            }


            ps.setString(14, user.getModifiedBy());
            ps.setString(15, user.getProfilePicture());
            ps.setInt(16, user.getUserId());

            return ps.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public List<UserDetails> getUsersByIds(List<Integer> ids) {
        String placeholders = ids.stream().map(id -> "?").collect(Collectors.joining(","));
        String sql = "SELECT * FROM users WHERE user_id IN (" + placeholders + ")";

        try (
             PreparedStatement ps = conn.prepareStatement(sql)) {

            for (int i = 0; i < ids.size(); i++) {
                ps.setInt(i + 1, ids.get(i));
            }

            ResultSet rs = ps.executeQuery();
            List<UserDetails> users = new ArrayList<>();
            while (rs.next()) {
                UserDetails user = new UserDetails();
                user.setUserId(rs.getInt("user_id"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setEmail(rs.getString("email"));
                user.setRoleName(rs.getString("role_id")); // or join to get role name
                user.setDepartmentName(rs.getString("department_id")); // same here
                user.setDesignationName(rs.getString("designation_id"));
                user.setDateOfJoining(rs.getDate("date_of_joining"));
                user.setContactNumber(rs.getString("contact_number"));
                user.setStatus(rs.getString("status"));
                user.setProfilePicture(rs.getString("profile_picture"));
                users.add(user);
            }
            return users;
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }
    }
    
    
    public boolean updateUserDetailsForSingleEmployee(UserDetails user) {
        String sql;
        boolean hasProfilePicture = user.getProfilePicture() != null && !user.getProfilePicture().isEmpty();
        
        if (hasProfilePicture) {
            sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, contact_number = ?, " +
                  "date_of_birth = ?, address = ?, about_employee = ?, " +
                  "modified_by = ?, modified_at = CURRENT_TIMESTAMP, profile_picture = ? " +
                  "WHERE user_id = ?";
        } else {
            sql = "UPDATE users SET first_name = ?, last_name = ?, email = ?, contact_number = ?, " +
                  "date_of_birth = ?, address = ?, about_employee = ?, " +
                  "modified_by = ?, modified_at = CURRENT_TIMESTAMP " +
                  "WHERE user_id = ?";
        }
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            int paramIndex = 1;
            ps.setString(paramIndex++, user.getFirstName());
            ps.setString(paramIndex++, user.getLastName());
            ps.setString(paramIndex++, user.getEmail());
            ps.setString(paramIndex++, user.getContactNumber());
            ps.setDate(paramIndex++, user.getDateOfBirth());
            ps.setString(paramIndex++, user.getAddress());
            ps.setString(paramIndex++, user.getAboutEmployee());
            ps.setString(paramIndex++, user.getModifiedBy());
            
            if (hasProfilePicture) {
                ps.setString(paramIndex++, user.getProfilePicture());
            }
            
            ps.setInt(paramIndex, user.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    
 // Check if email exists in users table
    public boolean isEmailExists(String email) {
        boolean exists = false;
        String sql = "SELECT email FROM users WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setString(1, email);
             try (ResultSet rs = ps.executeQuery()) {
                 if (rs.next()) {
                     exists = true;
                 }
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return exists;
    }

    // Update password by email (hashed password)
    public boolean updatePasswordByEmail(String email, String hashedPassword) {
        boolean updated = false;
        String sql = "UPDATE users SET hash_password = ?, modified_at = CURRENT_TIMESTAMP WHERE email = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
             ps.setString(1, hashedPassword);
             ps.setString(2, email);
             int rows = ps.executeUpdate();
             if (rows > 0) {
                 updated = true;
             }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return updated;
    }


    
    
    


}
