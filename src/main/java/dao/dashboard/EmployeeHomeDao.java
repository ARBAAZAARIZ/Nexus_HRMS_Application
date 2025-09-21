package dao.dashboard;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import helper.dashboardHelper.EmployeeDashboardMetrics;
import util.DatabaseConnection;

public class EmployeeHomeDao {

    // Fetch basic employee info and counts relevant for dashboard
    public EmployeeDashboardMetrics employeeGetDashboardMetrics(int userId) {
        EmployeeDashboardMetrics metrics = new EmployeeDashboardMetrics();

        try (Connection conn = DatabaseConnection.getConnection()) {
            // Employee basic info (role, department, designation, reporting manager)
            String sqlInfo = "SELECT r.role_name, d.department_name, des.designation_name, "
                    + "u.date_of_joining, mgr.first_name AS mgr_first, mgr.last_name AS mgr_last "
                    + "FROM users u "
                    + "LEFT JOIN roles r ON u.role_id = r.role_id "
                    + "LEFT JOIN departments d ON u.department_id = d.department_id "
                    + "LEFT JOIN designation des ON u.designation_id = des.designation_id "
                    + "LEFT JOIN users mgr ON u.reporting_manager = mgr.user_id "
                    + "WHERE u.user_id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sqlInfo)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        metrics.setRoleName(rs.getString("role_name"));
                        metrics.setDepartmentName(rs.getString("department_name"));
                        metrics.setDesignationName(rs.getString("designation_name"));
                        metrics.setDateOfJoining(rs.getDate("date_of_joining"));
                        String mgrName = rs.getString("mgr_first") != null ? (rs.getString("mgr_first") + " " + rs.getString("mgr_last")) : "No Manager";
                        metrics.setReportingManagerName(mgrName);
                    }
                }
            }

            // Count upcoming trainings for this employee
            String sqlUpcomingTrainings = "SELECT COUNT(*) FROM training WHERE user_id = ? AND start_date >= CURDATE() AND status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sqlUpcomingTrainings)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        metrics.setUpcomingTrainings(rs.getInt(1));
                    }
                }
            }

            // Count completed trainings for this employee
            String sqlCompletedTrainings = "SELECT COUNT(*) FROM training WHERE user_id = ? AND end_date < CURDATE() AND status='ACTIVE'";
            try (PreparedStatement ps = conn.prepareStatement(sqlCompletedTrainings)) {
                ps.setInt(1, userId);
                try (ResultSet rs = ps.executeQuery()) {
                    if (rs.next()) {
                        metrics.setCompletedTrainings(rs.getInt(1));
                    }
                }
            }

            // You can add more employee-specific metrics here

        } catch (Exception e) {
            e.printStackTrace();
        }

        return metrics;
    }
}
