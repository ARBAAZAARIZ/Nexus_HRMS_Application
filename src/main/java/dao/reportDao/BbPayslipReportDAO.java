package dao.reportDao;

import java.sql.*;
import java.util.*;

import helper.reportHelper.BbPayslipReportHelper;
import util.DatabaseConnection;

public class BbPayslipReportDAO {

	 
    public Map<String, Double> getCardStats() {
        Map<String, Double> stats = new HashMap<>();
        double totalPayroll = 0, totalDeduction = 0, totalEarning = 0, totalNetPay = 0;

        try (Connection con = DatabaseConnection.getConnection()) {

            try (PreparedStatement ps = con.prepareStatement("SELECT IFNULL(SUM(total_salary),0) FROM emp_salary");
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) totalPayroll = rs.getDouble(1);
            }

            try (PreparedStatement ps = con.prepareStatement("SELECT IFNULL(SUM(deduction_percentage),0) FROM deduction");
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) totalDeduction = rs.getDouble(1);
            }

            try (PreparedStatement ps = con.prepareStatement("SELECT IFNULL(SUM(earning_percentage),0) FROM earning");
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) totalEarning = rs.getDouble(1);
            }

            try (PreparedStatement ps = con.prepareStatement("SELECT IFNULL(SUM(net_salary),0) FROM emp_salary");
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) totalNetPay = rs.getDouble(1);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        stats.put("totalPayroll", totalPayroll);
        stats.put("totalDeduction", totalDeduction);
        stats.put("totalEarning", totalEarning);
        stats.put("totalNetPay", totalNetPay);

        return stats;
    }


    
    public List<BbPayslipReportHelper> getPayslipList(int offset, int limit) {
        List<BbPayslipReportHelper> list = new ArrayList<>();

        String sql = "SELECT p.payslip_id, CONCAT(u.first_name,' ',u.last_name) AS empName, " +
                "s.net_salary AS paidAmount, p.pay_month, p.pay_year, u.profile_picture " +
                "FROM payslips p " +
                "JOIN users u ON p.user_id = u.user_id " +
                "JOIN emp_salary s ON s.user_id = u.user_id " +
                "ORDER BY p.payslip_id DESC " +
                "LIMIT ? OFFSET ?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, limit);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    BbPayslipReportHelper h = new BbPayslipReportHelper(
                            rs.getInt("payslip_id"),
                            rs.getString("empName"),
                            rs.getDouble("paidAmount"),
                            rs.getInt("pay_month"),
                            rs.getInt("pay_year"),
                            rs.getString("profile_picture")
                    );

                  
                    System.out.println("Fetched Payslip: " + h.getPayslipId() + " | " + h.getEmpName());

                    list.add(h);
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }

    public Map<String, Double> getMonthlyStats() {
        Map<String, Double> monthlyStats = new LinkedHashMap<>();
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "SELECT p.pay_year, p.pay_month, SUM(s.total_salary) AS totalPayroll " +
                         "FROM payslips p " +
                         "JOIN emp_salary s ON p.user_id = s.user_id " +
                         "GROUP BY p.pay_year, p.pay_month " +
                         "ORDER BY p.pay_year, p.pay_month";

            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                String yearMonth = rs.getInt("pay_year") + "-" + String.format("%02d", rs.getInt("pay_month"));
                double total = rs.getDouble("totalPayroll");
                monthlyStats.put(yearMonth, total);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return monthlyStats;
    }

    public int getTotalPayslipCount() {
        String sql = "SELECT COUNT(*) FROM payslips";
        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            if (rs.next()) return rs.getInt(1);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }
}
