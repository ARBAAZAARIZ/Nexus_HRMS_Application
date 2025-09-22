package helper.reportHelper;

public class BbPayslipReportHelper implements BbReportData {
    private int payslipId;
    private String empName;
    private double paidAmount;
    private int payMonth;
    private int payYear;
    private String profilePhoto;

    public BbPayslipReportHelper(int payslipId, String empName, double paidAmount,
                                 int payMonth, int payYear, String profilePhoto) {
        this.payslipId = payslipId;
        this.empName = empName;
        this.paidAmount = paidAmount;
        this.payMonth = payMonth;
        this.payYear = payYear;
        this.profilePhoto = profilePhoto;
    }

    
    public int getPayslipId() {
		return payslipId;
	}


	public void setPayslipId(int payslipId) {
		this.payslipId = payslipId;
	}


	public String getEmpName() {
		return empName;
	}


	public void setEmpName(String empName) {
		this.empName = empName;
	}


	public double getPaidAmount() {
		return paidAmount;
	}


	public void setPaidAmount(double paidAmount) {
		this.paidAmount = paidAmount;
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


	public String getProfilePhoto() {
		return profilePhoto;
	}


	public void setProfilePhoto(String profilePhoto) {
		this.profilePhoto = profilePhoto;
	}


	@Override
    public String toString() {
        return "BbPayslipReportHelper [payslipId=" + payslipId + ", empName=" + empName +
               ", paidAmount=" + paidAmount + ", payMonth=" + payMonth +
               ", payYear=" + payYear + ", profilePhoto=" + profilePhoto + "]";
    }

    @Override
    public String[] getRowData() {
        return new String[] {
            String.valueOf(payslipId),
            empName,
           
            String.valueOf(paidAmount),
            String.valueOf(payMonth),
            String.valueOf(payYear)
        };
    }
}
