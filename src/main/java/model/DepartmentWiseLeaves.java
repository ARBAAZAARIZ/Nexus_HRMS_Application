package model;

public class DepartmentWiseLeaves {
	private int departmentLeaveId;
	private int leaveTypeId;
	private int leaveCount;
	private String status;
	private int departmentId;

	public DepartmentWiseLeaves() {
	}

	public DepartmentWiseLeaves(int departmentLeaveId, int leaveTypeId, int leaveCount, String status,
			int departmentId) {
		this.departmentLeaveId = departmentLeaveId;
		this.leaveTypeId = leaveTypeId;
		this.leaveCount = leaveCount;
		this.status = status;
		this.departmentId = departmentId;
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

	public int getLeaveCount() {
		return leaveCount;
	}

	public void setLeaveCount(int leaveCount) {
		this.leaveCount = leaveCount;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
}
