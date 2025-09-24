package model;

public class MasterLeaves {
	private int leaveTypeId;
	private String leaveTypeName;
	private String status;

	public MasterLeaves() {
	}

	public MasterLeaves(int leaveTypeId, String leaveTypeName, String status) {
		this.leaveTypeId = leaveTypeId;
		this.leaveTypeName = leaveTypeName;
		this.status = status;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
}
