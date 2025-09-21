package service.employeeService;

import java.util.List;

import dao.employeeDao.UserDAO;
import helper.employeeHelper.UserDetails;
import model.Users;

public class UserService {

	 private UserDAO userDAO;

	    public UserService() {
	        userDAO = new UserDAO();
	    }
	    
	    public boolean addUser(Users u) {
	        return userDAO.addUser(u);
	    }
	    
	    public List<UserDetails> getAllUserDetails() {
	        return userDAO.getAllUserDetails();
	    }
	    
	    public  UserDetails getUserDetailsById(int userId) {
	    	return userDAO.getUserDetailsById(userId);
	    }
	    
	    public List<UserDetails> getAllManagers() {
	        return userDAO.getAllManagers();
	    }

	    public List<UserDetails> getManagersByDeptAndDesignation(int deptId, int designationId) {
	        return userDAO.getManagersByDeptAndDesignation(deptId, designationId);
	    }
	    
	    public Users getUserById(int userId) {
	        return userDAO.getUserById(userId);
	    }

	    public boolean updateUser(Users u) {
	        return userDAO.updateUser(u);
	    }
	     	
	    public List<UserDetails> getUsersByIds(String[] userIds) {
	        return userDAO.getUsersByIds(userIds);
	    }

	    public boolean updateUserDetails(UserDetails user) {
	        return new UserDAO().updateUserDetails(user);
	    }
	    
	    public List<UserDetails> getUsersByIds(List<Integer> ids) {		
	        return new UserDAO().getUsersByIds(ids);
	    }


	    public boolean updateUserDetailsForSingleEmployee(UserDetails user) {
	        return userDAO.updateUserDetails(user);
	    }
	    
	    



}
