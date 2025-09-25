package dao.nexusDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import model.JDepartmentModel;
import util.DatabaseConnection;

public class JDepartmentDAO {

    public List<JDepartmentModel> fetchAll() {
        List<JDepartmentModel> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String q = "select department_id, department_name from departments where status='ACTIVE'";
            PreparedStatement ps = conn.prepareStatement(q);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                JDepartmentModel d = new JDepartmentModel();
                d.setDepartment_id(rs.getInt("department_id"));
                d.setDepartment_name(rs.getString("department_name"));
                list.add(d);
            }
        } catch (Exception e) {
            System.out.println("Error fetchAllDepartments: " + e);
        }
        return list;
    }
}
