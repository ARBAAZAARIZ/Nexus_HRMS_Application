package model;

public class EmpSalary {
    private int salaryId;
    private int userId;
    private double totalSalary;
    private double netSalary;
    private int month;
    private int year;

    // Optional: employee name (if you want it in PDF)
    private String userName;

    // Getters and Setters
    public int getSalaryId() { return salaryId; }
    public void setSalaryId(int salaryId) { this.salaryId = salaryId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public double getTotalSalary() { return totalSalary; }
    public void setTotalSalary(double totalSalary) { this.totalSalary = totalSalary; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public String getUserName() { return userName; }
    public void setUserName(String userName) { this.userName = userName; }
}
