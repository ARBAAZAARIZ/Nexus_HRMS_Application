package dao.reportDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import helper.reportHelper.BbLeaveReportHelper;
import util.BbPaginationHelper;

public class BbLeaveReportDAO {
    private Connection conn;

    public BbLeaveReportDAO(Connection conn) {
        this.conn = conn;
    }

    public int getTotalLeaves(int year) throws Exception {
        String sql = "SELECT COUNT(*) FROM leave_requests WHERE YEAR(start_date)=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    public int getApprovedLeaves(int year) throws Exception {
        String sql = "SELECT COUNT(*) FROM leave_requests WHERE status='Approved' AND YEAR(start_date)=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }


    public int getPendingLeaves(int year) throws Exception {
        String sql = "SELECT COUNT(*) FROM leave_requests WHERE status='Pending' AND YEAR(start_date)=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    public int getRejectedLeaves(int year) throws Exception {
        String sql = "SELECT COUNT(*) FROM leave_requests WHERE status='Rejected' AND YEAR(start_date)=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) {
                rs.next();
                return rs.getInt(1);
            }
        }
    }

    
    public List<String> getDeptNames() throws Exception {
        String sql = "SELECT d.department_name " +
                     "FROM departments d " +
                     "ORDER BY d.department_id";
        List<String> names = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                names.add(rs.getString("department_name"));
            }
        }
        return names;
    }

    public List<Integer> getDeptCounts() throws Exception {
        
        String sql = "SELECT d.department_id, COUNT(lr.leave_request_id) AS total " +
                     "FROM departments d " +
                     "LEFT JOIN users u ON d.department_id = u.department_id " +
                     "LEFT JOIN leave_requests lr ON lr.user_id = u.user_id " +
                     "GROUP BY d.department_id " +
                     "ORDER BY d.department_id";
        List<Integer> counts = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                counts.add(rs.getInt("total"));
            }
        }
        return counts;
    }
    
    public List<Integer> getMonthlyTrends(int year) throws Exception {
        String sql = "SELECT MONTH(start_date) AS month, COUNT(*) AS total " +
                     "FROM leave_requests " +
                     "WHERE YEAR(start_date)=? " +
                     "GROUP BY MONTH(start_date)";
        int[] monthly = new int[12];
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, year);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    monthly[rs.getInt("month") - 1] = rs.getInt("total");
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int val : monthly) result.add(val);
        return result;
    }

    public BbPaginationHelper<BbLeaveReportHelper> getLeaveList(int page, int pageSize) throws Exception {
        int totalRecords = 0;
        try (PreparedStatement ps = conn.prepareStatement("SELECT COUNT(*) FROM leave_requests")) {
            ResultSet rs = ps.executeQuery();
            if (rs.next()) totalRecords = rs.getInt(1);
        }

        int offset = (page - 1) * pageSize;
        String sql = "SELECT lr.leave_request_id, CONCAT(u.first_name,' ',u.last_name) AS userName, " +
                     "ml.leave_type_name, lr.start_date, lr.end_date, lr.number_of_days, " +
                     "lr.reason, lr.approved_by, lr.status, " +
                     "CASE WHEN lr.status='Approved' THEN CONCAT('Approved on ', lr.approved_at) " +
                     "ELSE lr.status END AS statusHistory, " +
                     "u.profile_picture " +
                     "FROM leave_requests lr " +
                     "JOIN users u ON lr.user_id = u.user_id " +
                     "JOIN master_leaves ml ON lr.leave_type_id = ml.leave_type_id " +
                     "ORDER BY lr.leave_request_id DESC LIMIT ? OFFSET ?";

        List<BbLeaveReportHelper> list = new ArrayList<>();
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, pageSize);
            ps.setInt(2, offset);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                BbLeaveReportHelper h = new BbLeaveReportHelper(
                    rs.getInt("leave_request_id"),
                    rs.getString("userName"),
                    rs.getString("leave_type_name"),
                    rs.getString("start_date"),
                    rs.getString("end_date"),
                    rs.getInt("number_of_days"),
                    rs.getString("reason"),
                    rs.getString("approved_by"),
                    rs.getString("status"),
                    rs.getString("statusHistory"),
                    rs.getString("profile_picture")
                );
                list.add(h);
            }
        }
        return new BbPaginationHelper<>(list, totalRecords, pageSize, page);
    }

}
