package service.employeeService;

import java.util.List;

import dao.employeeDao.DepartmentDAO;
import model.Departments;

public class DepartmentService {

	 DepartmentDAO departmentDAO = new DepartmentDAO();

	    public boolean addDepartment(Departments dept) {
	        return departmentDAO.addDepartment(dept);
	    }
	    
	    public List<Departments> getAllDepartments() {
	        return departmentDAO.getAllDepartments();
	    }
	    
	    public Departments getDepartmentById(int id) {
	        return departmentDAO.getDepartmentById(id);
	    }
	    
	    public boolean updateDepartment(Departments dept) {
	    	return departmentDAO.updateDepartment(dept);
	    	
	    }

	   


}
