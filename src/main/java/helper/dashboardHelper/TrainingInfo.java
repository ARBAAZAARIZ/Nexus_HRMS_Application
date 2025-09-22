package helper.dashboardHelper;

import java.util.Date;

public class TrainingInfo {
    private int trainingId;
    private String trainingType;
    private String description;
    private Date startDate;
    private Date endDate;
    private String status;
    
    private double trainingCost;
    private String trainerName;
    private String trainerProfilePicture;

    // getters and setters below

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
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

	public double getTrainingCost() {
		return trainingCost;
	}

	public void setTrainingCost(double trainingCost) {
		this.trainingCost = trainingCost;
	}

	public String getTrainerName() {
		return trainerName;
	}

	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}

	public String getTrainerProfilePicture() {
		return trainerProfilePicture;
	}

	public void setTrainerProfilePicture(String trainerProfilePicture) {
		this.trainerProfilePicture = trainerProfilePicture;
	}
    
    
    
    
}
