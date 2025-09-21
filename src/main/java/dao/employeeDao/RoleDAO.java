package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Roles;
import util.DatabaseConnection;

public class RoleDAO {

	
	 private Connection conn;
	public RoleDAO() {
		
		conn=DatabaseConnection.getConnection();
		
	}
	
	
	 public boolean addRole(Roles r) {
	        String sql = "INSERT INTO roles (role_name, status, created_by) VALUES (?, ?, ?)";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, r.getRoleName());
	            ps.setString(2, r.getStatus());
	            ps.setString(3, r.getCreatedBy());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public boolean updateRole(Roles r) {
	        String sql = "UPDATE roles SET role_name=?, status=?, modified_by=? WHERE role_id=?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setString(1, r.getRoleName());
	            ps.setString(2, r.getStatus());
	            ps.setString(3, r.getModifiedBy());
	            ps.setInt(4, r.getRoleId());
	            return ps.executeUpdate() > 0;
	        } catch (SQLException e) {
	            e.printStackTrace();
	            return false;
	        }
	    }
	 
	 public List<Roles> getAllRoles() {
	        List<Roles> list = new ArrayList<>();
	        String sql = "SELECT * FROM roles";
	        try (PreparedStatement ps = conn.prepareStatement(sql);
	             ResultSet rs = ps.executeQuery()) {
	            while (rs.next()) {
	                Roles r = new Roles();
	                r.setRoleId(rs.getInt("role_id"));
	                r.setRoleName(rs.getString("role_name"));
	                r.setStatus(rs.getString("status"));
	                r.setCreatedBy(rs.getString("created_by"));
	                r.setCreatedAt(rs.getTimestamp("created_at"));
	                r.setModifiedBy(rs.getString("modified_by"));
	                r.setModifiedAt(rs.getTimestamp("modified_at"));
	                list.add(r);
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return list;
	    }
	 
	 public Roles getRoleById(int id) {
	        String sql = "SELECT * FROM roles WHERE role_id=?";
	        try (PreparedStatement ps = conn.prepareStatement(sql)) {
	            ps.setInt(1, id);
	            try (ResultSet rs = ps.executeQuery()) {
	                if (rs.next()) {
	                    Roles r = new Roles();
	                    r.setRoleId(rs.getInt("role_id"));
	                    r.setRoleName(rs.getString("role_name"));
	                    r.setStatus(rs.getString("status"));
	                    r.setCreatedBy(rs.getString("created_by"));
	                    r.setCreatedAt(rs.getTimestamp("created_at"));
	                    r.setModifiedBy(rs.getString("modified_by"));
	                    r.setModifiedAt(rs.getTimestamp("modified_at"));
	                    return r;
	                }
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return null;
	    }

}
