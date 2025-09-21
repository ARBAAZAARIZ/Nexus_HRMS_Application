package model;

import java.sql.Timestamp;

public class TrainingType {

	public TrainingType() {
		// TODO Auto-generated constructor stub
	}
	
	
	private int trainingTypeId;
    private String trainingType;
    private String description;
    private String status;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;
	public TrainingType(int trainingTypeId, String trainingType, String description, String status, Timestamp createdAt,
			String createdBy, Timestamp modifiedAt, String modifiedBy) {
		super();
		this.trainingTypeId = trainingTypeId;
		this.trainingType = trainingType;
		this.description = description;
		this.status = status;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
	}
	public int getTrainingTypeId() {
		return trainingTypeId;
	}
	public void setTrainingTypeId(int trainingTypeId) {
		this.trainingTypeId = trainingTypeId;
	}
	public String getTrainingType() {
		return trainingType;
	}
	public void setTrainingType(String trainingType) {
		this.trainingType = trainingType;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
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
		return "TrainingType [trainingTypeId=" + trainingTypeId + ", trainingType=" + trainingType + ", description="
				+ description + ", status=" + status + ", createdAt=" + createdAt + ", createdBy=" + createdBy
				+ ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy + "]";
	}
    
    
    

}
