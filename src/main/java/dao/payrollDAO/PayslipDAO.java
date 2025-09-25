package dao.payrollDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import helper.payrollHelper.PayslipDetails;
import model.EmpSalary;
import model.Payslip;
import util.DatabaseConnection;

public class PayslipDAO {
	Connection conn = DatabaseConnection.getConnection();

	public int saveEmpSalary(int userId, double totalSalary, double netSalary) throws Exception {
		String sql = "INSERT INTO emp_salary (user_id, total_salary, net_salary, created_date) "
				+ "VALUES (?, ?, ?, CURRENT_DATE())";
		int generatedId = -1;

		try (PreparedStatement ps = conn.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

			ps.setInt(1, userId);
			ps.setDouble(2, totalSalary);
			ps.setDouble(3, netSalary);

			ps.executeUpdate();

			try (ResultSet rs = ps.getGeneratedKeys()) {
				if (rs.next()) {
					generatedId = rs.getInt(1);
				}
			}
		}
		return generatedId;
	}

	public void savePayslip(int userId, int month, int year, String pdfPath) throws Exception {
		String sql = "INSERT INTO payslips (user_id, pay_month, pay_year, payslip_path, generated_at) "
				+ "VALUES (?, ?, ?, ?, CURRENT_DATE())";

		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {

			ps.setInt(1, userId);
			ps.setInt(2, month);
			ps.setInt(3, year);
			ps.setString(4, pdfPath);

			ps.executeUpdate();
		}
	}

