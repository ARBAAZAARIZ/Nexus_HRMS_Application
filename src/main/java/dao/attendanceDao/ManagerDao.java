package dao.attendanceDao;

import model.TimeSheet;
import util.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ManagerDao {


    public List<TimeSheet> getPendingTimeSheets() throws SQLException {
        List<TimeSheet> list = new ArrayList<>();
        String sql = "SELECT ts.*, u.first_name FROM time_sheet ts JOIN users u ON ts.user_id = u.user_id WHERE ts.status='Pending'";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                TimeSheet ts = new TimeSheet();
                ts.setTime_sheet_id(rs.getInt("time_sheet_id"));
                ts.setUser_id(rs.getInt("user_id"));
                ts.setUsername(rs.getString("first_name"));
                ts.setDate(rs.getDate("date"));
                ts.setWorking_hours(rs.getDouble("working_hours"));
                ts.setStatus(rs.getString("status"));
                ts.setApproved_at(rs.getTimestamp("approved_at"));
                list.add(ts);
            }
        }
        return list;
    }


    public void approveTimeSheet(int timeSheetId) throws SQLException {
        String sql = "UPDATE time_sheet SET status='Approved', approved_at=NOW() WHERE time_sheet_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, timeSheetId);
            ps.executeUpdate();
        }
    }

    public void updateStatus(int timeSheetId, String status) throws SQLException {
        String sql = "UPDATE time_sheet SET status=?, approved_at=NOW() WHERE time_sheet_id=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, status);
            ps.setInt(2, timeSheetId);
            ps.executeUpdate();
        }
    }
    public void saveOrUpdateTimeSheet(int userId, Date date, double workingHours) throws SQLException {
        String sql = "INSERT INTO time_sheet(user_id, date, working_hours) VALUES(?, ?, ?) " +
                     "ON DUPLICATE KEY UPDATE working_hours=?";
        try (Connection conn = DatabaseConnection.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, userId);
            ps.setDate(2, date);
            ps.setDouble(3, workingHours);
            ps.setDouble(4, workingHours);
            ps.executeUpdate();
        }
    }
}
