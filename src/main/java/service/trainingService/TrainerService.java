// TrainerService.java
package service.trainingService;

import java.util.List;

import dao.trainingDao.TrainerDAO;
import model.Trainer;

public class TrainerService {
    private TrainerDAO trainerDAO;
    
    public TrainerService() {
        trainerDAO = new TrainerDAO();
    }
    
    public boolean addTrainer(Trainer trainer) {
        return trainerDAO.addTrainer(trainer);
    }
    
    public List<Trainer> getAllTrainers() {
        return trainerDAO.getAllTrainers();
    }
    
    public Trainer getTrainerById(int trainerId) {
        return trainerDAO.getTrainerById(trainerId);
    }
    
    public boolean updateTrainer(Trainer trainer) {
        return trainerDAO.updateTrainer(trainer);
    }   
    
    public List<Trainer> getInternalTrainers() {
        return trainerDAO.getInternalTrainers();
    }
    
    public List<Trainer> getExternalTrainers() {
        return trainerDAO.getExternalTrainers();
    }
    
    
    public boolean deleteTrainer(int trainerId) {
    	return trainerDAO.deleteTrainer(trainerId);
    }
    
    
}