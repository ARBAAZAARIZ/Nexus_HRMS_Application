package dao.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedHashMap;
import java.util.Map;

import helper.dashboardHelper.AdminDashboardMetrics;
import util.DatabaseConnection;

public class AdminHomeDao {

    public AdminDashboardMetrics getAdminDashboardMetrics() {
        AdminDashboardMetrics metrics = new AdminDashboardMetrics();

        try (Connection conn = DatabaseConnection.getConnection()) {
            
            String sql1 = "SELECT COUNT(*) FROM users";
            try (PreparedStatement ps = conn.prepareStatement(sql1);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setTotalEmployees(rs.getInt(1));
            }

             
            String sql2 = "SELECT COUNT(*) FROM users WHERE status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql2);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setActiveEmployees(rs.getInt(1));
            }

             
            String sql3 = "SELECT COUNT(*) FROM users WHERE status='INACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql3);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setInactiveEmployees(rs.getInt(1));
            }

           
            String sql4 = "SELECT COUNT(*) FROM departments WHERE status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql4);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setActiveDepartments(rs.getInt(1));
            }

            
            String sql5 = "SELECT COUNT(*) FROM roles WHERE status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql5);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setActiveRoles(rs.getInt(1));
            }

            
            String sql6 = "SELECT COUNT(*) FROM designation WHERE status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql6);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setActiveDesignations(rs.getInt(1));
            }

             
            String sql7 = "SELECT COUNT(*) FROM trainers WHERE status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql7);
                 ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setActiveTrainers(rs.getInt(1));
            }

             
            String sql8 = "SELECT COUNT(*) FROM training WHERE start_date >= CURDATE() AND status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql8); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setUpcomingTrainings(rs.getInt(1));
            }

             
            String sql9 = "SELECT COUNT(*) FROM training WHERE end_date < CURDATE() AND status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql9); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setCompletedTrainings(rs.getInt(1));
            }

           
            String sql10 = "SELECT COUNT(*) FROM training WHERE status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sql10); ResultSet rs = ps.executeQuery()) {
                if (rs.next()) metrics.setTotalTrainings(rs.getInt(1));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return metrics;
    }
    
    
    
    public Map<String, Integer> getEmployeeCountByDepartment() {
        Map<String, Integer> deptCount = new LinkedHashMap<>();
        String sql = "SELECT d.department_name, COUNT(u.user_id) AS total FROM departments d " +
                     "LEFT JOIN users u ON d.department_id = u.department_id " +
                     "GROUP BY d.department_id ORDER BY d.department_name ASC";

        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                deptCount.put(rs.getString("department_name"), rs.getInt("total"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return deptCount;
    }

    
}
