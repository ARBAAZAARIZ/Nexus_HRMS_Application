package dao.trainingDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.trainingHelper.TrainingHelper;
import model.Training;
import util.DatabaseConnection;

public class TrainingDAO {

    private Connection conn;
    
    public TrainingDAO() {
        conn = DatabaseConnection.getConnection();
    }
    
    // Add a new training
    public boolean addTraining(Training training) {
        String sql = "INSERT INTO training (training_type_id, trainer_id, user_id, training_cost, description, start_date, end_date, status, created_by) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, training.getTrainingTypeId());
            ps.setInt(2, training.getTrainerId());
            ps.setInt(3, training.getUserId());
            ps.setDouble(4, training.getTrainingCost());
            ps.setString(5, training.getDescription());
            ps.setDate(6, training.getStartDate());
            
            if (training.getEndDate() != null) {
                ps.setDate(7, training.getEndDate());
            } else {
                ps.setNull(7, java.sql.Types.DATE);
            }
            
            ps.setString(8, training.getStatus());
            ps.setString(9, training.getCreatedBy());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error adding training: " + e.getMessage());
            return false;
        }
    }
    
    
    // Get all trainings with joined data (using TrainingHelper)
    public List<TrainingHelper> getAllTrainingHelpers() {
        List<TrainingHelper> trainings = new ArrayList<>();
        String sql = "SELECT t.*, tt.training_type as training_type_name, " +
                     "CONCAT(tr.first_name, ' ', tr.last_name) as trainer_name, " +
                     "CONCAT(u.first_name, ' ', u.last_name) as user_name " +
                     "FROM training t " +
                     "JOIN training_type tt ON t.training_type_id = tt.training_type_id " +
                     "JOIN trainers tr ON t.trainer_id = tr.trainer_id " +
                     "JOIN users u ON t.user_id = u.user_id " +
                     "ORDER BY t.created_at DESC";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                TrainingHelper training = new TrainingHelper();
                training.setTrainingId(rs.getInt("training_id"));
                training.setTrainingTypeId(rs.getInt("training_type_id"));
                training.setTrainingTypeName(rs.getString("training_type_name"));
                training.setTrainerId(rs.getInt("trainer_id"));
                training.setTrainerName(rs.getString("trainer_name"));
                training.setUserId(rs.getInt("user_id"));
                training.setUserName(rs.getString("user_name"));
                training.setTrainingCost(rs.getDouble("training_cost"));
                training.setDescription(rs.getString("description"));
                training.setStartDate(rs.getDate("start_date"));
                training.setEndDate(rs.getDate("end_date"));
                training.setStatus(rs.getString("status"));
                training.setCreatedBy(rs.getString("created_by"));
                training.setModifiedBy(rs.getString("modified_by"));
                
                trainings.add(training);
            }
        } catch (SQLException e) {
            System.out.println("Error getting trainings with helper: " + e.getMessage());
        }
        
        return trainings;
    }
    
    
    
 // Get training by ID with joined data (using TrainingHelper)
    public TrainingHelper getTrainingHelperById(int trainingId) {
        TrainingHelper training = null;
        String sql = "SELECT t.*, tt.training_type as training_type_name, " +
                     "CONCAT(tr.first_name, ' ', tr.last_name) as trainer_name, " +
                     "CONCAT(u.first_name, ' ', u.last_name) as user_name " +
                     "FROM training t " +
                     "JOIN training_type tt ON t.training_type_id = tt.training_type_id " +
                     "JOIN trainers tr ON t.trainer_id = tr.trainer_id " +
                     "JOIN users u ON t.user_id = u.user_id " +
                     "WHERE t.training_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, trainingId);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    training = new TrainingHelper();
                    training.setTrainingId(rs.getInt("training_id"));
                    training.setTrainingTypeId(rs.getInt("training_type_id"));
                    training.setTrainingTypeName(rs.getString("training_type_name"));
                    training.setTrainerId(rs.getInt("trainer_id"));
                    training.setTrainerName(rs.getString("trainer_name"));
                    training.setUserId(rs.getInt("user_id"));
                    training.setUserName(rs.getString("user_name"));
                    training.setTrainingCost(rs.getDouble("training_cost"));
                    training.setDescription(rs.getString("description"));
                    training.setStartDate(rs.getDate("start_date"));
                    training.setEndDate(rs.getDate("end_date"));
                    training.setStatus(rs.getString("status"));
                    training.setCreatedBy(rs.getString("created_by"));
                    training.setModifiedBy(rs.getString("modified_by"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting training by ID with helper: " + e.getMessage());
        }
        
        return training;
    }
    
    
    // Get all trainings (basic model without joins)
    public List<Training> getAllTrainings() {
        List<Training> trainings = new ArrayList<>();
        String sql = "SELECT * FROM training ORDER BY created_at DESC";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                Training training = new Training();
                training.setTrainingId(rs.getInt("training_id"));
                training.setTrainingTypeId(rs.getInt("training_type_id"));
                training.setTrainerId(rs.getInt("trainer_id"));
                training.setUserId(rs.getInt("user_id"));
                training.setTrainingCost(rs.getDouble("training_cost"));
                training.setDescription(rs.getString("description"));
                training.setStartDate(rs.getDate("start_date"));
                training.setEndDate(rs.getDate("end_date"));
                training.setStatus(rs.getString("status"));
                training.setCreatedAt(rs.getTimestamp("created_at"));
                training.setCreatedBy(rs.getString("created_by"));
                training.setModifiedAt(rs.getTimestamp("modified_at"));
                training.setModifiedBy(rs.getString("modified_by"));
                
                trainings.add(training);
            }
        } catch (SQLException e) {
            System.out.println("Error getting trainings: " + e.getMessage());
        }
        
        return trainings;
    }

    
    
    // Get training by ID (basic model)
    public Training getTrainingById(int trainingId) {
        Training training = null;
        String sql = "SELECT * FROM training WHERE training_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, trainingId);
            
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    training = new Training();
                    training.setTrainingId(rs.getInt("training_id"));
                    training.setTrainingTypeId(rs.getInt("training_type_id"));
                    training.setTrainerId(rs.getInt("trainer_id"));
                    training.setUserId(rs.getInt("user_id"));
                    training.setTrainingCost(rs.getDouble("training_cost"));
                    training.setDescription(rs.getString("description"));
                    training.setStartDate(rs.getDate("start_date"));
                    training.setEndDate(rs.getDate("end_date"));
                    training.setStatus(rs.getString("status"));
                    training.setCreatedAt(rs.getTimestamp("created_at"));
                    training.setCreatedBy(rs.getString("created_by"));
                    training.setModifiedAt(rs.getTimestamp("modified_at"));
                    training.setModifiedBy(rs.getString("modified_by"));
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting training by ID: " + e.getMessage());
        }
        
        return training;
    }
    
    
    
    // Update training
    public boolean updateTraining(Training training) {
        String sql = "UPDATE training SET training_type_id = ?, trainer_id = ?, user_id = ?, " +
                     "training_cost = ?, description = ?, start_date = ?, end_date = ?, " +
                     "status = ?, modified_by = ? WHERE training_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, training.getTrainingTypeId());
            ps.setInt(2, training.getTrainerId());
            ps.setInt(3, training.getUserId());
            ps.setDouble(4, training.getTrainingCost());
            ps.setString(5, training.getDescription());
            ps.setDate(6, training.getStartDate());
            
            if (training.getEndDate() != null) {
                ps.setDate(7, training.getEndDate());
            } else {
                ps.setNull(7, java.sql.Types.DATE);
            }
            
            ps.setString(8, training.getStatus());
            ps.setString(9, training.getModifiedBy());
            ps.setInt(10, training.getTrainingId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error updating training: " + e.getMessage());
            return false;
        }
    }
    
    
    
    // Get trainings by user ID with joined data
    public List<TrainingHelper> getTrainingHelpersByUserId(int userId) {
        List<TrainingHelper> trainings = new ArrayList<>();
        String sql = "SELECT t.*, tt.training_type as training_type_name, " +
                     "CONCAT(tr.first_name, ' ', tr.last_name) as trainer_name, " +
                     "CONCAT(u.first_name, ' ', u.last_name) as user_name " +
                     "FROM training t " +
                     "JOIN training_type tt ON t.training_type_id = tt.training_type_id " +
                     "JOIN trainers tr ON t.trainer_id = tr.trainer_id " +
                     "JOIN users u ON t.user_id = u.user_id " +
                     "WHERE t.user_id = ? " +
                     "ORDER BY t.created_at DESC";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    TrainingHelper training = new TrainingHelper();
                    training.setTrainingId(rs.getInt("training_id"));
                    training.setTrainingTypeId(rs.getInt("training_type_id"));
                    training.setTrainingTypeName(rs.getString("training_type_name"));
                    training.setTrainerId(rs.getInt("trainer_id"));
                    training.setTrainerName(rs.getString("trainer_name"));
                    training.setUserId(rs.getInt("user_id"));
                    training.setUserName(rs.getString("user_name"));
                    training.setTrainingCost(rs.getDouble("training_cost"));
                    training.setDescription(rs.getString("description"));
                    training.setStartDate(rs.getDate("start_date"));
                    training.setEndDate(rs.getDate("end_date"));
                    training.setStatus(rs.getString("status"));
                    training.setCreatedBy(rs.getString("created_by"));
                    training.setModifiedBy(rs.getString("modified_by"));
                    
                    trainings.add(training);
                }
            }
        } catch (SQLException e) {
            System.out.println("Error getting trainings by user ID: " + e.getMessage());
        }
        
        return trainings;
    }
    
    
    
    // Get active trainings with joined data
    public List<TrainingHelper> getActiveTrainingHelpers() {
        List<TrainingHelper> trainings = new ArrayList<>();
        String sql = "SELECT t.*, tt.training_type as training_type_name, " +
                     "CONCAT(tr.first_name, ' ', tr.last_name) as trainer_name, " +
                     "CONCAT(u.first_name, ' ', u.last_name) as user_name " +
                     "FROM training t " +
                     "JOIN training_type tt ON t.training_type_id = tt.training_type_id " +
                     "JOIN trainers tr ON t.trainer_id = tr.trainer_id " +
                     "JOIN users u ON t.user_id = u.user_id " +
                     "WHERE t.status = 'ACTIVE' " +
                     "ORDER BY t.start_date ASC";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            while (rs.next()) {
                TrainingHelper training = new TrainingHelper();
                training.setTrainingId(rs.getInt("training_id"));
                training.setTrainingTypeId(rs.getInt("training_type_id"));
                training.setTrainingTypeName(rs.getString("training_type_name"));
                training.setTrainerId(rs.getInt("trainer_id"));
                training.setTrainerName(rs.getString("trainer_name"));
                training.setUserId(rs.getInt("user_id"));
                training.setUserName(rs.getString("user_name"));
                training.setTrainingCost(rs.getDouble("training_cost"));
                training.setDescription(rs.getString("description"));
                training.setStartDate(rs.getDate("start_date"));
                training.setEndDate(rs.getDate("end_date"));
                training.setStatus(rs.getString("status"));
                training.setCreatedBy(rs.getString("created_by"));
                training.setModifiedBy(rs.getString("modified_by"));
                
                trainings.add(training);
            }
        } catch (SQLException e) {
            System.out.println("Error getting active trainings: " + e.getMessage());
        }
        
        return trainings;
    }
    
    
    
 // Delete training (set status to INACTIVE)
    public boolean deleteTraining(int trainingId) {
        String sql = "UPDATE training SET status = 'INACTIVE' WHERE training_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, trainingId);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error deleting training: " + e.getMessage());
            return false;
        }
    }

    

}
