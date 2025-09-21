package helper.employeeHelper;

import java.sql.Date;
import java.sql.Timestamp;

public class UserDetails {

	public UserDetails() {
		
	}
	
	 private int userId;
	    private String firstName;
	    private String lastName;
	    private String email;
	   
	    private String contactNumber;
	    private int roleId;
	    private int departmentId;
	    private int designationId;
	    private String roleName;
	    private String departmentName;
	    private String designationName;
	    private Date dateOfJoining;
	    private Date dateOfBirth;
	    private String address;
	    private String profilePicture;
	    private int reportingManager;
	    private String aboutEmployee;
	    private Timestamp createdAt;
	    private String createdBy;
	    private Timestamp modifiedAt;
	    private String modifiedBy;
	    private String status;
	    
		public UserDetails(int userId, String firstName, String lastName, String email, 
				String contactNumber, int roleId, int departmentId, int designationId, String roleName,
				String departmentName, String designationName, Date dateOfJoining, Date dateOfBirth, String address,
				String profilePicture, int reportingManager, String aboutEmployee, Timestamp createdAt,
				String createdBy, Timestamp modifiedAt, String modifiedBy, String status) {
			super();
			this.userId = userId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			
			this.contactNumber = contactNumber;
			this.roleId = roleId;
			this.departmentId = departmentId;
			this.designationId = designationId;
			this.roleName = roleName;
			this.departmentName = departmentName;
			this.designationName = designationName;
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
			this.status = status;
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
		public java.sql.Date getDateOfJoining() {
			return dateOfJoining;
		}
		public void setDateOfJoining(java.sql.Date dateOfJoining) {
			this.dateOfJoining = dateOfJoining;
		}
		public java.sql.Date getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(java.sql.Date dateOfBirth) {
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
		public java.sql.Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(java.sql.Timestamp createdAt) {
			this.createdAt = createdAt;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public java.sql.Timestamp getModifiedAt() {
			return modifiedAt;
		}
		public void setModifiedAt(java.sql.Timestamp modifiedAt) {
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
			return "UserDetails [userId=" + userId + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
					+ email + ", contactNumber=" + contactNumber + ", roleId=" + roleId + ", departmentId="
					+ departmentId + ", designationId=" + designationId + ", roleName=" + roleName + ", departmentName="
					+ departmentName + ", designationName=" + designationName + ", dateOfJoining=" + dateOfJoining
					+ ", dateOfBirth=" + dateOfBirth + ", address=" + address + ", profilePicture=" + profilePicture
					+ ", reportingManager=" + reportingManager + ", aboutEmployee=" + aboutEmployee + ", createdAt="
					+ createdAt + ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt + ", modifiedBy="
					+ modifiedBy + ", status=" + status + "]";
		}
		
		
		
		
		
		
		
		
		
		
		
	    
	    

}
