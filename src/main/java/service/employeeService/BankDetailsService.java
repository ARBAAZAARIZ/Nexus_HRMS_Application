// BankDetailsService.java
package service.employeeService;

import java.util.List;

import dao.employeeDao.BankDetailsDAO;
import model.BankDetails;

public class BankDetailsService {
    private BankDetailsDAO bankDetailsDAO;
    
    public BankDetailsService() {
        bankDetailsDAO = new BankDetailsDAO();
    }
    
    public List<BankDetails> getBankDetailsByUserId(int userId) {
        return bankDetailsDAO.getBankDetailsByUserId(userId);
    }
    
    public BankDetails getBankDetailById(int bankDetailId) {
        return bankDetailsDAO.getBankDetailById(bankDetailId);
    }
    
    public boolean addBankDetail(BankDetails bank) {
        // Check if account number already exists
        if (bankDetailsDAO.isAccountNumberExists(bank.getAccountNumber(), bank.getUserId())) {
            throw new IllegalArgumentException("Account number already exists for this user");
        }
        return bankDetailsDAO.addBankDetail(bank);
    }
    
    public boolean updateBankDetail(BankDetails bank) {
        // Check if account number exists for other records (excluding current one)
        BankDetails existing = bankDetailsDAO.getBankDetailById(bank.getBankDetailId());
        if (existing != null && !existing.getAccountNumber().equals(bank.getAccountNumber())) {
            if (bankDetailsDAO.isAccountNumberExists(bank.getAccountNumber(), bank.getUserId())) {
                throw new IllegalArgumentException("Account number already exists for this user");
            }
        }
        return bankDetailsDAO.updateBankDetail(bank);
    }
    
    public boolean deleteBankDetail(int bankDetailId, int userId) {
        return bankDetailsDAO.deleteBankDetail(bankDetailId, userId);
    }
    
    public boolean isAccountNumberExists(String accountNumber, int userId) {
        return bankDetailsDAO.isAccountNumberExists(accountNumber, userId);
    }
}