package dao.leavesdao;

import java.sql.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.*;

import helper.leavehelper.LeaveBalanceHelper;
import helper.leavehelper.LeaveRequestHelper;
import model.LeaveRequests;
import util.DatabaseConnection;

public class LeaveRequestDAO {
	public List<LeaveRequests> getPendingLeaveRequestsByDepartment(int departmentId) {
		List<LeaveRequests> list = new ArrayList<>();
		String sql = "SELECT lr.* FROM leave_requests lr " + "JOIN users u ON lr.user_id = u.user_id "
				+ "WHERE lr.status = 'Pending' AND u.department_id = ? " + "ORDER BY lr.leave_request_id DESC";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, departmentId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					LeaveRequests lr = new LeaveRequests();
					lr.setLeaveRequestId(rs.getInt("leave_request_id"));
					lr.setLeaveTypeId(rs.getInt("leave_type_id"));
					lr.setStartDate(rs.getDate("start_date"));
					lr.setEndDate(rs.getDate("end_date"));
					lr.setNumberOfDays(rs.getInt("number_of_days"));
					lr.setReason(rs.getString("reason"));
					lr.setApprovedAt(rs.getTimestamp("approved_at"));
					lr.setApprovedBy(rs.getString("approved_by"));
					lr.setUserId(rs.getInt("user_id"));
					lr.setStatus(rs.getString("status"));
					lr.setCreatedAt(rs.getTimestamp("created_at"));
					lr.setCreatedBy(rs.getString("created_by"));
					lr.setModifiedAt(rs.getTimestamp("modified_at"));
					lr.setModifiedBy(rs.getString("modified_by"));
					list.add(lr);
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching department leave requests: " + e.getMessage());
		}
		return list;
	}

	public boolean updateLeaveRequestStatus(int requestId, String status, String managerName) {
		String sql = "UPDATE leave_requests SET status = ?, approved_by = ?, approved_at = NOW(), modified_at = NOW(), modified_by = ? WHERE leave_request_id = ?";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setString(2, managerName);
			ps.setString(3, managerName);
			ps.setInt(4, requestId);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Error updating leave request status: " + e.getMessage());
			return false;
		}
	}

	public List<LeaveRequests> getLeaveRequestsByUser(int userId) {
		List<LeaveRequests> list = new ArrayList<>();
		String sql = "SELECT * FROM leave_requests WHERE user_id = ? ORDER BY leave_request_id DESC";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					LeaveRequests lr = new LeaveRequests();
					lr.setLeaveRequestId(rs.getInt("leave_request_id"));
					lr.setLeaveTypeId(rs.getInt("leave_type_id"));
					lr.setStartDate(rs.getDate("start_date"));
					lr.setEndDate(rs.getDate("end_date"));
					lr.setNumberOfDays(rs.getInt("number_of_days"));
					lr.setReason(rs.getString("reason"));
					lr.setApprovedAt(rs.getTimestamp("approved_at"));
					lr.setApprovedBy(rs.getString("approved_by"));
					lr.setUserId(rs.getInt("user_id"));
					lr.setStatus(rs.getString("status"));
					lr.setCreatedAt(rs.getTimestamp("created_at"));
					lr.setCreatedBy(rs.getString("created_by"));
					lr.setModifiedAt(rs.getTimestamp("modified_at"));
					lr.setModifiedBy(rs.getString("modified_by"));
					list.add(lr);
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching leave requests by user: " + e.getMessage());
		}
		return list;
	}

	public boolean insertLeaveRequest(LeaveRequests lr) {
		String sql = "INSERT INTO leave_requests (leave_type_id, start_date, end_date, number_of_days, reason, user_id, status, created_at, created_by) "
				+ "VALUES (?, ?, ?, ?, ?, ?, 'Pending', NOW(), ?)";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, lr.getLeaveTypeId());
			ps.setDate(2, lr.getStartDate());
			ps.setDate(3, lr.getEndDate());
			ps.setInt(4, lr.getNumberOfDays());
			ps.setString(5, lr.getReason());
			ps.setInt(6, lr.getUserId());
			ps.setString(7, lr.getCreatedBy());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Error inserting leave request: " + e.getMessage());
			return false;
		}
	}

	public List<LeaveRequestHelper> getLeaveRequestsWithLeaveTypeName(int userId) {
		List<LeaveRequestHelper> list = new ArrayList<>();
		String sql = "SELECT lr.leave_request_id, ml.leave_type_name, lr.start_date, lr.end_date, lr.reason, "
				+ "lr.number_of_days, lr.status FROM leave_requests lr "
				+ "JOIN master_leaves ml ON lr.leave_type_id = ml.leave_type_id " + "WHERE lr.user_id = ? "
				+ "ORDER BY lr.leave_request_id DESC";

		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, userId);
			try (ResultSet rs = ps.executeQuery()) {
				while (rs.next()) {
					LeaveRequestHelper lr = new LeaveRequestHelper();
					lr.setLeaveRequestId(rs.getInt("leave_request_id"));
					lr.setLeaveTypeName(rs.getString("leave_type_name"));
					lr.setStartDate(rs.getDate("start_date"));
					lr.setEndDate(rs.getDate("end_date"));
					lr.setReason(rs.getString("reason"));
					lr.setNumberOfDays(rs.getInt("number_of_days"));
					lr.setStatus(rs.getString("status"));
					list.add(lr);
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching leave requests with leave type name: " + e.getMessage());
		}
		return list;
	}
	
	 
	public int getUsedLeaves(int leaveBalanceId) {
	    int usedLeaves = 0;
	    String sql = "SELECT used_leaves FROM leave_balance WHERE leave_balance_id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, leaveBalanceId);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                usedLeaves = rs.getInt("used_leaves");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error fetching used leaves: " + e.getMessage());
	    }
	    return usedLeaves;
	}

	 
	public boolean updateUsedLeaves(int leaveBalanceId, int newUsedLeaves) {
	    String sql = "UPDATE leave_balance SET used_leaves = ? WHERE leave_balance_id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, newUsedLeaves);
	        ps.setInt(2, leaveBalanceId);
	        return ps.executeUpdate() > 0;
	    } catch (Exception e) {
	        System.out.println("Error updating used leaves: " + e.getMessage());
	        return false;
	    }
	}

	 
	public int getLeaveBalanceIdByLeaveRequestId(int leaveRequestId) {
	    int leaveBalanceId = 0;
	    String sql = "SELECT lb.leave_balance_id FROM leave_requests lr "
	               + "JOIN leave_balance lb ON lr.user_id = lb.user_id AND lr.leave_type_id = lb.leave_type_id "
	               + "WHERE lr.leave_request_id = ? LIMIT 1";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, leaveRequestId);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                leaveBalanceId = rs.getInt("leave_balance_id");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error fetching leave balance id: " + e.getMessage());
	    }
	    return leaveBalanceId;
	}

	public int getRemainingLeaves(int userId, int leaveTypeId) {
	    int remaining = 0;
	    String sql = "SELECT (total_leaves - used_leaves) AS remaining FROM leave_balance WHERE user_id = ? AND leave_type_id = ?";
	    try (Connection conn = DatabaseConnection.getConnection();
	         PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setInt(1, userId);
	        ps.setInt(2, leaveTypeId);
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                remaining = rs.getInt("remaining");
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Error fetching remaining leaves: " + e.getMessage());
	    }
	    return remaining;
	}

	public Set<LocalDate> getHolidaysBetween(Date startDate, Date endDate) {
    Set<LocalDate> holidays = new HashSet<>();
    String sql = "SELECT e.event_date FROM events e "
               + "JOIN event_type et ON e.event_type_id = et.event_type_id "
               + "WHERE e.event_date BETWEEN ? AND ? "
               + "AND e.status = 'ACTIVE' "
               + "AND et.event_type_name = 'Holiday'";

    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setDate(1, startDate);
        ps.setDate(2, endDate);
        try (ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
               
                holidays.add(rs.getDate("event_date").toLocalDate());
            }
        }
    } catch (Exception e) {
        System.out.println("Error fetching holiday dates: " + e.getMessage());
    }
    return holidays;
}

	public LeaveBalanceHelper getLeaveBalanceForUserAndType(int userId, int leaveTypeId) {
    LeaveBalanceHelper leaveBalance = null;
    String sql = "SELECT leave_balance_id, total_leaves, used_leaves FROM leave_balance " +
                 "WHERE user_id = ? AND leave_type_id = ?";
    try (Connection conn = DatabaseConnection.getConnection();
         PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setInt(1, userId);
        ps.setInt(2, leaveTypeId);

        try (ResultSet rs = ps.executeQuery()) {
            if (rs.next()) {
                leaveBalance = new LeaveBalanceHelper();
                leaveBalance.setLeaveBalanceId(rs.getInt("leave_balance_id"));
                leaveBalance.setTotalLeaves(rs.getInt("total_leaves"));
                leaveBalance.setUsedLeaves(rs.getInt("used_leaves"));
                leaveBalance.setRemainingLeaves(leaveBalance.getTotalLeaves() - leaveBalance.getUsedLeaves());
            }
        }
    } catch (Exception e) {
        System.out.println("Error fetching leave balance for user and type: " + e.getMessage());
    }
    return leaveBalance;
}
	
	
	//New
		public List<LeaveRequestHelper> getNonPendingLeaveRequestsByDepartment(int departmentId) {
			List<LeaveRequestHelper> list = new ArrayList<>();
			String sql = "SELECT lr.leave_request_id, ml.leave_type_name, lr.start_date, lr.end_date, lr.reason, "
					+ "lr.number_of_days, lr.status, u.first_name " + "FROM leave_requests lr "
					+ "JOIN master_leaves ml ON lr.leave_type_id = ml.leave_type_id "
					+ "JOIN users u ON lr.user_id = u.user_id " + "WHERE u.department_id = ? "
					+ "AND lr.status IN ('Approved', 'Rejected') " + "ORDER BY lr.leave_request_id DESC";

			try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
				ps.setInt(1, departmentId);
				try (ResultSet rs = ps.executeQuery()) {
					while (rs.next()) {
						LeaveRequestHelper lr = new LeaveRequestHelper();
						lr.setLeaveRequestId(rs.getInt("leave_request_id"));
						lr.setLeaveTypeName(rs.getString("leave_type_name"));
						lr.setStartDate(rs.getDate("start_date"));
						lr.setEndDate(rs.getDate("end_date"));
						lr.setReason(rs.getString("reason"));
						lr.setNumberOfDays(rs.getInt("number_of_days"));
						lr.setStatus(rs.getString("status"));
						lr.setEmployeeFirstName(rs.getString("first_name"));
						list.add(lr);
					}
				}
			} catch (Exception e) {
				System.out.println("Error fetching department leave requests: " + e.getMessage());
			}
			return list;
		}



	
}
