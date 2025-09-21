package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.*;

import helper.employeeHelper.DesignationHelper;
import model.Designations;
import util.DatabaseConnection;

public class DesignationDAO {

	private Connection conn;
	
	public DesignationDAO() {
		conn=DatabaseConnection.getConnection();
	}
	
    public boolean addDesignation(Designations d) {
        String sql = "INSERT INTO designation (designation_name, department_id, number_of_employee, status, created_by) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getDesignationName());
            ps.setInt(2, d.getDepartmentId());
            ps.setInt(3, d.getNumberOfEmployee());
            ps.setString(4, d.getStatus());
            ps.setString(5, d.getCreatedBy());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public boolean updateDesignation(Designations d) {
        String sql = "UPDATE designation SET designation_name=?, department_id=?, number_of_employee=?, status=?, modified_by=? WHERE designation_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getDesignationName());
            ps.setInt(2, d.getDepartmentId());
            ps.setInt(3, d.getNumberOfEmployee());
            ps.setString(4, d.getStatus());
            ps.setString(5, d.getModifiedBy());
            ps.setInt(6, d.getDesignationId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public List<DesignationHelper> getAllDesignations() {
        List<DesignationHelper> list = new ArrayList<>();
        String sql = "SELECT d.*, dept.department_name FROM designation d JOIN departments dept ON d.department_id = dept.department_id";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                DesignationHelper dh = new DesignationHelper();
                dh.setDesignationId(rs.getInt("designation_id"));
                dh.setDesignationName(rs.getString("designation_name"));
                dh.setDepartmentId(rs.getInt("department_id"));
                dh.setDepartmentName(rs.getString("department_name"));
                dh.setNumberOfEmployee(rs.getInt("number_of_employee"));
                dh.setStatus(rs.getString("status"));
                dh.setCreatedBy(rs.getString("created_by"));
                dh.setCreatedAt(rs.getTimestamp("created_at"));
                dh.setModifiedBy(rs.getString("modified_by"));
                dh.setModifiedAt(rs.getTimestamp("modified_at"));
                list.add(dh);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
    
    public Designations getDesignationById(int id) {
        String sql = "SELECT * FROM designation WHERE designation_id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    Designations d = new Designations();
                    d.setDesignationId(rs.getInt("designation_id"));
                    d.setDesignationName(rs.getString("designation_name"));
                    d.setDepartmentId(rs.getInt("department_id"));
                    d.setNumberOfEmployee(rs.getInt("number_of_employee"));
                    d.setStatus(rs.getString("status"));
                    d.setCreatedBy(rs.getString("created_by"));
                    d.setCreatedAt(rs.getTimestamp("created_at"));
                    d.setModifiedBy(rs.getString("modified_by"));
                    d.setModifiedAt(rs.getTimestamp("modified_at"));
                    return d;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    
    
    
 
    
    
    public List<Designations> getByDepartment(int deptId) {
        List<Designations> list = new ArrayList<>();
        String sql = "SELECT designation_id, designation_name FROM designation WHERE department_id = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                Designations d = new Designations();
                d.setDesignationId(rs.getInt("designation_id"));
                d.setDesignationName(rs.getString("designation_name"));
                list.add(d);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
    
    
    public List<DesignationHelper> getDesignationsByDepartment(int deptId) {
        List<DesignationHelper> list = new ArrayList<>();
        String sql = "SELECT d.*, dep.department_name FROM designation d " +
                     "JOIN departments dep ON d.department_id = dep.department_id " +
                     "WHERE d.department_id = ? AND d.status = 'ACTIVE'";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deptId);
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                DesignationHelper des = new DesignationHelper();
                des.setDesignationId(rs.getInt("designation_id"));
                des.setDesignationName(rs.getString("designation_name"));
                des.setDepartmentId(rs.getInt("department_id"));
                des.setDepartmentName(rs.getString("department_name")); // Added department name
                des.setNumberOfEmployee(rs.getInt("number_of_employee"));
                des.setStatus(rs.getString("status"));
                list.add(des);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }



    


    

    
    
}
