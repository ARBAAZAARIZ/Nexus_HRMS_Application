package helper.payrollHelper;

public class EarningHelper {
	private int earningId;
	private int earningTypeId;
	private String earningTypeName; 
	private double earningPercentage;
	private int departmentId;
	private String departmentName;
	private int designationId;
	private String designationName;
	
	private double totalSalary;
	private double calculatedAmount; 

    public double getCalculatedAmount() {
        return calculatedAmount;
    }
    @Override
	public String toString() {
		return "EarningHelper [earningId=" + earningId + ", earningTypeId=" + earningTypeId + ", earningTypeName="
				+ earningTypeName + ", earningPercentage=" + earningPercentage + ", departmentId=" + departmentId
				+ ", departmentName=" + departmentName + ", designationId=" + designationId + ", designationName="
				+ designationName + ", totalSalary=" + totalSalary + ", calculatedAmount=" + calculatedAmount + "]";
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


	
	public int getEarningId() {
		return earningId;
	}

	public void setEarningId(int earningId) {
		this.earningId = earningId;
	}

	public int getEarningTypeId() {
		return earningTypeId;
	}

	public void setEarningTypeId(int earningTypeId) {
		this.earningTypeId = earningTypeId;
	}

	public String getEarningTypeName() {
		return earningTypeName;
	}

	public void setEarningTypeName(String earningTypeName) {
		this.earningTypeName = earningTypeName;
	}

	public double getEarningPercentage() {
		return earningPercentage;
	}

	public void setEarningPercentage(double earningPercentage) {
		this.earningPercentage = earningPercentage;
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
	
	
}
