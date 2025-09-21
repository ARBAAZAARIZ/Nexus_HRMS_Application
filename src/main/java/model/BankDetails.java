// BankDetails.java
package model;

public class BankDetails {
    private int bankDetailId;
    private String bankName;
    private String accountNumber;
    private String ifscCode;
    private int userId;
    
    // Constructors
    public BankDetails() {}
    
    public BankDetails(int bankDetailId, String bankName, String accountNumber, 
                      String ifscCode, int userId) {
        this.bankDetailId = bankDetailId;
        this.bankName = bankName;
        this.accountNumber = accountNumber;
        this.ifscCode = ifscCode;
        this.userId = userId;
    }
    
    // Getters and setters
    public int getBankDetailId() { return bankDetailId; }
    public void setBankDetailId(int bankDetailId) { this.bankDetailId = bankDetailId; }
    
    public String getBankName() { return bankName; }
    public void setBankName(String bankName) { this.bankName = bankName; }
    
    public String getAccountNumber() { return accountNumber; }
    public void setAccountNumber(String accountNumber) { this.accountNumber = accountNumber; }
    
    public String getIfscCode() { return ifscCode; }
    public void setIfscCode(String ifscCode) { this.ifscCode = ifscCode; }
    
    public int getUserId() { return userId; }
    public void setUserId(int userId) { this.userId = userId; }
    
    @Override
    public String toString() {
        return "BankDetails [bankDetailId=" + bankDetailId + ", bankName=" + bankName + 
               ", accountNumber=" + accountNumber + ", ifscCode=" + ifscCode + 
               ", userId=" + userId + "]";
    }
}