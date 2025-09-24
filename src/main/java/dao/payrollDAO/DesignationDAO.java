package dao.payrollDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import helper.employeeHelper.DesignationHelper;
import util.DatabaseConnection;

public class DesignationDAO {
	
	Connection conn=DatabaseConnection.getConnection();
	
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

}
