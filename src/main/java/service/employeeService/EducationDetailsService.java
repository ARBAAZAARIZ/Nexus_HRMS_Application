// EducationDetailsService.java
package service.employeeService;

import java.util.List;

import dao.employeeDao.EducationDetailsDAO;
import model.EducationDetails;

public class EducationDetailsService {
    private EducationDetailsDAO educationDetailsDAO;
    
    public EducationDetailsService() {
        educationDetailsDAO = new EducationDetailsDAO();
    }
    
    public List<EducationDetails> getEducationDetailsByUserId(int userId) {
        return educationDetailsDAO.getEducationDetailsByUserId(userId);
    }
    
    public boolean addEducationDetail(EducationDetails education) {
        return educationDetailsDAO.addEducationDetail(education);
    }
    
    public boolean updateEducationDetail(EducationDetails education) {
        return educationDetailsDAO.updateEducationDetail(education);
    }
    
    public boolean deleteEducationDetail(int educationDetailId, int userId) {
        return educationDetailsDAO.deleteEducationDetail(educationDetailId, userId);
    }
}