package service.leaveservice;

import java.util.ArrayList;
import java.util.List;

import dao.employeeDao.DepartmentDAO;
import dao.leavesdao.DepartmentWiseLeaveDAO;
import dao.leavesdao.MasterLeavesDAO;
import helper.leavehelper.DepartmentLeaveHelper;
import model.DepartmentWiseLeaves;
import model.Departments;
import model.MasterLeaves;

public class DepartmentWiseLeaveService {
	private DepartmentWiseLeaveDAO dao = new DepartmentWiseLeaveDAO();

	private DepartmentDAO deptDAO = new DepartmentDAO();
	private MasterLeavesDAO leavesDAO = new MasterLeavesDAO();

	public boolean addDepartmentWiseLeave(DepartmentWiseLeaves dwl) {
		return dao.addDepartmentWiseLeave(dwl);
	}

	public String validateAndAddLeave(DepartmentWiseLeaves dwl) {
		MasterLeavesDAO leaveDAO = new MasterLeavesDAO();
		String status = leaveDAO.getLeaveTypeStatusById(dwl.getLeaveTypeId());
		if (status == null) {
			return "Invalid leave type selected.";
		}
		if ("INACTIVE".equalsIgnoreCase(status)) {
			return "Cannot assign leaves: Leave type is inactive.";
		}
		boolean inserted = new DepartmentWiseLeaveDAO().addDepartmentWiseLeave(dwl);
		if (inserted) {
			return "Leaves assigned successfully.";
		} else {
			return "Failed to assign leaves.";
		}
	}

	public List<DepartmentLeaveHelper> getAllDepartmentLeaveDetails() {
		List<DepartmentLeaveHelper> helperList = new ArrayList<>();
		List<DepartmentWiseLeaves> dwlList = dao.getAllDepartmentWiseLeaves();

		for (DepartmentWiseLeaves dwl : dwlList) {
			Departments dept = deptDAO.getDepartmentById(dwl.getDepartmentId());
			MasterLeaves leave = leavesDAO.getLeaveTypeById(dwl.getLeaveTypeId());

			String deptName = (dept != null) ? dept.getDepartmentName() : "Unknown Department";
			String leaveName = (leave != null) ? leave.getLeaveTypeName() : "Unknown Leave Type";

			DepartmentLeaveHelper helper = new DepartmentLeaveHelper(dwl.getDepartmentLeaveId(), deptName, leaveName,
					dwl.getLeaveCount(), dwl.getStatus());
			helperList.add(helper);
		}
		return helperList;
	}

	public List<DepartmentLeaveHelper> getLeavesForDepartment(int departmentId) {
		List<DepartmentWiseLeaves> dwList = dao.getLeavesByDepartment(departmentId);
		List<DepartmentLeaveHelper> helpers = new ArrayList<>();
		Departments dept = deptDAO.getDepartmentById(departmentId);

		String deptName = (dept != null) ? dept.getDepartmentName() : "Unknown";
		for (DepartmentWiseLeaves dwl : dwList) {
			MasterLeaves leaveType = leavesDAO.getLeaveTypeById(dwl.getLeaveTypeId());
			String leaveTypeName = (leaveType != null) ? leaveType.getLeaveTypeName() : "Unknown";

			helpers.add(new DepartmentLeaveHelper(dwl.getDepartmentLeaveId(), deptName, leaveTypeName,
					dwl.getLeaveCount(), dwl.getStatus()));
		}
		return helpers;
	}

}
