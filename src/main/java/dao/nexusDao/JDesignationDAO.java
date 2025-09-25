package dao.nexusDao;

import model.JDesignation;
import util.DatabaseConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDesignationDAO {

    public List<JDesignation> fetchAll() {
        List<JDesignation> list = new ArrayList<>();
        try (Connection conn = DatabaseConnection.getConnection()) {
            String sql = "SELECT designation_id, designation_name FROM designation";
            PreparedStatement ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                JDesignation d = new JDesignation();
                d.setDesignation_id(rs.getInt("designation_id"));
                d.setDesignation_name(rs.getString("designation_name"));
                list.add(d);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }
}
