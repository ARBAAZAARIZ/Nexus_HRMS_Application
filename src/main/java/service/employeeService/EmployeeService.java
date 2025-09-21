package service.employeeService;

import dao.employeeDao.EmployeeDAO;
import model.Users;


public class EmployeeService {

	EmployeeDAO employeeDAO;
	public EmployeeService() {
	
		employeeDAO=new EmployeeDAO();
	}
	
	
	
	public Users getEmployeeByEmail(String email) {
		return employeeDAO.getEmployeeByEmail(email);
	}
	
	 public Users getEmployeeById(int userId) {
		 return employeeDAO.getEmployeeById(userId);
	 }

}
