package service.trainingService;

import java.util.List;

import dao.trainingDao.TrainingDAO;
import helper.trainingHelper.TrainingHelper;
import model.Training;

public class TrainingService {
    private TrainingDAO trainingDAO;
    
    public TrainingService() {
        trainingDAO = new TrainingDAO();
    }
    
    public boolean addTraining(Training training) {
        return trainingDAO.addTraining(training);
    }
    
    public List<TrainingHelper> getAllTrainingHelpers() {
        return trainingDAO.getAllTrainingHelpers();
    }
    
    public TrainingHelper getTrainingHelperById(int trainingId) {
        return trainingDAO.getTrainingHelperById(trainingId);
    }
    
    public List<Training> getAllTrainings() {
        return trainingDAO.getAllTrainings();
    }
    
    public Training getTrainingById(int trainingId) {
        return trainingDAO.getTrainingById(trainingId);
    }
    
    public boolean updateTraining(Training training) {
        return trainingDAO.updateTraining(training);
    }
    
    public boolean deleteTraining(int trainingId) {
        return trainingDAO.deleteTraining(trainingId);
    }
    
    public List<TrainingHelper> getTrainingHelpersByUserId(int userId) {
        return trainingDAO.getTrainingHelpersByUserId(userId);
    }
    
    public List<TrainingHelper> getActiveTrainingHelpers() {
        return trainingDAO.getActiveTrainingHelpers();
    }
}