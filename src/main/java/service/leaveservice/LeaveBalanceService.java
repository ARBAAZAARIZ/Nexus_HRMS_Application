package service.leaveservice;

import model.LeaveBalance;

import java.util.ArrayList;
import java.util.List;

import dao.leavesdao.LeaveBalanceDAO;
import dao.leavesdao.MasterLeavesDAO;
import helper.leavehelper.LeaveBalanceHelper;

public class LeaveBalanceService {

	private LeaveBalanceDAO leaveBalanceDAO = new LeaveBalanceDAO();
	private MasterLeavesDAO masterLeavesDAO = new MasterLeavesDAO();

	public List<LeaveBalanceHelper> getLeaveBalancesForUserDepartment(int userId, int departmentId) {
		List<LeaveBalance> leaveBalances = leaveBalanceDAO.getLeaveBalancesByUserAndDepartment(userId, departmentId);
		List<LeaveBalanceHelper> helpers = new ArrayList<>();

		for (LeaveBalance lb : leaveBalances) {
			String leaveTypeName = masterLeavesDAO.getLeaveTypeNameById(lb.getLeaveTypeId());
			int remaining = lb.getTotalLeaves() - lb.getUsedLeaves();

			helpers.add(new LeaveBalanceHelper(lb.getLeaveBalanceId(), leaveTypeName, lb.getTotalLeaves(), remaining));
		}
		return helpers;
	}

	public List<LeaveBalanceHelper> getLeaveBalancesByUser(int userId) {
	
		return leaveBalanceDAO.getLeaveBalancesByUser(userId);
	}
}
