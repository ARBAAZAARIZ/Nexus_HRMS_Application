package util;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;

import helper.employeeHelper.UserDetails;


public class UserDetailsHelper {

    public static UserDetails getUserDetailsByEmail(String email) {
        UserDetails userDetails = null;

        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "{CALL GetUserDetailsByEmail(?)}";
            try (CallableStatement stmt = conn.prepareCall(sql)) {
                stmt.setString(1, email);

                try (ResultSet rs = stmt.executeQuery()) {
                    if (rs.next()) {
                        userDetails = new UserDetails();
                        userDetails.setUserId(rs.getInt("user_id"));
                        userDetails.setFirstName(rs.getString("first_name"));
                        userDetails.setLastName(rs.getString("last_name"));
                        userDetails.setEmail(rs.getString("email"));
                        userDetails.setContactNumber(rs.getString("contact_number"));
                        userDetails.setDateOfJoining(rs.getDate("date_of_joining"));
                        userDetails.setDateOfBirth(rs.getDate("date_of_birth"));
                        userDetails.setAddress(rs.getString("address"));
                        userDetails.setProfilePicture(rs.getString("profile_picture"));
                        userDetails.setReportingManager(rs.getInt("reporting_manager"));
                        userDetails.setAboutEmployee(rs.getString("about_employee"));
                        userDetails.setCreatedAt(rs.getTimestamp("created_at"));
                        userDetails.setCreatedBy(rs.getString("created_by"));
                        userDetails.setModifiedAt(rs.getTimestamp("modified_at"));
                        userDetails.setModifiedBy(rs.getString("modified_by"));
                        userDetails.setRoleName(rs.getString("role_name"));
                        userDetails.setDepartmentName(rs.getString("department_name"));
                        userDetails.setDesignationName(rs.getString("designation_name"));
                        userDetails.setStatus(rs.getString("status"));
                        
                    }
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching user details: " + e.getMessage());
        }

        return userDetails;
    }
}
