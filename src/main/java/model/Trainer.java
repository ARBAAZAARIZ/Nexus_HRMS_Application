package model;

import java.sql.Timestamp;

public class Trainer {

	public Trainer() {
		// TODO Auto-generated constructor stub
	}
	
	
	 private int trainerId;
	    private String firstName;
	    private String lastName;
	    private String email;
	    private String description;
	    private String contactNo;
	    private String profilePicture;
	    private String status;
	    private boolean isInternal;
	    private Integer userId; // Only for internal trainers
	    private Timestamp createdAt;
	    private String createdBy;
	    private Timestamp modifiedAt;
	    private String modifiedBy;
		public Trainer(int trainerId, String firstName, String lastName, String email, String description,
				String contactNo, String profilePicture, String status, boolean isInternal, Integer userId,
				Timestamp createdAt, String createdBy, Timestamp modifiedAt, String modifiedBy) {
			super();
			this.trainerId = trainerId;
			this.firstName = firstName;
			this.lastName = lastName;
			this.email = email;
			this.description = description;
			this.contactNo = contactNo;
			this.profilePicture = profilePicture;
			this.status = status;
			this.isInternal = isInternal;
			this.userId = userId;
			this.createdAt = createdAt;
			this.createdBy = createdBy;
			this.modifiedAt = modifiedAt;
			this.modifiedBy = modifiedBy;
		}
		public int getTrainerId() {
			return trainerId;
		}
		public void setTrainerId(int trainerId) {
			this.trainerId = trainerId;
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
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public String getContactNo() {
			return contactNo;
		}
		public void setContactNo(String contactNo) {
			this.contactNo = contactNo;
		}
		public String getProfilePicture() {
			return profilePicture;
		}
		public void setProfilePicture(String profilePicture) {
			this.profilePicture = profilePicture;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public boolean isInternal() {
			return isInternal;
		}
		public void setInternal(boolean isInternal) {
			this.isInternal = isInternal;
		}
		public Integer getUserId() {
			return userId;
		}
		public void setUserId(Integer userId) {
			this.userId = userId;
		}
		public Timestamp getCreatedAt() {
			return createdAt;
		}
		public void setCreatedAt(Timestamp createdAt) {
			this.createdAt = createdAt;
		}
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public Timestamp getModifiedAt() {
			return modifiedAt;
		}
		public void setModifiedAt(Timestamp modifiedAt) {
			this.modifiedAt = modifiedAt;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		@Override
		public String toString() {
			return "Trainer [trainerId=" + trainerId + ", firstName=" + firstName + ", lastName=" + lastName
					+ ", email=" + email + ", description=" + description + ", contactNo=" + contactNo
					+ ", profilePicture=" + profilePicture + ", status=" + status + ", isInternal=" + isInternal
					+ ", userId=" + userId + ", createdAt=" + createdAt + ", createdBy=" + createdBy + ", modifiedAt="
					+ modifiedAt + ", modifiedBy=" + modifiedBy + "]";
		}
	    
	    
	    

}
