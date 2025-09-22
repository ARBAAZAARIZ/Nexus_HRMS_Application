package helper.reportHelper;

public class BbPayslipSummaryHelper {

    private double totalPayroll;
    private double totalDeduction;
    private double totalEarning;
    private double totalNetPay;

    public BbPayslipSummaryHelper(double totalPayroll, double totalDeduction, 
                                  double totalEarning, double totalNetPay) {
        this.totalPayroll = totalPayroll;
        this.totalDeduction = totalDeduction;
        this.totalEarning = totalEarning;
        this.totalNetPay = totalNetPay;
    }

    public double getTotalPayroll() {
        return totalPayroll;
    }

    public void setTotalPayroll(double totalPayroll) {
        this.totalPayroll = totalPayroll;
    }

    public double getTotalDeduction() {
        return totalDeduction;
    }

    public void setTotalDeduction(double totalDeduction) {
        this.totalDeduction = totalDeduction;
    }

    public double getTotalEarning() {
        return totalEarning;
    }

    public void setTotalEarning(double totalEarning) {
        this.totalEarning = totalEarning;
    }

    public double getTotalNetPay() {
        return totalNetPay;
    }

    public void setTotalNetPay(double totalNetPay) {
        this.totalNetPay = totalNetPay;
    }

    @Override
    public String toString() {
        return "BbPayslipSummaryHelper [totalPayroll=" + totalPayroll 
                + ", totalDeduction=" + totalDeduction 
                + ", totalEarning=" + totalEarning 
                + ", totalNetPay=" + totalNetPay + "]";
    }
}
