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
	
	
	

    // Add new designation
    public boolean addDesignation(Designations d) {
        return designationDAO.addDesignation(d);
    }

    // Update existing designation
    public boolean updateDesignation(Designations d) {
        return designationDAO.updateDesignation(d);
    }

    // Get all designations with department name
    public List<DesignationHelper> getAllDesignations() {
        return designationDAO.getAllDesignations();
    }

    // Get designation by ID (for edit modal)
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
