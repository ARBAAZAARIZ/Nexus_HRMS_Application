package helper.payrollHelper;

public class DeductionHelper {
	@Override
	public String toString() {
		return "DeductionHelper [deductionId=" + deductionId + ", deductionPercentage=" + deductionPercentage
				+ ", departmentId=" + departmentId + ", departmentName=" + departmentName + ", designationId="
				+ designationId + ", designationName=" + designationName + ", deductionTypeId=" + deductionTypeId
				+ ", deductionTypeName=" + deductionTypeName + ", totalSalary=" + totalSalary + ", calculatedAmount="
				+ calculatedAmount + "]";
	}

	private int deductionId;
	private int deductionPercentage;

	private int departmentId;
	private String departmentName;

	private int designationId;
	private String designationName;

	private int deductionTypeId;
	private String deductionTypeName;
	
	private double totalSalary;
	
	private double calculatedAmount;

    public double getCalculatedAmount() {
        return calculatedAmount;
    }
    public void setCalculatedAmount(double calculatedAmount) {
        this.calculatedAmount = calculatedAmount;
    }

	public double getTotalSalary() {
		return totalSalary;
	}

	public void setTotalSalary(double totalSalary) {
		this.totalSalary = totalSalary;
	}
	
	

	
	public int getDeductionId() {
		return deductionId;
	}

	public void setDeductionId(int deductionId) {
		this.deductionId = deductionId;
	}

	public int getDeductionPercentage() {
		return deductionPercentage;
	}

	public void setDeductionPercentage(int deductionPercentage) {
		this.deductionPercentage = deductionPercentage;
	}

	public int getDepartmentId() {
		return departmentId;
	}

	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public int getDesignationId() {
		return designationId;
	}

	public void setDesignationId(int designationId) {
		this.designationId = designationId;
	}

	public String getDesignationName() {
		return designationName;
	}

	public void setDesignationName(String designationName) {
		this.designationName = designationName;
	}

	public int getDeductionTypeId() {
		return deductionTypeId;
	}

	public void setDeductionTypeId(int deductionTypeId) {
		this.deductionTypeId = deductionTypeId;
	}

	public String getDeductionTypeName() {
		return deductionTypeName;
	}

	public void setDeductionTypeName(String deductionTypeName) {
		this.deductionTypeName = deductionTypeName;
	}
}
