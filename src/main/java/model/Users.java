package model;

import java.sql.Date;

public class Users {

	public Users() {
		// TODO Auto-generated constructor stub
	}
	
	private int userId;
    private String firstName;
    private String lastName;
    private String email;
    private String hashPassword;
    private String contactNumber;
    private int roleId;
    private int departmentId;
    private int designationId;
    private Date dateOfJoining;
    private Date dateOfBirth;
    private String address;
    private String profilePicture;
    private int reportingManager;
    private String aboutEmployee;
    private Date createdAt;
    private String createdBy;
    private Date modifiedAt;
    private String modifiedBy;
    private String status;
    
    
	public Users(int userId, String firstName, String lastName, String email, String hashPassword, String contactNumber,
			int roleId, int departmentId, int designationId, Date dateOfJoining, Date dateOfBirth, String address,
			String profilePicture, int reportingManager, String aboutEmployee, Date createdAt, String createdBy,
			Date modifiedAt, String modifiedBy , String status) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.hashPassword = hashPassword;
		this.contactNumber = contactNumber;
		this.roleId = roleId;
		this.departmentId = departmentId;
		this.designationId = designationId;
		this.dateOfJoining = dateOfJoining;
		this.dateOfBirth = dateOfBirth;
		this.address = address;
		this.profilePicture = profilePicture;
		this.reportingManager = reportingManager;
		this.aboutEmployee = aboutEmployee;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
		this.status=status;
	}
	
	
	public Users(int userId, String firstName, String lastName) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
	}


	public int getUserId() {
		return userId;
	}


	public void setUserId(int userId) {
		this.userId = userId;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getHashPassword() {
		return hashPassword;
	}


	public void setHashPassword(String hashPassword) {
		this.hashPassword = hashPassword;
	}


	public String getContactNumber() {
		return contactNumber;
	}


	public void setContactNumber(String contactNumber) {
		this.contactNumber = contactNumber;
	}


	public int getRoleId() {
		return roleId;
	}


	public void setRoleId(int roleId) {
		this.roleId = roleId;
	}


	public int getDepartmentId() {
		return departmentId;
	}


	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}


	public int getDesignationId() {
		return designationId;
	}


	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}


	public Date getDateOfJoining() {
		return dateOfJoining;
	}


	public void setDateOfJoining(Date dateOfJoining) {
		this.dateOfJoining = dateOfJoining;
	}


	public Date getDateOfBirth() {
		return dateOfBirth;
	}


	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public String getProfilePicture() {
		return profilePicture;
	}


	public void setProfilePicture(String profilePicture) {
		this.profilePicture = profilePicture;
	}


	public int getReportingManager() {
		return reportingManager;
	}


	public void setReportingManager(int reportingManager) {
		this.reportingManager = reportingManager;
	}


	public String getAboutEmployee() {
		return aboutEmployee;
	}


	public void setAboutEmployee(String aboutEmployee) {
		this.aboutEmployee = aboutEmployee;
	}


	public Date getCreatedAt() {
		return createdAt;
	}


	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}


	public String getCreatedBy() {
		return createdBy;
	}


	public void setCreatedBy(String createdBy) {
		this.createdBy = createdBy;
	}


	public Date getModifiedAt() {
		return modifiedAt;
	}


	public void setModifiedAt(Date modifiedAt) {
		this.modifiedAt = modifiedAt;
	}


	public String getModifiedBy() {
		return modifiedBy;
	}


	public void setModifiedBy(String modifiedBy) {
		this.modifiedBy = modifiedBy;
	}
	
	

	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	@Override
	public String toString() {
		return "Users [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email
				+ ", hashPassword=" + hashPassword + ", contactNumber=" + contactNumber + ", roleId=" + roleId
				+ ", departmentId=" + departmentId + ", designationId=" + designationId + ", dateOfJoining="
				+ dateOfJoining + ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", profilePicture="
				+ profilePicture + ", reportingManager=" + reportingManager + ", aboutEmployee=" + aboutEmployee
				+ ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt
				+ ", modifiedBy=" + modifiedBy + ", status=" + status + "]";
	}

}
