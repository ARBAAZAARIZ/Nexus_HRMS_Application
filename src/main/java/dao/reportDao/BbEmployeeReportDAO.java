package dao.reportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.List;

import helper.reportHelper.BbEmployeeReportHelper;

public class BbEmployeeReportDAO {
    private Connection con;

    public BbEmployeeReportDAO(Connection con) {
        this.con = con;
    }

    public List<BbEmployeeReportHelper> getEmployeesPaginated(int offset, int pageSize) throws SQLException {
        List<BbEmployeeReportHelper> list = new ArrayList<>();
        String sql ="SELECT u.user_id, CONCAT(u.first_name,' ',u.last_name) AS name, " +
                "u.email, d.department_name, u.contact_number, u.date_of_joining, u.status, " +
                "u.profile_picture " +
                "FROM users u " +
                "JOIN departments d ON u.department_id = d.department_id " +
                "ORDER BY u.user_id DESC " +
                "LIMIT ? OFFSET ?";
        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    list.add(new BbEmployeeReportHelper(
                            rs.getInt("user_id"),
                            rs.getString("name"),
                            rs.getString("email"),
                            rs.getString("department_name"),
                            rs.getString("contact_number"),
                            rs.getDate("date_of_joining"),
                            rs.getString("status"),
                            rs.getString("profile_picture")
                    ));
                }
            }
        }
        return list;
    }

    public int getTotalEmployees() throws SQLException {
        String sql = "SELECT COUNT(*) FROM users";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }

    public int getActiveEmployees() throws SQLException {
        String sql = "SELECT COUNT(*) FROM users WHERE status='ACTIVE'";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }

    public int getTotalDepartments() throws SQLException {
        String sql = "SELECT COUNT(*) FROM departments";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }

    public int getTotalRoles() throws SQLException {
        String sql = "SELECT COUNT(*) FROM roles";
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            rs.next();
            return rs.getInt(1);
        }
    }

    public Map<String, Integer> getMonthlyActiveInactive(String year) throws SQLException {
        Map<String, Integer> stats = new HashMap<>();

      
        for (int m = 1; m <= 12; m++) {
            stats.put(m + "_ACTIVE", 0);
            stats.put(m + "_INACTIVE", 0);
        }

        String sql = "SELECT MONTH(date_of_joining) AS month, " +
                     "SUM(CASE WHEN status = 'ACTIVE' THEN 1 ELSE 0 END) AS activeCount, " +
                     "SUM(CASE WHEN status = 'INACTIVE' THEN 1 ELSE 0 END) AS inactiveCount " +
                     "FROM users " +
                     "WHERE YEAR(date_of_joining) = ? " +
                     "GROUP BY MONTH(date_of_joining) " +
                     "ORDER BY month";

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, Integer.parseInt(year));

            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    int month = rs.getInt("month");
                    int active = rs.getInt("activeCount");
                    int inactive = rs.getInt("inactiveCount");

                    stats.put(month + "_ACTIVE", active);
                    stats.put(month + "_INACTIVE", inactive);
                }
            }
        }

        return stats;
    }
}
