package service.leaveservice;

import java.util.List;

import dao.leavesdao.MasterLeavesDAO;
import model.MasterLeaves;

public class MasterLeavesService {
	private MasterLeavesDAO dao = new MasterLeavesDAO();

	public MasterLeavesService(MasterLeavesDAO dao) {
		this.dao = dao;
	}

	public MasterLeavesService() {
		
	}

	public boolean addLeaveType(MasterLeaves leave) {
		return dao.addLeaveType(leave);
	}

	public List<MasterLeaves> getAllLeaveTypes() {
		return dao.getAllLeaveTypes();
	}

	public boolean deleteLeaveType(int id) {
		return dao.deleteLeaveType(id);
	}

	public boolean changeLeaveTypeStatus(int leaveTypeId, String status) {
		boolean updatedType = dao.updateLeaveTypeStatus(leaveTypeId, status);
		boolean updatedDeptLeaves = dao.updateDepartmentWiseLeavesStatus(leaveTypeId, status);
		return updatedType && updatedDeptLeaves;
	}

	public List<MasterLeaves> getLeaveTypesByDepartment(int departmentId) {
		return dao.getLeaveTypesByDepartment(departmentId);
	}

}
