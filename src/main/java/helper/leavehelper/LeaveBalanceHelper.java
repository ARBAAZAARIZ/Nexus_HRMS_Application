package helper.leavehelper;

public class LeaveBalanceHelper {
	private int leaveBalanceId;
	private String leaveTypeName;
	private int totalLeaves; 
	private int remainingLeaves;
	private int usedLeaves;

	public int getUsedLeaves() {
		return usedLeaves;
	}

	public void setUsedLeaves(int usedLeaves) {
		this.usedLeaves = usedLeaves;
	}

	public LeaveBalanceHelper() {
	}

	public LeaveBalanceHelper(int leaveBalanceId, String leaveTypeName, int totalLeaves, int remainingLeaves) {
		this.leaveBalanceId = leaveBalanceId;
		this.leaveTypeName = leaveTypeName;
		this.totalLeaves = totalLeaves;
		this.remainingLeaves = remainingLeaves;
	}

	// Getters and setters
	public int getLeaveBalanceId() {
		return leaveBalanceId;
	}

	public void setLeaveBalanceId(int leaveBalanceId) {
		this.leaveBalanceId = leaveBalanceId;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public int getTotalLeaves() {
		return totalLeaves;
	}

	public void setTotalLeaves(int totalLeaves) {
		this.totalLeaves = totalLeaves;
	}

	public int getRemainingLeaves() {
		return remainingLeaves;
	}

	public void setRemainingLeaves(int remainingLeaves) {
		this.remainingLeaves = remainingLeaves;
	}
}
