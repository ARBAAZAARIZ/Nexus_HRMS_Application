package dao.trainingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.TrainingType;
import util.DatabaseConnection;

public class TrainingTypeDAO {
	private Connection conn;
	 public TrainingTypeDAO() {
		 
	        conn = DatabaseConnection.getConnection();
	    }
	 
	 
	 
	 
	 
	 public boolean addTrainingType(TrainingType trainingType) {
	        String sql = "INSERT INTO training_type (training_type, description, status, created_by) VALUES (?, ?, ?, ?)";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, trainingType.getTrainingType());
	            ps.setString(2, trainingType.getDescription());
	            ps.setString(3, trainingType.getStatus());
	            ps.setString(4, trainingType.getCreatedBy());
	            
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error adding training type: " + e.getMessage());
	            return false;
	        }
	    }
	 
	 
	 
	 public List<TrainingType> getAllTrainingTypes() {
	        List<TrainingType> trainingTypes = new ArrayList<>();
	        String sql = "SELECT * FROM training_type";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            
	            while (rs.next()) {
	                TrainingType trainingType = new TrainingType();
	                trainingType.setTrainingTypeId(rs.getInt("training_type_id"));
	                trainingType.setTrainingType(rs.getString("training_type"));
	                trainingType.setDescription(rs.getString("description"));
	                trainingType.setStatus(rs.getString("status"));
	                trainingType.setCreatedAt(rs.getTimestamp("created_at"));
	                trainingType.setCreatedBy(rs.getString("created_by"));
	                trainingType.setModifiedAt(rs.getTimestamp("modified_at"));
	                trainingType.setModifiedBy(rs.getString("modified_by"));
	                
	                trainingTypes.add(trainingType);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error getting training types: " + e.getMessage());
	        }
	        
	        return trainingTypes;
	    }
	 
	 
	 
	 public TrainingType getTrainingTypeById(int trainingTypeId) {
	        TrainingType trainingType = null;
	        String sql = "SELECT * FROM training_type WHERE training_type_id = ?";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, trainingTypeId);
	            
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    trainingType = new TrainingType();
	                    trainingType.setTrainingTypeId(rs.getInt("training_type_id"));
	                    trainingType.setTrainingType(rs.getString("training_type"));
	                    trainingType.setDescription(rs.getString("description"));
	                    trainingType.setStatus(rs.getString("status"));
	                    trainingType.setCreatedAt(rs.getTimestamp("created_at"));
	                    trainingType.setCreatedBy(rs.getString("created_by"));
	                    trainingType.setModifiedAt(rs.getTimestamp("modified_at"));
	                    trainingType.setModifiedBy(rs.getString("modified_by"));
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Error getting training type by ID: " + e.getMessage());
	        }
	        
	        return trainingType;
	    }
	 
	 
	 
	 public boolean updateTrainingType(TrainingType trainingType) {
	        String sql = "UPDATE training_type SET training_type = ?, description = ?, status = ?, modified_by = ? WHERE training_type_id = ?";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, trainingType.getTrainingType());
	            ps.setString(2, trainingType.getDescription());
	            ps.setString(3, trainingType.getStatus());
	            ps.setString(4, trainingType.getModifiedBy());
	            ps.setInt(5, trainingType.getTrainingTypeId());
	            
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error updating training type: " + e.getMessage());
	            return false;
	        }
	    }
	 
	 
	 

	    
	    public boolean deleteTrainingType(int trainingTypeId) {
	        String sql = "UPDATE training_type SET status = 'INACTIVE' WHERE training_type_id = ?";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, trainingTypeId);
	            
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error deleting training type: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    
	    
	   

	 
	 
	 
	 
	 
	 
	 
	 

}
