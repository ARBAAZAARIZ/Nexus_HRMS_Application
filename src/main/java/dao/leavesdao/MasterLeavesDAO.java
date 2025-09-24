package dao.leavesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.MasterLeaves;
import util.DatabaseConnection;

public class MasterLeavesDAO {

	public MasterLeavesDAO() {
		// Default constructor
	}

	public boolean addLeaveType(MasterLeaves leave) {
		String sql = "INSERT INTO master_leaves (leave_type_name, status) VALUES (?, ?)";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setString(1, leave.getLeaveTypeName());
			stmt.setString(2, leave.getStatus());
			int rows = stmt.executeUpdate();
			return rows > 0;
		} catch (Exception e) {
			System.out.println("Error in MasterLeavesDAO.addLeaveType: " + e.getMessage());
			return false;
		}
	}

	public List<MasterLeaves> getAllLeaveTypes() {
		List<MasterLeaves> leaveTypes = new ArrayList<>();
		String sql = "SELECT * FROM master_leaves ORDER BY leave_type_id DESC";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rs = stmt.executeQuery()) {
			while (rs.next()) {
				MasterLeaves leave = new MasterLeaves();
				leave.setLeaveTypeId(rs.getInt("leave_type_id"));
				leave.setLeaveTypeName(rs.getString("leave_type_name"));
				leave.setStatus(rs.getString("status"));
				leaveTypes.add(leave);
			}
		} catch (Exception e) {
			System.out.println("Error fetching leave types: " + e.getMessage());
		}
		return leaveTypes;
	}

	public boolean deleteLeaveType(int id) {
		String sql = "DELETE FROM master_leaves WHERE leave_type_id = ?";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement stmt = conn.prepareStatement(sql)) {
			stmt.setInt(1, id);
			int rows = stmt.executeUpdate();
			return rows > 0;
		} catch (Exception e) {
			System.out.println("Error deleting leave type: " + e.getMessage());
			return false;
		}
	}

	public String getLeaveTypeStatusById(int leaveTypeId) {
		String sql = "SELECT status FROM master_leaves WHERE leave_type_id = ?";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, leaveTypeId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					return rs.getString("status");
				}
			}
		} catch (Exception e) {
			System.out.println("Error fetching leave type status: " + e.getMessage());
		}
		return null;
	}

	public MasterLeaves getLeaveTypeById(int leaveTypeId) {
		String sql = "SELECT leave_type_id, leave_type_name, status FROM master_leaves WHERE leave_type_id = ?";
		MasterLeaves leave = null;
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, leaveTypeId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next()) {
					leave = new MasterLeaves();
					leave.setLeaveTypeId(rs.getInt("leave_type_id"));
					leave.setLeaveTypeName(rs.getString("leave_type_name"));
					leave.setStatus(rs.getString("status"));
				}
			}
		} catch (Exception e) {
			System.out.println("Error in getLeaveTypeById: " + e.getMessage());
		}
		return leave;
	}

	public boolean updateLeaveTypeStatus(int leaveTypeId, String status) {
		String sql = "UPDATE master_leaves SET status = ? WHERE leave_type_id = ?";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setInt(2, leaveTypeId);
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Error updating leave type status: " + e.getMessage());
			return false;
		}
	}

	public boolean updateDepartmentWiseLeavesStatus(int leaveTypeId, String status) {
		String sql = "UPDATE department_wise_leaves SET status = ? WHERE leave_type_id = ?";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setString(1, status);
			ps.setInt(2, leaveTypeId);
			return ps.executeUpdate() >= 0;  
		} catch (Exception e) {
			System.out.println("Error updating department wise leaves status: " + e.getMessage());
			return false;
		}
	}

	public String getLeaveTypeNameById(int leaveTypeId) {
		String sql = "SELECT leave_type_name FROM master_leaves WHERE leave_type_id = ?";
		String leaveTypeName = "Unknown";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, leaveTypeId);
			try (ResultSet rs = ps.executeQuery()) {
				if (rs.next())
					leaveTypeName = rs.getString("leave_type_name");
			}
		} catch (Exception e) {
			System.out.println("Error fetching leave type name: " + e.getMessage());
		}
		return leaveTypeName;
	}

	public List<MasterLeaves> getLeaveTypesByDepartment(int departmentId) {
        List<MasterLeaves> leaveTypes = new ArrayList<>();
        String sql = "SELECT ml.leave_type_id, ml.leave_type_name FROM master_leaves ml " +
                     "JOIN department_wise_leaves dwl ON ml.leave_type_id = dwl.leave_type_id " +
                     "WHERE dwl.department_id = ? AND dwl.status = 'ACTIVE'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    MasterLeaves leaveType = new MasterLeaves();
                    leaveType.setLeaveTypeId(rs.getInt("leave_type_id"));
                    leaveType.setLeaveTypeName(rs.getString("leave_type_name"));
                    leaveTypes.add(leaveType);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching leave types for department: " + e.getMessage());
        }
        return leaveTypes;
    }
}
