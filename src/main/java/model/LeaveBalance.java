package model;

public class LeaveBalance {
	private int leaveBalanceId;
	private int departmentLeaveId;
	private int leaveTypeId;
	private int totalLeaves;
	private int usedLeaves;
	private int userId;

	public LeaveBalance() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LeaveBalance(int leaveBalanceId, int departmentLeaveId, int leaveTypeId, int totalLeaves, int usedLeaves,
			int userId) {
		super();
		this.leaveBalanceId = leaveBalanceId;
		this.departmentLeaveId = departmentLeaveId;
		this.leaveTypeId = leaveTypeId;
		this.totalLeaves = totalLeaves;
		this.usedLeaves = usedLeaves;
		this.userId = userId;
	}

	public int getLeaveBalanceId() {
		return leaveBalanceId;
	}

	public void setLeaveBalanceId(int leaveBalanceId) {
		this.leaveBalanceId = leaveBalanceId;
	}

	public int getDepartmentLeaveId() {
		return departmentLeaveId;
	}

	public void setDepartmentLeaveId(int departmentLeaveId) {
		this.departmentLeaveId = departmentLeaveId;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public int getUsedLeaves() {
		return usedLeaves;
	}

	public void setUsedLeaves(int usedLeaves) {
		this.usedLeaves = usedLeaves;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
