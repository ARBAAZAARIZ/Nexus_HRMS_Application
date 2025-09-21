package dao.employeeDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.Departments;
import util.DatabaseConnection;

public class DepartmentDAO {

	public DepartmentDAO() {
		// TODO Auto-generated constructor stub
	}

	
	 public boolean addDepartment(Departments dept) {
	        String sql = "INSERT INTO departments (department_name, status, created_by, modified_by) VALUES (?, ?, ?, NULL)";
	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setString(1, dept.getDepartmentName());
	            stmt.setString(2, dept.getStatus());
	            stmt.setString(3, dept.getCreatedBy()); 

	            int rows = stmt.executeUpdate();
	            return rows > 0;

	        } catch (Exception e) {
	            System.out.println("Error in DepartmentDAO: " + e.getMessage());
	            return false;
	        }
	    }
	 
	 
	 public List<Departments> getAllDepartments() {
		    List<Departments> departments = new ArrayList<Departments>();
		    String sql = "SELECT * FROM departments ORDER BY department_id DESC";

		    try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql);
		         ResultSet rs = stmt.executeQuery()) {

		        while (rs.next()) {
		            Departments dept = new Departments();
		            dept.setDepartmentId(rs.getInt("department_id"));
		            dept.setDepartmentName(rs.getString("department_name"));
		            dept.setStatus(rs.getString("status"));
		            dept.setNumberOfEmployee(rs.getInt("number_of_employee"));
		            dept.setCreatedAt(rs.getTimestamp("created_at"));
		            dept.setModifiedAt(rs.getTimestamp("modified_at"));
		            dept.setCreatedBy(rs.getString("created_by"));
		            dept.setModifiedBy(rs.getString("modified_by"));
		            departments.add(dept);
		        }

		    } catch (Exception e) {
		        System.out.println("Error fetching departments: " + e.getMessage());
		    }

		    return departments;
		}
	 
	 public Departments getDepartmentById(int id) {
		    String sql = "SELECT * FROM departments WHERE department_id = ?";
		    Departments dept = null;

		    try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {

		        stmt.setInt(1, id);
		        try (ResultSet rs = stmt.executeQuery()) {
		            if (rs.next()) {
		                dept = new Departments();
		                dept.setDepartmentId(rs.getInt("department_id"));
		                dept.setDepartmentName(rs.getString("department_name"));
		                dept.setStatus(rs.getString("status"));
		                dept.setNumberOfEmployee(rs.getInt("number_of_employee"));
		                dept.setCreatedBy(rs.getString("created_by"));
		                dept.setCreatedAt(rs.getTimestamp("created_at"));
		                dept.setModifiedBy(rs.getString("modified_by"));
		                dept.setModifiedAt(rs.getTimestamp("modified_at"));
		            }
		        }
		    } catch (Exception e) {
		        System.out.println("Error in getDepartmentById: " + e.getMessage());
		    }

		    return dept;
		}
	 
	 public boolean updateDepartment(Departments dept) {
		    String sql = "UPDATE departments SET department_name = ?, status = ?, modified_by = ? WHERE department_id = ?";
		    try (Connection conn = DatabaseConnection.getConnection();
		         PreparedStatement stmt = conn.prepareStatement(sql)) {

		        stmt.setString(1, dept.getDepartmentName());
		        stmt.setString(2, dept.getStatus());
		        stmt.setString(3, dept.getModifiedBy());
		        stmt.setInt(4, dept.getDepartmentId());

		        return stmt.executeUpdate() > 0;

		    } catch (Exception e) {
		        System.out.println("Error updating department: " + e.getMessage());
		        return false;
		    }
		}



}
