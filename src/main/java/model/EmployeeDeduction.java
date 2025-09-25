package model;

public class EmployeeDeduction {
    private int employeeDeductionId;
    private int salaryId;
    private int userId;
    private int deductionId;
    private double deductionAmt;

    public int getEmployeeDeductionId() {
        return employeeDeductionId;
    }
    public void setEmployeeDeductionId(int employeeDeductionId) {
        this.employeeDeductionId = employeeDeductionId;
    }
    public int getSalaryId() {
        return salaryId;
    }
    public void setSalaryId(int salaryId) {
        this.salaryId = salaryId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getDeductionId() {
        return deductionId;
    }
    public void setDeductionId(int deductionId) {
        this.deductionId = deductionId;
    }
    public double getDeductionAmt() {
        return deductionAmt;
    }
    public void setDeductionAmt(double deductionAmt) {
        this.deductionAmt = deductionAmt;
    }
}
