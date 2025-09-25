package service.employeeService;

import java.util.List;

import dao.employeeDao.DesignationDAO;
import helper.employeeHelper.DesignationHelper;
import model.Designations;

public class DesignationService {

	private DesignationDAO designationDAO;
	public DesignationService() {
		 designationDAO = new DesignationDAO();
	}
	
	
	

   
    public boolean addDesignation(Designations d) {
        return designationDAO.addDesignation(d);
    }

    
    public boolean updateDesignation(Designations d) {
        return designationDAO.updateDesignation(d);
    }

   
    public List<DesignationHelper> getAllDesignations() {
        return designationDAO.getAllDesignations();
    }

    
    public Designations getDesignationById(int id) {
        return designationDAO.getDesignationById(id);
    }
    
    
    
    public List<Designations> getByDepartment(int deptId) {
        return designationDAO.getByDepartment(deptId);
    }
    
    public List<DesignationHelper> getDesignationsByDepartment(int deptId) {
        return designationDAO.getDesignationsByDepartment(deptId);
    }
    
    

}