	public void updateNetSalary(int salaryId, double netSalary) throws SQLException {
		String sql = "UPDATE emp_salary SET net_salary = ? WHERE salary_id = ?";

		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setDouble(1, netSalary);
			ps.setInt(2, salaryId);
			ps.executeUpdate();
		}
	}

	public EmpSalary getSalaryByUserAndMonth(int userId, int month, int year) throws SQLException {
		String sql = "SELECT DISTINCT es.salary_id, es.user_id, es.total_salary, es.net_salary, "
				+ "es.created_date, u.first_name, u.last_name " + "FROM emp_salary es "
				+ "JOIN users u ON es.user_id = u.user_id " + "JOIN attendance a ON es.user_id = a.user_id "
				+ "WHERE es.user_id = ? " + "AND MONTH(a.date) = ? " + "AND YEAR(a.date) = ?";

		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, month);
			ps.setInt(3, year);

			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					EmpSalary salary = new EmpSalary();
					salary.setSalaryId(rs.getInt("salary_id"));
					salary.setUserId(rs.getInt("user_id"));
					salary.setTotalSalary(rs.getDouble("total_salary"));
					salary.setNetSalary(rs.getDouble("net_salary"));

					
					String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
					salary.setUserName(fullName);

					return salary;
				}
			}
		}
		return null;
	}

	public void insertPayslip(int userId, int month, int year, String filePath) throws SQLException {
		String sql = "INSERT INTO payslips(user_id, pay_month, pay_year, payslip_path) VALUES(?, ?, ?, ?)";
		try (PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, month);
			ps.setInt(3, year);
			ps.setString(4, filePath);
			ps.executeUpdate();
		}
	}

	public List<PayslipDetails> getAllPayslips() throws SQLException {
	    List<PayslipDetails> list = new ArrayList<>();
	    String sql = "SELECT p.payslip_id, p.user_id, u.first_name, u.last_name, " +
	                 "p.pay_month, p.pay_year, es.total_salary, es.net_salary, p.payslip_path " +
	                 "FROM payslips p " +
	                 "JOIN users u ON p.user_id = u.user_id " +
	                 "JOIN emp_salary es ON p.user_id = es.user_id " +  // join via user_id
	                 "ORDER BY p.pay_year DESC, p.pay_month DESC";

	    try (PreparedStatement ps = conn.prepareStatement(sql);
	         ResultSet rs = ps.executeQuery()) {
	        while (rs.next()) {
	            PayslipDetails details = new PayslipDetails();
	            details.setPayslipId(rs.getInt("payslip_id"));
	            details.setUserId(rs.getInt("user_id"));
	            details.setEmployeeName(rs.getString("first_name") + " " + rs.getString("last_name"));
	            details.setMonth(rs.getInt("pay_month"));
	            details.setYear(rs.getInt("pay_year"));
	            details.setBaseSalary(rs.getDouble("total_salary"));
	            details.setNetSalary(rs.getDouble("net_salary"));
	            details.setFilePath(rs.getString("payslip_path"));
	            list.add(details);
	        }
	    }
	    return list;
	}

	
	public List<PayslipDetails> getPayslipsByUser(int userId) throws SQLException {
	    List<PayslipDetails> list = new ArrayList<>();
	    String sql = "SELECT p.payslip_id, p.user_id, u.first_name, u.last_name, " +
	                 "p.pay_month, p.pay_year, es.total_salary, es.net_salary, p.payslip_path " +
	                 "FROM payslips p " +
	                 "JOIN users u ON p.user_id = u.user_id " +
	                 "JOIN emp_salary es ON p.user_id = es.user_id " +
	                 "WHERE p.user_id = ? " +
	                 "ORDER BY p.pay_year DESC, p.pay_month DESC";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                PayslipDetails details = new PayslipDetails();
	                details.setPayslipId(rs.getInt("payslip_id"));
	                details.setUserId(rs.getInt("user_id"));
	                details.setEmployeeName(rs.getString("first_name") + " " + rs.getString("last_name"));
	                details.setMonth(rs.getInt("pay_month"));
	                details.setYear(rs.getInt("pay_year"));
	                details.setBaseSalary(rs.getDouble("total_salary"));
	                details.setNetSalary(rs.getDouble("net_salary"));
	                details.setFilePath(rs.getString("payslip_path"));
	                list.add(details);
	            }
	        }
	    }
	    return list;
	}


	
	
	public PayslipDetails getPayslipById(int payslipId) throws SQLException {
	    String sql = "SELECT p.payslip_id, p.user_id, u.first_name, u.last_name, " +
	                 "p.pay_month, p.pay_year, es.total_salary, es.net_salary, " +
	                 "p.payslip_path " +
	                 "FROM payslips p " +
	                 "JOIN users u ON p.user_id = u.user_id " +
	                 "JOIN emp_salary es ON p.user_id = es.user_id " +
	                 "WHERE p.payslip_id = ?";

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, payslipId);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                PayslipDetails details = new PayslipDetails();
	                details.setPayslipId(rs.getInt("payslip_id"));
	                details.setUserId(rs.getInt("user_id"));
	                details.setEmployeeName(rs.getString("first_name") + " " + rs.getString("last_name"));
	                details.setMonth(rs.getInt("pay_month"));
	                details.setYear(rs.getInt("pay_year"));
	                details.setBaseSalary(rs.getDouble("total_salary"));
	                details.setNetSalary(rs.getDouble("net_salary"));
	                details.setFilePath(rs.getString("payslip_path")); // download/view
	                return details;
	            }
	        }
	    }
	    return null;
	}
	
	
	public EmpSalary getLastInsertedSalaryByUserAndMonth(int userId, int month, int year) throws SQLException {
	    String sql = "SELECT es.salary_id, es.user_id, es.total_salary, es.net_salary, "
	               + "es.created_date, u.first_name, u.last_name "
	               + "FROM emp_salary es "
	               + "JOIN users u ON es.user_id = u.user_id "
	               + "JOIN attendance a ON es.user_id = a.user_id "
	               + "WHERE es.user_id = ? "
	               + "AND MONTH(a.date) = ? "
	               + "AND YEAR(a.date) = ? "
	               + "ORDER BY es.salary_id DESC LIMIT 1"; // latest record

	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        ps.setInt(2, month);
	        ps.setInt(3, year);

	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                EmpSalary salary = new EmpSalary();
	                salary.setSalaryId(rs.getInt("salary_id"));
	                salary.setUserId(rs.getInt("user_id"));
	                salary.setTotalSalary(rs.getDouble("total_salary"));
	                salary.setNetSalary(rs.getDouble("net_salary"));

	                String fullName = rs.getString("first_name") + " " + rs.getString("last_name");
	                salary.setUserName(fullName);

	                return salary;
	            }
	        }
	    }
	    return null;
	}


}
