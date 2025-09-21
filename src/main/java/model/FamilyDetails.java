package model;

import java.sql.Date;

public class FamilyDetails {
    private int familyDetailsId;
    private String name;
    private String relation;
    private Date dateOfBirth;
    private String contactNumber;
    private int userId;
    
    // Constructors
    public FamilyDetails() {}
    
    public FamilyDetails(int familyDetailsId, String name, String relation, 
                        Date dateOfBirth, String contactNumber, int userId) {
        this.familyDetailsId = familyDetailsId;
        this.name = name;
        this.relation = relation;
        this.dateOfBirth = dateOfBirth;
        this.contactNumber = contactNumber;
        this.userId = userId;
    }
    
    // Getters and setters
    public int getFamilyDetailsId() { return familyDetailsId; }
    public void setFamilyDetailsId(int familyDetailsId) { this.familyDetailsId = familyDetailsId; }
    
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    
    public String getRelation() { return relation; }
    public void setRelation(String relation) { this.relation = relation; }
    
    public Date getDateOfBirth() { return dateOfBirth; }
    public void setDateOfBirth(Date dateOfBirth) { this.dateOfBirth = dateOfBirth; }
    
    public String getContactNumber() { return contactNumber; }
    public void setContactNumber(String contactNumber) { this.contactNumber = contactNumber; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    @Override
    public String toString() {
        return "FamilyDetails [familyDetailsId=" + familyDetailsId + ", name=" + name + 
               ", relation=" + relation + ", dateOfBirth=" + dateOfBirth + 
               ", contactNumber=" + contactNumber + ", userId=" + userId + "]";
    }
}