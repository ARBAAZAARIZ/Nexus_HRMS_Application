package service.employeeService;

import java.util.List;

import dao.employeeDao.RoleDAO;
import model.Roles;

public class RoleService {

	 private RoleDAO roleDAO;
	 public RoleService() {
	        roleDAO = new RoleDAO();
	    }

	    public boolean addRole(Roles r) {
	        return roleDAO.addRole(r);
	    }

	    public boolean updateRole(Roles r) {
	        return roleDAO.updateRole(r);
	    }

	    public List<Roles> getAllRoles() {
	        return roleDAO.getAllRoles();
	    }

	    public Roles getRoleById(int id) {
	        return roleDAO.getRoleById(id);
	    }

}
