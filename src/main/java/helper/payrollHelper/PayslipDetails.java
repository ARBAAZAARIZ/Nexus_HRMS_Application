package helper.payrollHelper;

import java.util.List;
import model.Users;

public class PayslipDetails {

    private int payslipId;
    private int userId;
    private String employeeName;
    private int month;
    private int year;
    private double baseSalary;
    private double totalEarnings;
    private double totalDeductions;
    private double netSalary;
    private double workedHours;
    private List<EarningHelper> earnings;
    private List<DeductionHelper> deductions;
    private String filePath; // ✅ for PDF view/download

    public PayslipDetails() {}

    // Full constructor
    public PayslipDetails(int payslipId, int userId, String employeeName, int month, int year,
                          double baseSalary, double totalEarnings, double totalDeductions,
                          double netSalary, double workedHours,
                          List<EarningHelper> earnings, List<DeductionHelper> deductions,
                          String filePath) {
        this.payslipId = payslipId;
        this.userId = userId;
        this.employeeName = employeeName;
        this.month = month;
        this.year = year;
        this.baseSalary = baseSalary;
        this.totalEarnings = totalEarnings;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
        this.workedHours = workedHours;
        this.earnings = earnings;
        this.deductions = deductions;
        this.filePath = filePath;
    }

    // Constructor from User entity
    public PayslipDetails(Users emp, int month, int year, double baseSalary,
                          double totalEarnings, double totalDeductions, double netSalary,
                          double workedHours, List<EarningHelper> earnings, List<DeductionHelper> deductions,
                          String filePath) {
        this.userId = emp.getUserId();
        this.employeeName = emp.getFirstName() + " " + emp.getLastName();
        this.month = month;
        this.year = year;
        this.baseSalary = baseSalary;
        this.totalEarnings = totalEarnings;
        this.totalDeductions = totalDeductions;
        this.netSalary = netSalary;
        this.workedHours = workedHours;
        this.earnings = earnings;
        this.deductions = deductions;
        this.filePath = filePath;
    }

    // Getters & setters (including new filePath)
    public int getPayslipId() { return payslipId; }
    public void setPayslipId(int payslipId) { this.payslipId = payslipId; }

    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }

    public String getEmployeeName() { return employeeName; }
    public void setEmployeeName(String employeeName) { this.employeeName = employeeName; }

    public int getMonth() { return month; }
    public void setMonth(int month) { this.month = month; }

    public int getYear() { return year; }
    public void setYear(int year) { this.year = year; }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary; }

    public double getTotalEarnings() { return totalEarnings; }
    public void setTotalEarnings(double totalEarnings) { this.totalEarnings = totalEarnings; }

    public double getTotalDeductions() { return totalDeductions; }
    public void setTotalDeductions(double totalDeductions) { this.totalDeductions = totalDeductions; }

    public double getNetSalary() { return netSalary; }
    public void setNetSalary(double netSalary) { this.netSalary = netSalary; }

    public double getWorkedHours() { return workedHours; }
    public void setWorkedHours(double workedHours) { this.workedHours = workedHours; }

    public List<EarningHelper> getEarnings() { return earnings; }
    public void setEarnings(List<EarningHelper> earnings) { this.earnings = earnings; }

    public List<DeductionHelper> getDeductions() { return deductions; }
    public void setDeductions(List<DeductionHelper> deductions) { this.deductions = deductions; }

    public String getFilePath() { return filePath; }
    public void setFilePath(String filePath) { this.filePath = filePath; }

    @Override
    public String toString() {
        return "PayslipDetails{" +
                "payslipId=" + payslipId +
                ", userId=" + userId +
                ", employeeName='" + employeeName + '\'' +
                ", month=" + month +
                ", year=" + year +
                ", baseSalary=" + baseSalary +
                ", totalEarnings=" + totalEarnings +
                ", totalDeductions=" + totalDeductions +
                ", netSalary=" + netSalary +
                ", workedHours=" + workedHours +
                ", filePath='" + filePath + '\'' +
                ", earnings=" + earnings +
                ", deductions=" + deductions +
                '}';
    }
}
