// BankDetailsDAO.java
package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BankDetails;
import util.DatabaseConnection;

public class BankDetailsDAO {
    private Connection conn;
    
    public BankDetailsDAO() {
        conn = DatabaseConnection.getConnection();
    }
    
    
    public List<BankDetails> getBankDetailsByUserId(int userId) {
        List<BankDetails> bankList = new ArrayList<>();
        String sql = "SELECT * FROM bank_details WHERE user_id = ? ORDER BY bank_name";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                BankDetails bank = new BankDetails();
                bank.setBankDetailId(rs.getInt("bank_detail_id"));
                bank.setBankName(rs.getString("bank_name"));
                bank.setAccountNumber(rs.getString("account_number"));
                bank.setIfscCode(rs.getString("ifsc_code"));
                bank.setUserId(rs.getInt("user_id"));
                bankList.add(bank);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bankList;
    }
    
    
    public BankDetails getBankDetailById(int bankDetailId) {
        BankDetails bank = null;
        String sql = "SELECT * FROM bank_details WHERE bank_detail_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, bankDetailId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                bank = new BankDetails();
                bank.setBankDetailId(rs.getInt("bank_detail_id"));
                bank.setBankName(rs.getString("bank_name"));
                bank.setAccountNumber(rs.getString("account_number"));
                bank.setIfscCode(rs.getString("ifsc_code"));
                bank.setUserId(rs.getInt("user_id"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bank;
    }
    
     
    public boolean addBankDetail(BankDetails bank) {
        String sql = "INSERT INTO bank_details (bank_name, account_number, ifsc_code, user_id) VALUES (?, ?, ?, ?)";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bank.getBankName());
            ps.setString(2, bank.getAccountNumber());
            ps.setString(3, bank.getIfscCode());
            ps.setInt(4, bank.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean updateBankDetail(BankDetails bank) {
        String sql = "UPDATE bank_details SET bank_name = ?, account_number = ?, ifsc_code = ? WHERE bank_detail_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, bank.getBankName());
            ps.setString(2, bank.getAccountNumber());
            ps.setString(3, bank.getIfscCode());
            ps.setInt(4, bank.getBankDetailId());
            ps.setInt(5, bank.getUserId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean deleteBankDetail(int bankDetailId, int userId) {
        String sql = "DELETE FROM bank_details WHERE bank_detail_id = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, bankDetailId);
            ps.setInt(2, userId);
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean isAccountNumberExists(String accountNumber, int userId) {
        String sql = "SELECT COUNT(*) FROM bank_details WHERE account_number = ? AND user_id = ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, accountNumber);
            ps.setInt(2, userId);
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) {
                return rs.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}