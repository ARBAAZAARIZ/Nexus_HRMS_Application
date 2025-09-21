// TrainingTypeService.java
package service.trainingService;

import java.util.List;

import dao.trainingDao.TrainingTypeDAO;
import model.TrainingType;

public class TrainingTypeService {
    private TrainingTypeDAO trainingTypeDAO;
    
    public TrainingTypeService() {
        trainingTypeDAO = new TrainingTypeDAO();
    }
    
    public boolean addTrainingType(TrainingType trainingType) {
        return trainingTypeDAO.addTrainingType(trainingType);
    }
    
    public List<TrainingType> getAllTrainingTypes() {
        return trainingTypeDAO.getAllTrainingTypes();
    }
    
    public TrainingType getTrainingTypeById(int trainingTypeId) {
        return trainingTypeDAO.getTrainingTypeById(trainingTypeId);
    }
    
    public boolean updateTrainingType(TrainingType trainingType) {
        return trainingTypeDAO.updateTrainingType(trainingType);
    }
    
    public boolean deleteTrainingType(int trainingTypeId) {
    	
    	return trainingTypeDAO.deleteTrainingType(trainingTypeId);
    }
    
    
    

}