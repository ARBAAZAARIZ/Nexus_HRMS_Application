package model;


import java.sql.Date;
import java.sql.Timestamp;

public class Training {

	public Training() {
		// TODO Auto-generated constructor stub
	}
	
	
	private int trainingId;
    private int trainingTypeId;
    private int trainerId;
    private int userId;
    private double trainingCost;
    private String description;
    private Date startDate;
    private Date endDate;
    private String status;
    private Timestamp createdAt;
    private String createdBy;
    private Timestamp modifiedAt;
    private String modifiedBy;
	public Training(int trainingId, int trainingTypeId, int trainerId, int userId, double trainingCost,
			String description, Date startDate, Date endDate, String status, Timestamp createdAt, String createdBy,
			Timestamp modifiedAt, String modifiedBy) {
		super();
		this.trainingId = trainingId;
		this.trainingTypeId = trainingTypeId;
		this.trainerId = trainerId;
		this.userId = userId;
		this.trainingCost = trainingCost;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.status = status;
		this.createdAt = createdAt;
		this.createdBy = createdBy;
		this.modifiedAt = modifiedAt;
		this.modifiedBy = modifiedBy;
	}
	public int getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(int trainingId) {
		this.trainingId = trainingId;
	}
	public int getTrainingTypeId() {
		return trainingTypeId;
	}
	public void setTrainingTypeId(int trainingTypeId) {
		this.trainingTypeId = trainingTypeId;
	}
	public int getTrainerId() {
		return trainerId;
	}
	public void setTrainerId(int trainerId) {
		this.trainerId = trainerId;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public double getTrainingCost() {
		return trainingCost;
	}
	public void setTrainingCost(double trainingCost) {
		this.trainingCost = trainingCost;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
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
		return "Training [trainingId=" + trainingId + ", trainingTypeId=" + trainingTypeId + ", trainerId=" + trainerId
				+ ", userId=" + userId + ", trainingCost=" + trainingCost + ", description=" + description
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", status=" + status + ", createdAt="
				+ createdAt + ", createdBy=" + createdBy + ", modifiedAt=" + modifiedAt + ", modifiedBy=" + modifiedBy
				+ "]";
	}
    
    

}
