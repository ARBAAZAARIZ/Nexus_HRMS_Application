package model;

import java.time.LocalDateTime;

public class Payslip {
    private int payslipId;
    private int userId;
    private int payMonth;
    private int payYear;
    private LocalDateTime generatedAt;
    private String payslipPath;

    public int getPayslipId() {
        return payslipId;
    }
    public void setPayslipId(int payslipId) {
        this.payslipId = payslipId;
    }
    public int getUserId() {
        return userId;
    }
    public void setUserId(int userId) {
        this.userId = userId;
    }
    public int getPayMonth() {
        return payMonth;
    }
    public void setPayMonth(int payMonth) {
        this.payMonth = payMonth;
    }
    public int getPayYear() {
        return payYear;
    }
    public void setPayYear(int payYear) {
        this.payYear = payYear;
    }
    public LocalDateTime getGeneratedAt() {
        return generatedAt;
    }
    public void setGeneratedAt(LocalDateTime generatedAt) {
        this.generatedAt = generatedAt;
    }
    public String getPayslipPath() {
        return payslipPath;
    }
    public void setPayslipPath(String payslipPath) {
        this.payslipPath = payslipPath;
    }
}

