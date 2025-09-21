package service.employeeService;

import java.util.List;

import dao.employeeDao.ExperienceDetailsDAO;
import model.ExperienceDetails;

public class ExperienceDetailsService {
    private ExperienceDetailsDAO experienceDetailsDAO;
    
    public ExperienceDetailsService() {
        experienceDetailsDAO = new ExperienceDetailsDAO();
    }
    
    public List<ExperienceDetails> getExperienceDetailsByUserId(int userId) {
        return experienceDetailsDAO.getExperienceDetailsByUserId(userId);
    }
    
    public ExperienceDetails getExperienceDetailById(int experienceDetailId) {
        return experienceDetailsDAO.getExperienceDetailById(experienceDetailId);
    }
    
    public boolean addExperienceDetail(ExperienceDetails experience) {
        // Check if experience already exists
        if (experienceDetailsDAO.isExperienceExists(experience.getCompanyName(), experience.getDesignationName(), experience.getUserId())) {
            throw new IllegalArgumentException("Experience with the same company and designation already exists for this user");
        }
        return experienceDetailsDAO.addExperienceDetail(experience);
    }
    
    public boolean updateExperienceDetail(ExperienceDetails experience) {
        // Check if experience exists for other records (excluding current one)
        ExperienceDetails existing = experienceDetailsDAO.getExperienceDetailById(experience.getExperienceDetailId());
        if (existing != null && 
            (!existing.getCompanyName().equals(experience.getCompanyName()) || !existing.getDesignationName().equals(experience.getDesignationName()))) {
            if (experienceDetailsDAO.isExperienceExists(experience.getCompanyName(), experience.getDesignationName(), experience.getUserId())) {
                throw new IllegalArgumentException("Experience with the same company and designation already exists for this user");
            }
        }
        return experienceDetailsDAO.updateExperienceDetail(experience);
    }
    
    public boolean deleteExperienceDetail(int experienceDetailId, int userId) {
        return experienceDetailsDAO.deleteExperienceDetail(experienceDetailId, userId);
    }
    
    public boolean isExperienceExists(String companyName, String designationName, int userId) {
        return experienceDetailsDAO.isExperienceExists(companyName, designationName, userId);
    }
}