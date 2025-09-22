package helper.reportHelper;

public class BbLeaveReportHelper implements BbReportData 
{
	private int leaveRequestId;
	private String userName;
	private String leaveType;
    private String startDate;
    private String endDate;
    private int numberOfDays;
    private String reason;
    private String approvedBy;
    private String status;
    private String statusHistory;
    private String profilePicture;

	public BbLeaveReportHelper(int leaveRequestId, String userName, String leaveType, String startDate, String endDate,
			int numberOfDays, String reason, String approvedBy, String status, String statusHistory,
			String profilePicture) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.userName = userName;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.numberOfDays = numberOfDays;
		this.reason = reason;
		this.approvedBy = approvedBy;
		this.status = status;
		this.statusHistory = statusHistory;
		this.profilePicture = profilePicture;
	}
	
	@Override
	public String toString() {
		return "BbLeaveReportHelper [leaveRequestId=" + leaveRequestId + ", userName=" + userName + ", leaveType="
				+ leaveType + ", startDate=" + startDate + ", endDate=" + endDate + ", numberOfDays=" + numberOfDays
				+ ", reason=" + reason + ", approvedBy=" + approvedBy + ", status=" + status + ", statusHistory="
				+ statusHistory + ", profilePicture=" + profilePicture + "]";
	}

	public int getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(String leaveType) {
		this.leaveType = leaveType;
	}

	public String getStartDate() {
		return startDate;
	}

	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}

	public String getEndDate() {
		return endDate;
	}

	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}

	public int getNumberOfDays() {
		return numberOfDays;
	}

	public void setNumberOfDays(int numberOfDays) {
		this.numberOfDays = numberOfDays;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public String getApprovedBy() {
		return approvedBy;
	}

	public void setApprovedBy(String approvedBy) {
		this.approvedBy = approvedBy;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusHistory() {
		return statusHistory;
	}

	public void setStatusHistory(String statusHistory) {
		this.statusHistory = statusHistory;
	}
	
	public String getProfilePicture() {
		return profilePicture;
	}

	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}

	@Override
	public String[] getRowData() {
	    return new String[] {
	        String.valueOf(leaveRequestId),
	        userName,
	        leaveType,
	        startDate,
	        endDate,
	        String.valueOf(numberOfDays),
	        reason,
	        approvedBy,
	        status 
	    };
	}	
}
