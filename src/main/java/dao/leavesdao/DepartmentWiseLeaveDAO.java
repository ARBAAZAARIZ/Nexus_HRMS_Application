package dao.leavesdao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.DepartmentWiseLeaves;
import util.DatabaseConnection;

public class DepartmentWiseLeaveDAO {
	public boolean addDepartmentWiseLeave(DepartmentWiseLeaves dwl) {
		String sql = "INSERT INTO department_wise_leaves (leave_type_id, leave_count, department_id, status) VALUES (?, ?, ?, 'ACTIVE')";
		try (Connection conn = DatabaseConnection.getConnection(); PreparedStatement ps = conn.prepareStatement(sql)) {
			ps.setInt(1, dwl.getLeaveTypeId());
			ps.setInt(2, dwl.getLeaveCount());
			ps.setInt(3, dwl.getDepartmentId());
			return ps.executeUpdate() > 0;
		} catch (Exception e) {
			System.out.println("Error adding DepartmentWiseLeave: " + e.getMessage());
			return false;
		}
	}

	public List<DepartmentWiseLeaves> getAllDepartmentWiseLeaves() {
		List<DepartmentWiseLeaves> list = new ArrayList<>();
		String sql = "SELECT * FROM department_wise_leaves ORDER BY department_leave_id DESC";
		try (Connection conn = DatabaseConnection.getConnection();
				PreparedStatement ps = conn.prepareStatement(sql);
				ResultSet rs = ps.executeQuery()) {
			while (rs.next()) {
				DepartmentWiseLeaves dwl = new DepartmentWiseLeaves();
				dwl.setDepartmentLeaveId(rs.getInt("department_leave_id"));
				dwl.setDepartmentId(rs.getInt("department_id"));
				dwl.setLeaveTypeId(rs.getInt("leave_type_id"));
				dwl.setLeaveCount(rs.getInt("leave_count"));
				dwl.setStatus(rs.getString("status"));
				list.add(dwl);
			}
		} catch (Exception e) {
			System.out.println("Error fetching department wise leaves: " + e.getMessage());
		}
		return list;
	}
	
	public List<DepartmentWiseLeaves> getLeavesByDepartment(int departmentId) {
        List<DepartmentWiseLeaves> leaves = new ArrayList<>();
        String sql = "SELECT * FROM department_wise_leaves WHERE department_id = ?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, departmentId);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    DepartmentWiseLeaves leave = new DepartmentWiseLeaves();
                    leave.setDepartmentLeaveId(rs.getInt("department_leave_id"));
                    leave.setDepartmentId(rs.getInt("department_id"));
                    leave.setLeaveTypeId(rs.getInt("leave_type_id"));
                    leave.setLeaveCount(rs.getInt("leave_count"));
                    leave.setStatus(rs.getString("status"));
                    
                    leaves.add(leave);
                }
            }
        } catch (Exception e) {
            System.out.println("Error fetching leaves for department: " + e.getMessage());
        }
        return leaves;
    }
}
