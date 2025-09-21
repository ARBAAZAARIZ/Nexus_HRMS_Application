// EducationDetails.java
package model;

import java.sql.Date;

public class EducationDetails {
    private int educationDetailId;
    private String educationName;
    private String universityName;
    private Date startDate;
    private Date endDate;
    private int userId;
    
    // Constructors, getters, and setters
    public EducationDetails() {}
    
    public EducationDetails(int educationDetailId, String educationName, String universityName, 
                           Date startDate, Date endDate, int userId) {
        this.educationDetailId = educationDetailId;
        this.educationName = educationName;
        this.universityName = universityName;
        this.startDate = startDate;
        this.endDate = endDate;
        this.userId = userId;
    }
    
    // Getters and setters for all fields
    public int getEducationDetailId() { return educationDetailId; }
    public void setEducationDetailId(int educationDetailId) { this.educationDetailId = educationDetailId; }
    
    public String getEducationName() { return educationName; }
    public void setEducationName(String educationName) { this.educationName = educationName; }
    
    public String getUniversityName() { return universityName; }
    public void setUniversityName(String universityName) { this.universityName = universityName; }
    
    public Date getStartDate() { return startDate; }
    public void setStartDate(Date startDate) { this.startDate = startDate; }
    
    public Date getEndDate() { return endDate; }
    public void setEndDate(Date endDate) { this.endDate = endDate; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

	@Override
	public String toString() {
		return "EducationDetails [educationDetailId=" + educationDetailId + ", educationName=" + educationName
				+ ", universityName=" + universityName + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", userId=" + userId + "]";
	}
    
    
    
    
}