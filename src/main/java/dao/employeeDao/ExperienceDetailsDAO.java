package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ExperienceDetails;
import util.DatabaseConnection;

public class ExperienceDetailsDAO {
    private Connection conn;
    
    public ExperienceDetailsDAO() {
        conn = DatabaseConnection.getConnection();
    }
    
   
    public List<ExperienceDetails> getExperienceDetailsByUserId(int userId) {
        List<ExperienceDetails> experienceList = new ArrayList<>();
        String sql = "SELECT * FROM experience_details WHERE user_id = ? ORDER BY from_date DESC";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                ExperienceDetails experience = new ExperienceDetails();
                experience.setExperienceDetailId(rs.getInt("experience_detail_id"));
                experience.setDesignationName(rs.getString("designation_name"));
                experience.setFromDate(rs.getDate("from_date"));
                experience.setToDate(rs.getDate("to_date"));
                experience.setCompanyName(rs.getString("company_name"));
                experience.setUserId(rs.getInt("user_id"));
                experienceList.add(experience);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return experienceList;
    }
    
    // Get single experience detail by ID
    public ExperienceDetails getExperienceDetailById(int experienceDetailId) {
        ExperienceDetails experience = null;
        String sql = "SELECT * FROM experience_details WHERE experience_detail_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, experienceDetailId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                experience = new ExperienceDetails();
                experience.setExperienceDetailId(rs.getInt("experience_detail_id"));
                experience.setDesignationName(rs.getString("designation_name"));
                experience.setFromDate(rs.getDate("from_date"));
                experience.setToDate(rs.getDate("to_date"));
                experience.setCompanyName(rs.getString("company_name"));
                experience.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return experience;
    }
    
   
    public boolean addExperienceDetail(ExperienceDetails experience) {
        String sql = "INSERT INTO experience_details (designation_name, from_date, to_date, company_name, user_id) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, experience.getDesignationName());
            ps.setDate(2, experience.getFromDate());
            ps.setDate(3, experience.getToDate());
            ps.setString(4, experience.getCompanyName());
            ps.setInt(5, experience.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean updateExperienceDetail(ExperienceDetails experience) {
        String sql = "UPDATE experience_details SET designation_name = ?, from_date = ?, to_date = ?, company_name = ? WHERE experience_detail_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, experience.getDesignationName());
            ps.setDate(2, experience.getFromDate());
            ps.setDate(3, experience.getToDate());
            ps.setString(4, experience.getCompanyName());
            ps.setInt(5, experience.getExperienceDetailId());
            ps.setInt(6, experience.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
     
    public boolean deleteExperienceDetail(int experienceDetailId, int userId) {
        String sql = "DELETE FROM experience_details WHERE experience_detail_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, experienceDetailId);
            ps.setInt(2, userId);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean isExperienceExists(String companyName, String designationName, int userId) {
        String sql = "SELECT COUNT(*) FROM experience_details WHERE company_name = ? AND designation_name = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, companyName);
            ps.setString(2, designationName);
            ps.setInt(3, userId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}