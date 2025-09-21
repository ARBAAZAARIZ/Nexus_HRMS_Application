// EducationDetailsDAO.java
package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.EducationDetails;
import util.DatabaseConnection;

public class EducationDetailsDAO {
    private Connection conn;
    
    public EducationDetailsDAO() {
        conn = DatabaseConnection.getConnection();
    }
    
    public List<EducationDetails> getEducationDetailsByUserId(int userId) {
        List<EducationDetails> educationList = new ArrayList<>();
        String sql = "SELECT * FROM education_details WHERE user_id = ? ORDER BY start_date DESC";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                EducationDetails education = new EducationDetails();
                education.setEducationDetailId(rs.getInt("education_detail_id"));
                education.setEducationName(rs.getString("education_name"));
                education.setUniversityName(rs.getString("university_name"));
                education.setStartDate(rs.getDate("start_date"));
                education.setEndDate(rs.getDate("end_date"));
                education.setUserId(rs.getInt("user_id"));
                educationList.add(education);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return educationList;
    }
    
    public boolean addEducationDetail(EducationDetails education) {
        String sql = "INSERT INTO education_details (education_name, university_name, start_date, end_date, user_id) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, education.getEducationName());
            ps.setString(2, education.getUniversityName());
            ps.setDate(3, education.getStartDate());
            ps.setDate(4, education.getEndDate());
            ps.setInt(5, education.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean updateEducationDetail(EducationDetails education) {
        String sql = "UPDATE education_details SET education_name = ?, university_name = ?, start_date = ?, end_date = ? WHERE education_detail_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, education.getEducationName());
            ps.setString(2, education.getUniversityName());
            ps.setDate(3, education.getStartDate());
            ps.setDate(4, education.getEndDate());
            ps.setInt(5, education.getEducationDetailId());
            ps.setInt(6, education.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean deleteEducationDetail(int educationDetailId, int userId) {
        String sql = "DELETE FROM education_details WHERE education_detail_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, educationDetailId);
            ps.setInt(2, userId);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
}