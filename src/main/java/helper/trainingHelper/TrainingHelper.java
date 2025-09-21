package helper.trainingHelper;

import java.sql.Date;

public class TrainingHelper {

	
	
	
	public TrainingHelper() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	 private int trainingId;
	    private int trainingTypeId;
	    private String trainingTypeName;
	    private int trainerId;
	    private String trainerName;
	    private int userId;
	    private String userName;
	    private double trainingCost;
	    private String description;
	    private Date startDate;
	    private Date endDate;
	    private String status;
	    private String createdBy;
	    private String modifiedBy;
		public TrainingHelper(int trainingId, int trainingTypeId, String trainingTypeName, int trainerId,
				String trainerName, int userId, String userName, double trainingCost, String description,
				Date startDate, Date endDate, String status, String createdBy, String modifiedBy) {
			super();
			this.trainingId = trainingId;
			this.trainingTypeId = trainingTypeId;
			this.trainingTypeName = trainingTypeName;
			this.trainerId = trainerId;
			this.trainerName = trainerName;
			this.userId = userId;
			this.userName = userName;
			this.trainingCost = trainingCost;
			this.description = description;
			this.startDate = startDate;
			this.endDate = endDate;
			this.status = status;
			this.createdBy = createdBy;
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
		public String getTrainingTypeName() {
			return trainingTypeName;
		}
		public void setTrainingTypeName(String trainingTypeName) {
			this.trainingTypeName = trainingTypeName;
		}
		public int getTrainerId() {
			return trainerId;
		}
		public void setTrainerId(int trainerId) {
			this.trainerId = trainerId;
		}
		public String getTrainerName() {
			return trainerName;
		}
		public void setTrainerName(String trainerName) {
			this.trainerName = trainerName;
		}
		public int getUserId() {
			return userId;
		}
		public void setUserId(int userId) {
			this.userId = userId;
		}
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
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
		public String getCreatedBy() {
			return createdBy;
		}
		public void setCreatedBy(String createdBy) {
			this.createdBy = createdBy;
		}
		public String getModifiedBy() {
			return modifiedBy;
		}
		public void setModifiedBy(String modifiedBy) {
			this.modifiedBy = modifiedBy;
		}
		@Override
		public String toString() {
			return "TrainingHelper [trainingId=" + trainingId + ", trainingTypeId=" + trainingTypeId
					+ ", trainingTypeName=" + trainingTypeName + ", trainerId=" + trainerId + ", trainerName="
					+ trainerName + ", userId=" + userId + ", userName=" + userName + ", trainingCost=" + trainingCost
					+ ", description=" + description + ", startDate=" + startDate + ", endDate=" + endDate + ", status="
					+ status + ", createdBy=" + createdBy + ", modifiedBy=" + modifiedBy + "]";
		}
	    
	    
	    
	    

}
