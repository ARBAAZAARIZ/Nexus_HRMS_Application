package model;

public class Deduction {
    private int deductionId;
    private int deductionPercentage;
    private int departmentId;
    private int designationId;
    private int deductionTypeId;

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
    public int getDesignationId() {
        return designationId;
    }
    public void setDesignationId(int designationId) {
        this.designationId = designationId;
    }
    public int getDeductionTypeId() {
        return deductionTypeId;
    }
    public void setDeductionTypeId(int deductionTypeId) {
        this.deductionTypeId = deductionTypeId;
    }
}

