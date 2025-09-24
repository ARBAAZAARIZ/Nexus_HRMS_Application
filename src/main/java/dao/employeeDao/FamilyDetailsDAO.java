package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.FamilyDetails;
import util.DatabaseConnection;

public class FamilyDetailsDAO {
    private Connection conn;
    
    public FamilyDetailsDAO() {
        conn = DatabaseConnection.getConnection();
    }
   
    public List<FamilyDetails> getFamilyDetailsByUserId(int userId) {
        List<FamilyDetails> familyList = new ArrayList<>();
        String sql = "SELECT * FROM family_details WHERE user_id = ? ORDER BY relation, name";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                FamilyDetails family = new FamilyDetails();
                family.setFamilyDetailsId(rs.getInt("family_details_id"));
                family.setName(rs.getString("name"));
                family.setRelation(rs.getString("relation"));
                family.setDateOfBirth(rs.getDate("date_of_birth"));
                family.setContactNumber(rs.getString("contact_number"));
                family.setUserId(rs.getInt("user_id"));
                familyList.add(family);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return familyList;
    }
    
    
    public FamilyDetails getFamilyDetailById(int familyDetailsId) {
        FamilyDetails family = null;
        String sql = "SELECT * FROM family_details WHERE family_details_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, familyDetailsId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                family = new FamilyDetails();
                family.setFamilyDetailsId(rs.getInt("family_details_id"));
                family.setName(rs.getString("name"));
                family.setRelation(rs.getString("relation"));
                family.setDateOfBirth(rs.getDate("date_of_birth"));
                family.setContactNumber(rs.getString("contact_number"));
                family.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return family;
    }
    
   
    public boolean addFamilyDetail(FamilyDetails family) {
        String sql = "INSERT INTO family_details (name, relation, date_of_birth, contact_number, user_id) VALUES (?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, family.getName());
            ps.setString(2, family.getRelation());
            ps.setDate(3, family.getDateOfBirth());
            ps.setString(4, family.getContactNumber());
            ps.setInt(5, family.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean updateFamilyDetail(FamilyDetails family) {
        String sql = "UPDATE family_details SET name = ?, relation = ?, date_of_birth = ?, contact_number = ? WHERE family_details_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, family.getName());
            ps.setString(2, family.getRelation());
            ps.setDate(3, family.getDateOfBirth());
            ps.setString(4, family.getContactNumber());
            ps.setInt(5, family.getFamilyDetailsId());
            ps.setInt(6, family.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean deleteFamilyDetail(int familyDetailsId, int userId) {
        String sql = "DELETE FROM family_details WHERE family_details_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, familyDetailsId);
            ps.setInt(2, userId);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean isFamilyMemberExists(String name, String relation, int userId) {
        String sql = "SELECT COUNT(*) FROM family_details WHERE name = ? AND relation = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, name);
            ps.setString(2, relation);
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