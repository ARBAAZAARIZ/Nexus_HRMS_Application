package dao.leavesdao;

import java.sql.*;
import java.util.*;

import helper.leavehelper.LeaveBalanceHelper;
import model.LeaveBalance;
import util.DatabaseConnection;

public class LeaveBalanceDAO {
	public List<LeaveBalance> getLeaveBalancesByUserAndDepartment(int userId, int departmentId) {
		List<LeaveBalance> list = new ArrayList<>();
		String sql = "SELECT lb.* FROM leave_balance lb "
				+ "JOIN department_wise_leaves dwl ON lb.department_leave_id = dwl.department_leave_id "
				+ "WHERE lb.user_id = ? AND dwl.department_id = ?";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			ps.setInt(2, departmentId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					LeaveBalance lb = new LeaveBalance();
					lb.setLeaveBalanceId(rs.getInt("leave_balance_id"));
					lb.setDepartmentLeaveId(rs.getInt("department_leave_id"));
					lb.setLeaveTypeId(rs.getInt("leave_type_id"));
					lb.setTotalLeaves(rs.getInt("total_leaves"));
					lb.setUsedLeaves(rs.getInt("used_leaves"));
					lb.setUserId(rs.getInt("user_id"));
					list.add(lb);
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching leave balances: " + e.getMessage());
		}
		return list;
	}
	
	public List<LeaveBalanceHelper> getLeaveBalancesByUser(int userId) {
	    List<LeaveBalanceHelper> list = new ArrayList<>();
	    String sql = "SELECT lb.leave_balance_id, lb.total_leaves, lb.used_leaves, ml.leave_type_name " +
	                 "FROM leave_balance lb " +
	                 "JOIN master_leaves ml ON lb.leave_type_id = ml.leave_type_id " +
	                 "WHERE lb.user_id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        try (ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                LeaveBalanceHelper lb = new LeaveBalanceHelper();
	                lb.setLeaveBalanceId(rs.getInt("leave_balance_id"));
	                lb.setLeaveTypeName(rs.getString("leave_type_name"));
	                lb.setTotalLeaves(rs.getInt("total_leaves"));
	                int used = rs.getInt("used_leaves");
	                lb.setRemainingLeaves(lb.getTotalLeaves() - used);
	                list.add(lb);
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error fetching leave balances: " + e.getMessage());
	    }
	    return list;
	}

}
