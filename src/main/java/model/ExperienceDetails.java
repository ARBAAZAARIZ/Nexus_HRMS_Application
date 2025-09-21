// ExperienceDetails.java
package model;

import java.sql.Date;

public class ExperienceDetails {
    private int experienceDetailId;
    private String designationName;
    private Date fromDate;
    private Date toDate;
    private String companyName;
    private int userId;
    
    // Constructors, getters, and setters
    public ExperienceDetails() {}
    
    public ExperienceDetails(int experienceDetailId, String designationName, 
                            Date fromDate, Date toDate, String companyName, int userId) {
        this.experienceDetailId = experienceDetailId;
        this.designationName = designationName;
        this.fromDate = fromDate;
        this.toDate = toDate;
        this.companyName = companyName;
        this.userId = userId;
    }
    
    // Getters and setters for all fields
    public int getExperienceDetailId() { return experienceDetailId; }
    public void setExperienceDetailId(int experienceDetailId) { this.experienceDetailId = experienceDetailId; }
    
    public String getDesignationName() { return designationName; }
    public void setDesignationName(String designationName) { this.designationName = designationName; }
    
    public Date getFromDate() { return fromDate; }
    public void setFromDate(Date fromDate) { this.fromDate = fromDate; }
    
    public Date getToDate() { return toDate; }
    public void setToDate(Date toDate) { this.toDate = toDate; }
    
    public String getCompanyName() { return companyName; }
    public void setCompanyName(String companyName) { this.companyName = companyName; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

	@Override
	public String toString() {
		return "ExperienceDetails [experienceDetailId=" + experienceDetailId + ", designationName=" + designationName
				+ ", fromDate=" + fromDate + ", toDate=" + toDate + ", companyName=" + companyName + ", userId="
				+ userId + "]";
	}
    
    
    
}