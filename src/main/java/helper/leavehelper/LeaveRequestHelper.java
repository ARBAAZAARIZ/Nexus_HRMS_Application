package helper.leavehelper;

import java.sql.Date;

public class LeaveRequestHelper {
	private int leaveRequestId;
	private String leaveTypeName;
	private String employeeFirstName;
	private String approvedBy;
	private Date startDate;
	private Date endDate;
	private String reason;
	private int numberOfDays;
	private String status;

	public LeaveRequestHelper() {
	}

	public LeaveRequestHelper(int leaveRequestId, String leaveTypeName, String employeeFirstName, String approvedBy,
			Date startDate, Date endDate, String reason, int numberOfDays, String status) {
		this.leaveRequestId = leaveRequestId;
		this.leaveTypeName = leaveTypeName;
		this.employeeFirstName = employeeFirstName;
		this.approvedBy = approvedBy;
		this.startDate = startDate;
		this.endDate = endDate;
		this.reason = reason;
		this.numberOfDays = numberOfDays;
		this.status = status;
	}

	public int getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getEmployeeFirstName() {
		return employeeFirstName;
	}

	public void setEmployeeFirstName(String employeeFirstName) {
		this.employeeFirstName = employeeFirstName;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
