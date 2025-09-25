package model;

public class EmployeeEarning {
    private int employeeEarningId;
    private int salaryId;
    private int userId;
    private int earningId;
    private double earningAmt;

    public int getEmployeeEarningId() {
        return employeeEarningId;
    }
    public void setEmployeeEarningId(int employeeEarningId) {
        this.employeeEarningId = employeeEarningId;
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
    public int getEarningId() {
        return earningId;
    }
    public void setEarningId(int earningId) {
        this.earningId = earningId;
    }
    public double getEarningAmt() {
        return earningAmt;
    }
    public void setEarningAmt(double earningAmt) {
        this.earningAmt = earningAmt;
    }
}

