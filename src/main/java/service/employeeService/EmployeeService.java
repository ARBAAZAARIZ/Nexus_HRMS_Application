package service.employeeService;

import java.sql.SQLException;
import java.util.List;

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
	 
	 public List<Users> getAllEmployees() {
		 return employeeDAO.getAllEmployees();
	 }
	 
	 
	 public int saveSalary(int userId, double totalSalary, double netSalary) throws SQLException {
		 return employeeDAO.saveSalary(userId, totalSalary, netSalary);
	 
	 }
	 
	  public boolean saveEmployeeEarning(int userId, int salaryId, int earningId, double earningAmt) throws SQLException {
		  return employeeDAO.saveEmployeeEarning(userId, salaryId, earningId, earningAmt);
	  }
	  
	  public boolean saveEmployeeDeduction(int userId, int salaryId, int deductionId, double deductionAmt) throws SQLException {
		  return employeeDAO.saveEmployeeDeduction(userId, salaryId, deductionId, deductionAmt);
	  }

}
