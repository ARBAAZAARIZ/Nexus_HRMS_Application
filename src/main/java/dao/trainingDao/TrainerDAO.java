package dao.trainingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Trainer;
import util.DatabaseConnection;

public class TrainerDAO {

	 private Connection conn;
	    
	    public TrainerDAO() {
	        conn = DatabaseConnection.getConnection();
	    }
	    
	    
	    public boolean addTrainer(Trainer trainer) {
	        String sql = "INSERT INTO trainers (first_name, last_name, email, description, contact_no, profile_picture, status, is_internal, user_id, created_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, trainer.getFirstName());
	            ps.setString(2, trainer.getLastName());
	            ps.setString(3, trainer.getEmail());
	            ps.setString(4, trainer.getDescription());
	            ps.setString(5, trainer.getContactNo());
	            ps.setString(6, trainer.getProfilePicture());
	            ps.setString(7, trainer.getStatus());
	            ps.setBoolean(8, trainer.isInternal());
	            
	            if (trainer.getUserId() != null) {
	                ps.setInt(9, trainer.getUserId());
	            } else {
	                ps.setNull(9, java.sql.Types.INTEGER);
	            }
	            
	            ps.setString(10, trainer.getCreatedBy());
	            
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error adding trainer: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    
	    
	    public List<Trainer> getAllTrainers() {
	        List<Trainer> trainers = new ArrayList<>();
	        String sql = "SELECT * FROM trainers";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            
	            while (rs.next()) {
	                Trainer trainer = new Trainer();
	                trainer.setTrainerId(rs.getInt("trainer_id"));
	                trainer.setFirstName(rs.getString("first_name"));
	                trainer.setLastName(rs.getString("last_name"));
	                trainer.setEmail(rs.getString("email"));
	                trainer.setDescription(rs.getString("description"));
	                trainer.setContactNo(rs.getString("contact_no"));
	                trainer.setProfilePicture(rs.getString("profile_picture"));
	                trainer.setStatus(rs.getString("status"));
	                trainer.setInternal(rs.getBoolean("is_internal"));
	                trainer.setUserId(rs.getInt("user_id"));
	                if (rs.wasNull()) {
	                    trainer.setUserId(null);
	                }
	                trainer.setCreatedAt(rs.getTimestamp("created_at"));
	                trainer.setCreatedBy(rs.getString("created_by"));
	                trainer.setModifiedAt(rs.getTimestamp("modified_at"));
	                trainer.setModifiedBy(rs.getString("modified_by"));
	                
	                trainers.add(trainer);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error getting trainers: " + e.getMessage());
	        }
	        
	        return trainers;
	    }
	    
	    
	    
	    
	    
	    public Trainer getTrainerById(int trainerId) {
	        Trainer trainer = null;
	        String sql = "SELECT * FROM trainers WHERE trainer_id = ?";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, trainerId);
	            
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    trainer = new Trainer();
	                    trainer.setTrainerId(rs.getInt("trainer_id"));
	                    trainer.setFirstName(rs.getString("first_name"));
	                    trainer.setLastName(rs.getString("last_name"));
	                    trainer.setEmail(rs.getString("email"));
	                    trainer.setDescription(rs.getString("description"));
	                    trainer.setContactNo(rs.getString("contact_no"));
	                    trainer.setProfilePicture(rs.getString("profile_picture"));
	                    trainer.setStatus(rs.getString("status"));
	                    trainer.setInternal(rs.getBoolean("is_internal"));
	                    trainer.setUserId(rs.getInt("user_id"));
	                    if (rs.wasNull()) {
	                        trainer.setUserId(null);
	                    }
	                    trainer.setCreatedAt(rs.getTimestamp("created_at"));
	                    trainer.setCreatedBy(rs.getString("created_by"));
	                    trainer.setModifiedAt(rs.getTimestamp("modified_at"));
	                    trainer.setModifiedBy(rs.getString("modified_by"));
	                }
	            }
	        } catch (SQLException e) {
	            System.out.println("Error getting trainer by ID: " + e.getMessage());
	        }
	        
	        return trainer;
	    }
	    
	    
	    
	    
	    
	    
	    
	    public boolean updateTrainer(Trainer trainer) {
	        String sql = "UPDATE trainers SET first_name = ?, last_name = ?, email = ?, description = ?, contact_no = ?, profile_picture = ?, status = ?, is_internal = ?, user_id = ?, modified_by = ? WHERE trainer_id = ?";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, trainer.getFirstName());
	            ps.setString(2, trainer.getLastName());
	            ps.setString(3, trainer.getEmail());
	            ps.setString(4, trainer.getDescription());
	            ps.setString(5, trainer.getContactNo());
	            ps.setString(6, trainer.getProfilePicture());
	            ps.setString(7, trainer.getStatus());
	            ps.setBoolean(8, trainer.isInternal());
	            
	            if (trainer.getUserId() != null) {
	                ps.setInt(9, trainer.getUserId());
	            } else {
	                ps.setNull(9, java.sql.Types.INTEGER);
	            }
	            
	            ps.setString(10, trainer.getModifiedBy());
	            ps.setInt(11, trainer.getTrainerId());
	            
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error updating trainer: " + e.getMessage());
	            return false;
	        }
	    }
	    
	    
	    
	    
	    public List<Trainer> getInternalTrainers() {
	        List<Trainer> trainers = new ArrayList<>();
	        String sql = "SELECT * FROM trainers WHERE is_internal = TRUE AND status = 'ACTIVE'";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            
	            while (rs.next()) {
	                Trainer trainer = new Trainer();
	                trainer.setTrainerId(rs.getInt("trainer_id"));
	                trainer.setFirstName(rs.getString("first_name"));
	                trainer.setLastName(rs.getString("last_name"));
	                trainer.setEmail(rs.getString("email"));
	                trainer.setDescription(rs.getString("description"));
	                trainer.setContactNo(rs.getString("contact_no"));
	                trainer.setProfilePicture(rs.getString("profile_picture"));
	                trainer.setStatus(rs.getString("status"));
	                trainer.setInternal(rs.getBoolean("is_internal"));
	                trainer.setUserId(rs.getInt("user_id"));
	                if (rs.wasNull()) {
	                    trainer.setUserId(null);
	                }
	                
	                trainers.add(trainer);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error getting internal trainers: " + e.getMessage());
	        }
	        
	        return trainers;
	    }
	    
	    
	    
	    
	    public List<Trainer> getExternalTrainers() {
	        List<Trainer> trainers = new ArrayList<>();
	        String sql = "SELECT * FROM trainers WHERE is_internal = FALSE AND status = 'ACTIVE'";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            
	            while (rs.next()) {
	                Trainer trainer = new Trainer();
	                trainer.setTrainerId(rs.getInt("trainer_id"));
	                trainer.setFirstName(rs.getString("first_name"));
	                trainer.setLastName(rs.getString("last_name"));
	                trainer.setEmail(rs.getString("email"));
	                trainer.setDescription(rs.getString("description"));
	                trainer.setContactNo(rs.getString("contact_no"));
	                trainer.setProfilePicture(rs.getString("profile_picture"));
	                trainer.setStatus(rs.getString("status"));
	                trainer.setInternal(rs.getBoolean("is_internal"));
	                
	                trainers.add(trainer);
	            }
	        } catch (SQLException e) {
	            System.out.println("Error getting external trainers: " + e.getMessage());
	        }
	        
	        return trainers;
	    }
	    
	    
	    public boolean deleteTrainer(int trainerId) {
	        String sql = "UPDATE trainers SET status = 'INACTIVE' WHERE trainer_id = ?";
	        
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, trainerId);
	            
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            System.out.println("Error deleting trainer: " + e.getMessage());
	            return false;
	        }
	    }

	    
	    
	    
	    

}
