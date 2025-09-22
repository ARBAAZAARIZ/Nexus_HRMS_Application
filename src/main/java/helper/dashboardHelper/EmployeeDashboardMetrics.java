package helper.dashboardHelper;

import java.util.Date;

public class EmployeeDashboardMetrics {
    private String roleName;
    private String departmentName;
    private String designationName;
    private Date dateOfJoining;
    private String reportingManagerName;
    private int upcomingTrainings;
    private int completedTrainings;

    // Getters and Setters for all above fields

    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
    public String getDepartmentName() {
        return departmentName;
    }
    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }
    public String getDesignationName() {
        return designationName;
    }
    public void setDesignationName(String designationName) {
        this.designationName = designationName;
    }
    public Date getDateOfJoining() {
        return dateOfJoining;
    }
    public void setDateOfJoining(Date dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }
    public String getReportingManagerName() {
        return reportingManagerName;
    }
    public void setReportingManagerName(String reportingManagerName) {
        this.reportingManagerName = reportingManagerName;
    }
    public int getUpcomingTrainings() {
        return upcomingTrainings;
    }
    public void setUpcomingTrainings(int upcomingTrainings) {
        this.upcomingTrainings = upcomingTrainings;
    }
    public int getCompletedTrainings() {
        return completedTrainings;
    }
    public void setCompletedTrainings(int completedTrainings) {
        this.completedTrainings = completedTrainings;
    }
	@Override
	public String toString() {
		return "EmployeeDashboardMetrics [roleName=" + roleName + ", departmentName=" + departmentName
				+ ", designationName=" + designationName + ", dateOfJoining=" + dateOfJoining
				+ ", reportingManagerName=" + reportingManagerName + ", upcomingTrainings=" + upcomingTrainings
				+ ", completedTrainings=" + completedTrainings + "]";
	}
    
    
    
    
    
}
