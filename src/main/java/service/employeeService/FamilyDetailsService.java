package service.employeeService;

import java.util.List;

import dao.employeeDao.FamilyDetailsDAO;
import model.FamilyDetails;

public class FamilyDetailsService {
    private FamilyDetailsDAO familyDetailsDAO;
    
    public FamilyDetailsService() {
        familyDetailsDAO = new FamilyDetailsDAO();
    }
    
    public List<FamilyDetails> getFamilyDetailsByUserId(int userId) {
        return familyDetailsDAO.getFamilyDetailsByUserId(userId);
    }
    
    public FamilyDetails getFamilyDetailById(int familyDetailsId) {
        return familyDetailsDAO.getFamilyDetailById(familyDetailsId);
    }
    
    public boolean addFamilyDetail(FamilyDetails family) {
        
        if (familyDetailsDAO.isFamilyMemberExists(family.getName(), family.getRelation(), family.getUserId())) {
            throw new IllegalArgumentException("Family member with the same name and relation already exists for this user");
        }
        return familyDetailsDAO.addFamilyDetail(family);
    }
    
    public boolean updateFamilyDetail(FamilyDetails family) {
       
        FamilyDetails existing = familyDetailsDAO.getFamilyDetailById(family.getFamilyDetailsId());
        if (existing != null && 
            (!existing.getName().equals(family.getName()) || !existing.getRelation().equals(family.getRelation()))) {
            if (familyDetailsDAO.isFamilyMemberExists(family.getName(), family.getRelation(), family.getUserId())) {
                throw new IllegalArgumentException("Family member with the same name and relation already exists for this user");
            }
        }
        return familyDetailsDAO.updateFamilyDetail(family);
    }
    
    public boolean deleteFamilyDetail(int familyDetailsId, int userId) {
        return familyDetailsDAO.deleteFamilyDetail(familyDetailsId, userId);
    }
    
    public boolean isFamilyMemberExists(String name, String relation, int userId) {
        return familyDetailsDAO.isFamilyMemberExists(name, relation, userId);
    }
}